# Project README

## Folder Structure
I structured the project's folders and classes as follows:

### `api.endpoints`:
- `Routes.java`: Contains URLs for API endpoints where service calls are made.
- `UserEndPoints.java`: Holds methods written for CRUD operations. These methods obtain endpoint information from the `Routes` class.
- `routes.properties`: As an alternative to class usage, I created a properties file to store URLs for API endpoints.
- `UserEndPointRoutesProperties.java`: Contains methods written for CRUD operations. These methods obtain endpoint information from the `routes.properties` file.

### `api.payload`:
- `User.java`: A Java class defining the payload structure for the User module in Swagger Petstore API.

### `api.tests`:
- Test classes written using the TestNG framework to verify API endpoints.
- `UserTests.java`: Contains the tests I wrote for CRUD operations. Method calls are made through the `UserEndPoints.java` class.
- `UserTestsProperty.java`: Contains the tests I wrote for CRUD operations. Method calls are made through the `UserEndPointsRoutesProperties.java` class.

### `log4j2.xml`:
- Configuration file for the Log4j2 framework used to manage logs. I set up a basic logging structure. Test logs are created under the `logs` folder after running test suites.

### `testng.xml`:
- Configuration file that allows the execution of test classes via TestNG.

### `allure-reports`:
- I used the Allure Reports plug-in for test reports. Test reports are generated under the `reports` folder after running test suites. To view reports, you can use the terminal command `allure serve projectFilePath`.

## Data Management
To create test data, I used a Java library called `javafaker`. This library allows us to generate test data of any desired type randomly. Additionally, test data can also be extracted from a prepared Excel file. 

## POM (Page Object Model)
I chose to use the POM design pattern. This method enhances readability by separating variable and method definitions into separate classes from the test class. It speeds up test writing by offering reusable methods and eases maintenance by centralizing updates.

## Why TestNG over JUnit?
I used the TestNG framework for the following reasons:

- TestNG allows running the same tests with different sets of test data.
- TestNG offers comprehensive reporting and logging capabilities.
- TestNG enables running tests in parallel.

## Jenkins Integration
I implemented a basic integration for remotely launching the remote repository on GitHub using Jenkins.
