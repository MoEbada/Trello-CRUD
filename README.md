# Trello CRUD Project

This project is a Maven-based Java application for managing Trello boards. It includes modules for board modifications and automated tests.

## Table of Contents

1. [Project Structure](#project-structure)
2. [Prerequisites](#prerequisites)
3. [Building the Project](#building-the-project)
4. [Running the Application](#running-the-application)
5. [Running Tests](#running-tests)
6. [License](#license)

## Project Structure
Trello_API/
├── LICENSE
├── README.md
└──trello-crud/
    ├── automated-tests/
    │   ├── pom.xml
    │   ├── src/
    │   │   ├── test/
    │   │   │   ├── java/
    │   │   │   └── resources/
    ├── board-mod/
    │   ├── pom.xml
    │   └── src/
    │       └── main/java/com/trello
    │                         ├── model
    │                         └── service
    └── pom.xml

## Prerequisites

- Java 11 or higher
- Maven 3.8.4 or higher
- Docker (optional, for containerization)

## Building the Project

To build the project, navigate to the [`trello-crud`] directory and run:

```sh
mvn clean package
```
This will compile the source code and package it into a JAR file.

## Running the Application
To run the application, navigate to the trello-crud/board-mod directory and execute:
```sh
java -jar target/board-mod-1.0-SNAPSHOT.jar
```

## Running Tests
To run the tests, navigate to the trello-crud directory and execute:

```sh
mvn test
```
This will run all the tests in the automated-tests module.

To generate HTML test report, run:
```sh
mvn site -DgenerateReports=false
mvn surefire-report:report
```
Test report should be gnerated under automated-tests/target/surefire-report.

## License
This project is licensed under the MIT License. See the LICENSE file for details.