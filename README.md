# Test Automation for Web and API Tests

## Overview
This project contains automated tests for:
- **Google Search** – Performing search operations.
- **The Internet Heroku Web App** – Validating some UI functionalities.
- **Random Cat Fact API** – Testing API response.


## Technologies Used
- **Java** – Core programming language for writing test scripts.
- **Selenium WebDriver** – For automating browser interactions.
- **Rest Assured** – For API testing.
- **TestNG** – Test framework for managing test execution and reporting.
- **Maven** – Build and dependency management.

## Project Structure
```
TestAutomationHeroKu/
|-- src/
|   |-- main/
|   |   |-- java/
|   |-- test/
|       |-- java/
|           |-- tests/
|           |   |-- InternetHeroKuAppTest.java
|           |   |-- GoogleSearchTest.java
|           |   |-- RandomFactAPITest.java
|           |-- listeners/
|           |   |-- ScreenshotListener.java
|           |-- GooglePage/
|           |   |-- GoogleHomePage.java
|           |-- InternetHeroKuAppPages/
|           |   |-- DynamicLoadingPage.java
|           |   |-- UploadPage.java
|           |-- utils/
|           |   |-- WebDriverFactory.java
|-- pom.xml
|-- testng.xml
|-- README.md
```

## Test Coverage
- **Internet Heroku Web App Tests**  
  - Dynamic Content Loading  
  - File Upload/Download  
- **Google Search Tests**  
  - Search Query Validation  
- **Random Cat Fact API Tests**  
  - Validate API Response Structure  
  - Assert Non-Empty Fact Text  

## How to Run the Tests

### Prerequisites
- Install Java (JDK 11 or higher)
- Install Maven
- Browser (Chrome)

### Running Tests
1. Clone the repository:
   ```
   git clone https://github.com/EamnNabil/TestAutomationHeroKu.git
   ```
2. Navigate to the project directory:
   ```
   cd TestAutomationHeroKu
   ```
3. Run tests using Maven:
   ```
   mvn test
   ```
4. Test reports will be generated in:
   ```
   target/surefire-reports/
   ```

## Test Reports
- After execution, reports can be found in `target/surefire-reports/emailable-report.html`.
- Screenshots are captured on failure and attached to the reports.
