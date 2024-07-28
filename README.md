# Applifting QA Testing Project

This repository contains the solutions for three QA exercises prepared for an interview at Applifting. The exercises demonstrate skills in test scenario creation, automation using Selenium with Cucumber, and generating detailed test reports.

## Project Structure

- **functional-test**: Contains tests for the Applifting website.
- **online-shopping**: Contains tests for an online shopping application.

## Exercises Overview

### Exercise 1: Test Scenario Creation

In this exercise, detailed test scenarios for an online shopping application were created. The scenarios cover various functionalities like searching for items, browsing categories, viewing item details, adding items to the cart, viewing and updating the cart, and proceeding to checkout.

**Details**:
- The test scenarios are documented in the [online-shopping.md](online-shopping.md) file.

### Exercise 2: Automation of Test Scenarios

This exercise involved selecting five test scenarios from Exercise 1 and automating them using Selenium and Cucumber. The automation scripts ensure that the functionalities like searching, browsing, adding to the cart, and checking out are working correctly.

**Module**: `online-shopping`

**Details**:
- The automated tests are located in the `online-shopping` module.
- The `BaseTest` class provides the setup and teardown methods for the tests.
- The `ShoppingTests` class contains the automated test cases for the selected scenarios.

### Exercise 3: Generating Test Reports

The final exercise required generating a test report for the Applifting website. This was achieved using Selenium and Cucumber, integrated with ExtentReports for detailed reporting.

**Module**: `functional-test`

**Details**:
- The `functional-test` module contains the automation scripts for testing the Applifting website.
- The `ExtentReportListener` class handles the creation of detailed test reports.
- The `Hooks` class sets up the WebDriver and ensures proper reporting integration.
- The `StepDefinitions` class contains the step definitions for the Cucumber tests.
- The test scenarios are defined in the `Applifting.feature` file.
- The generated test report is located in `applifting-test-report.html`.

## Running the Functional tests

To run the tests and generate reports, use the following commands:

1. **Clean and run tests**:
   ```shell
   ./gradlew clean test
   ```
   
## Test report
- The generated test report is located in `applifting-test-report.html`.
- Open the report file and click on the chrome icon in the upper right corner.
- You can see all tests which you can see all the tests that were run (via RunCucumberTest) and the result of their run.
- On the left side of the report there is also a tab for diagrams, where there is a more detailed overview of the test run.
- The failed tests contain a screenshot of where the problem/error occurs.