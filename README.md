# Selenium Extent Framework - Test Automation
**Tech**: Java,Selenium Webdriver, Testng, Maven, Apache POI, Extent Reports, TestNG Parallel

## What I Built
End-to end automation framework with real-features used in MNCs:

### Key Features
- **POM Design**: Page Object Model for maintainable code
- **Data-Driven**: Apache POI reads test data from 'TestData.xlsx'
- **Parallel Execution**: 'ThreadLocal<WebDriver>' + 'testng.xml' runs 3 tests in 9.37s
- **Extent Reports**: HTML report with pass/fail + screenshots on failure
- **Screenshot on Failure**: 'ITestListener' captures UI state at failure

## Test Results
| Tests Run | Passed | Time | Parallel Thread |
| --- | --- | --- | --- |
| 3 | 3 | 9.37s | 3 |

## How to Run
1. 'git clone <repo-url>'
2. 'mvn test'
3. open 'target/ExtentReport.html' for results

## Screenshots
![Extent Report](screenshot.png)
