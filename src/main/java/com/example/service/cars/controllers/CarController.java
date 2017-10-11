package com.example.service.cars.controllers;


import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
	
	private static final Logger logger = LoggerFactory.getLogger(CarController.class);	
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@RequestMapping( value = "poc/brands" , 
	         method=RequestMethod.GET, 
	         produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Map<String,Object>> brands() {				
		logger.info("-- Brands requested --");
		String query = "select id, description from brands order by description asc";
		
		try {
			List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);
						
			return rows;		
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping( value = "poc/models/{brand}" , 
	         method=RequestMethod.GET, 
	         produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Map<String,Object>> models(@PathVariable("brand") long brandId) {				
		logger.info("-- Models requested --");
		String query = "select id, description from models where brand = ? order by description asc";
		
		try {
			List<Map<String,Object>> rows = jdbcTemplate.queryForList(query,brandId);
						
			return rows;		
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping( value = "poc/versions/{model}" , 
	         method=RequestMethod.GET, 
	         produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Map<String,Object>> versions(@PathVariable("model") long modelId) {				
		logger.info("-- Models requested --");
		String query = "select id, description, engine, price from versions where model = ? order by description asc";
		
		try {
			List<Map<String,Object>> rows = jdbcTemplate.queryForList(query,modelId);
						
			return rows;		
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
