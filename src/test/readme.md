# Pointr Test Case

###  Pre-conditions for running the project
- Java 
- Maven

### First we need to do maven install without running our tests
- mvn install -DskipTests

### The command to run tests from terminal is as follows;
- mvn test -DBROWSER="BROWSER_TYPE"

#### The BROWSER parameter here represents the type of browser (CHROME, FIREFOX, SAFARI, EDGE) you want to run your tests.

---------

#### For the successful test cases we get the values from config.properties file

---------

#### After run the tests you can get the error logs, search logs, all tests logs and all the screenshots from related folders. Also you can see the report in the cucumber-report folder

---------

#### Also I have created a pipeline for this project by using github action you can check the pipeline results from actions tab. And then you can get all test results as a zip file from pipeline attachment.




