# restful-api-test-automation

Task 1 (Monefy App Exploratory testing charters are placed in **ExploratoryTesting.md** )

## Prerequisites

- Java >=12 
- Maven
- Allure 
- Find the service and set up your environment as explained in this [guide](https://github.com/swagger-api/swagger-petstore).

### To start the project locally:
1. from the root folder please run 
```
mvn clean compile
```
2. To starts tests
```
mvn clean test
```
3. To generate HTML report
```
allure serve 
```
### Tests that are covered

- Pet
  - Adding New Pet
  - Filtering the pet based on status
  - Get all pet details
- User
  - Create user
  - User Login
  - User Logout
- Store
  - Checking the inventory 
  - Placing an order
### Tests
tests are located at `/src/test/java/petstore/tests`

### Solution Overview 
The restful-api-test-automation is a Java project using Maven as a builder, TestNg as a test runner and Rest Assured as an API test framework. The reason I choose Rest Assured is, It removes the need for writing a lot of boilerplate code required to set up an HTTP connection, send a request and receive and parse a response. It supports a Given/When/Then test notation, which instantly makes your tests human-readable and other features that speed the development while keeping the project simple to read/maintain. TestNG makes automated tests more structured, readable, maintainable and user-friendly. Allure Report to show detailed representation of what has been tested. 

models folder contains all the JSON object endpoints poses
builders folder contains POJO classes to supply data to the APIs
