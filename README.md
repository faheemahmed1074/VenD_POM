# automation

###### Pre-requisites:
  - Java JDK 8 should be installed
  - JAVA_HOME environment variable should be set

###### Steps to setup:
  - Clone repo: https://bitbucket.org/venturedive/web-automation-framework/src/master/
  - Open project on IntelliJ through pom.xml file
  - Checkout develop branch
      - Git checkout -f develop

###### Application Configuration File setup:
- Test Trail Integration: set LogTestRail = true  
- jira Integration: set LogJIRA = true
- Send Report through Email: SendEmailAfterExecution = True

###### Steps to execute script:
  - Right click testng.xml and Run it
  - Wait for full execution
  - After execution is completed, open /reports/ExtentReport.html on Chrome browser to view results

###### Framework Understanding Video:

  https://drive.google.com/drive/folders/0BwmieK6G4SFUfm9jMVBGd3YtSlFMVExTV3ZVOTlrOUszcjBMUXRrX1ZGNkotNnowRnNHSGM

###### Setup of Percy:

- Login to percy.io
- Create New project on Percy
- Integrate Github or Bitbucket with your repository
- Get Percy token and export in local machine
- Execute test cases using "npx percy exec -- mvn test"

###### Code Structure:
1- all test cases are in _src/main/java/testcases_ 

2- all pages object are in _src/main/java/objects_

3- all classes i.e base class (hooks), main class etc are in _src/main/java/general_

4- db connection class define in _src/main/java/dbConnection_

5- all application configuration are in _src/main/java/config_

