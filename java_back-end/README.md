# Overview<br/>

The backend of this project is built using Java Spring Boot. It serves as the core of the Quickscan tool, managing business logic, data processing, and API communication between the frontend and the database. The backend design focuses on maintainability, scalability, and clean architecture.
This document provides a detailed overview of the backend functionality and includes a detailed map structure explaining the purpose of each module, helping everyone to better understand the tool.

<hr></hr>

# Key Functionalities<br/>

## 1.API Management:

- Accept data sent from the frontend.

- Use HTTP methods such as GET and POST to extend the program's functionality.

- Interfaces are managed using Spring's dependency injection.

## 2.Data Validation:

- Use Java Validation API to verify whether the data received from the frontend is valid.

<hr></hr>

# Project Structure Map

Here is the project structure diagram, along with a detailed introduction to the functionality of each class in the project.

```
├─src
│  └─main
│      ├─java
│      │  └─com
│      │      └─example
│      │          └─demo
│      │              ├─controller
|      |                  ├─InputController
|      |                  └─ValidationController
│      │              ├─entity
|      |                  ├─InputDate
|      |                  └─ValidRequest
│      │              ├─exception
|      |                  └─GlobalExceptionHandler
|      |              └─DemoApplication
│      └─resources
|          ├─application.yml
│          └─mybatis
|          
|   └─pom.xml
```
InputController: Creates the '/list' endpoint to initially test whether the Spring Boot framework can run and whether it can handle effective input and output.

ValidationController: Creates the '/validate' endpoint, using Spring dependency injection and the ValidRequest class to perform initial validation of the data input from the frontend.

InputData: Acts as the data entity class for the '/list' endpoint to test whether the Spring Boot framework can effectively handle input and output.

ValidRequest: Serves as the service class for the '/validate' endpoint, calling the validation API to test whether the Spring Boot backend can effectively validate the data input from the frontend.

GlobExceptionHandler: Acts as the global exception handler to address various exception issues that may be encountered during the testing phase.

DemoApplication: The Spring Boot application entry class, used to launch the entire Spring Boot project.

MyBatis: The configuration class used to prepare for the future implementation of CRUD (Create, Read, Update, Delete) functionality with the database.

application.yml: The Spring Boot configuration class that configures project-related settings.

pom.xml: The Maven configuration file that includes the Spring Boot version and Maven coordinates for the required project dependencies (JAR packages).

