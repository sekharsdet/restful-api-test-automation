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
