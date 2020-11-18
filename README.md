# E-commerce Challenge

## [The requirements](./prova_engenharia.md)

## Architetural Definitions
- Java 11
- Spring Boot
- Lombok
- JPA
- Docker
- Mysql 8.*

## Installation
- Clone the project on GitHub:
```
git clone git@github.com:suilan/ecommerce.git
```
- To run the database:
```
docker-compose up
```
- In the **backend** folder:
```
mvn compile && mvn package
```
- In the **frontend** folder:
```
npm install
```

## Run
- To run the **backend**:
```
java -jar target/ecommerce-0.0.1-SNAPSHOT.jar
```
- To run the **frontend**:
```
ng serve -o
```

## Doc
- [REST API Documentation](http://localhost:8080/ecommerce/swagger-ui.html)
- [Postman Tests](./E-commerce.postman_collection.json)
- Github Project - https://github.com/suilan/ecommerce

## Main difficulties
- The business/domain rules, changed multiple times
- Build the relations @OneToMany - @ManyToOne on backend
- CORS Globally on backend
- Auth on backend
- Organize the Dockerfile and docker-compose.yml


