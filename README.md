# Spring Boot POC

Simple Spring Boot project to understand how implement microservices

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes

### Prerequisites

You will need to create a simple database and create 3 tables. 

Brands<br/>

| Id  | Description |
| ------------- | ------------- |
| 1 | Renault  |
| 2 | Audi  |

Models<br/>

| Id | Description | Brand |
| -- | ----------- | ----- |
| 1 | Clio  | 1 |
| 2 | Megane  | 1 |
| 3 | A3  | 2 |
| 4 | A4  | 2 |

Versions<br/>

| Id | Description | Engine | Price | Model |
| -- | ----------- | ------ | ----- | ----- |
| 1 | CAMPUS 1.2 16V 75 CAMPUS.COM  | 1149 | 10799 | 1 |
| 2 | PRIVILEGE 1.5 DCI 65  | 1461 |	15100 | 1 |
| 3 | AUTHENTIQUE 1.9D  | 1870 |	15702 | 2 |
| 4 | CONFORT 1.9 DTI 80  | 1870 |	14440 | 2 |

(sqlserver configured by default)

### Installing

Only import project in STS and configure database connection. Database properties are defined in "application.properties". Once the database connection is ready, just "Run as..." --> "Spring Boot App"

Then you'll have available 3 operations to retrieve the data from database. Open your browser and type

http://localhost:8080/poc/brands/
http://localhost:8080/poc/models/{brand}
http://localhost:8080/poc/versions/{model}

## Built With

* Spring Tool Suite™ (https://spring.io/tools/sts/all)

## Authors

* ** Alfredo Leon Fernandez ** - *Initial work* - [Tuxito](https://github.com/Tuxito)

