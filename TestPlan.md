# Trello CRUD Project Test Plan

Prepared by:  
Mohamed Ebada
Aug 3, 2024

## TABLE OF CONTENTS

1.0 INTRODUCTION  
2.0 [OBJECTIVES AND TASKS](#20-objectives-and-tasks)  
&nbsp;&nbsp;&nbsp;&nbsp;2.1 Objectives  
&nbsp;&nbsp;&nbsp;&nbsp;2.2 Tasks  
3.0 SCOPE  
4.0 [Testing Strategy](#40-testing-strategy)  
&nbsp;&nbsp;&nbsp;&nbsp;4.1 [API Testing](#42-api-testing)  
&nbsp;&nbsp;&nbsp;&nbsp;4.2 [UI Testing](#43-ui-testing)  
5.0 [Hardware Requirements](#50-hardware-requirements)  
6.0 [Environment Requirements](#60-environment-requirements)   
&nbsp;&nbsp;&nbsp;&nbsp;6.1 Workstation  
7.0 [Test Schedule](#70-test-schedule)  
8.0 [Control Procedures](#80-control-procedures)  
9.0 [Features to Be Tested](#90-features-to-be-tested)  
10.0 [Features Not to Be Tested](#100-features-not-to-be-tested)  
11.0 Resources/Roles  

## 1.0 INTRODUCTION

This test plan outlines the strategy, objectives, and tasks for testing the [`board-mod`] module Covering Trello board CRUD operations. The tests are provided in ['automated-tests'] module including automated tests for API testing and UI testing of the Trello board management system.

## 2.0 OBJECTIVES AND TASKS

### 2.1 Objectives

- Ensure the [`automated-tests`] module meets the specified requirements.
- Identify and fix defects in the module.
- Validate the integration of the module with other components of the project.

### 2.2 Tasks

- Develop and execute test cases.
- Perform API testing for Trello board CRUD operations.
- Perform UI Testing.
- Automate API tests using BDD.
- Automate UI tests.
- Document and report test results.
- Track and manage defects.

## 3.0 SCOPE

The scope of this test plan includes all functionalities covered by the [`board-mod`] module, including unit tests, API tests, and UI tests for the Trello board management system.

## 4.0 Testing Strategy

### 4.1 API Testing

- Validate Trello board CRUD operations using ['Trello Rest API'](#https://developer.atlassian.com/cloud/trello/rest/api-group-actions/#api-group-actions)
- Validate positive and negative scenarios of board Create, Retrieve, Update, and Delete operations.
- Use Cucumber (BDD) for API tests.

### 4.2 UI Testing

- Validate Trello board CRUD operations using the browser (Manual).
- Automate manual UI tests using Selenium.
- Identify any remaining issues before the final release.

## 5.0 Hardware Requirements

- Development and testing machines with at least 8GB RAM and 4 CPU cores.

## 6.0 Environment Requirements

### 6.1 Workstation

- Java 11 or higher.
- Maven 3.8.4 or higher.
- Selenium and Unirest Java Libraries.

## 7.0 Test Schedule

- Unit Testing: [AUG 2, 2024] - [AUG 3, 2024]
- API Testing: [AUG 2, 2024] - [AUG 3, 2024]
- UI Testing: [AUG 2, 2024] - [AUG 3, 2024]


## 8.0 Control Procedures

- Use a version control system (e.g., Git) for managing code changes.
- Use a defect tracking system (e.g., JIRA) for managing defects.
- Regularly review and update test cases (according to release schedule).

## 9.0 Features to Be Tested

- Trello board creation, modification, retrieval, and deletion.
- Integration with Trello API.
- User interface functionalities.

## 10.0 Features Not to Be Tested

- Third-party integrations not directly related to Trello board management.
- Non-functional requirements like security and performance.

## 11.0 Resources/Roles

- Test Manager: [Mohamed Ebada]
- Test Engineers: [Mohamed Ebada]
- Developers: [Mohamed Ebada]
- End-Users for UAT: [Mohamed Ebada]
