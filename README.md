# Web Automation

###### Pre-requisites:
- Java JDK 8 should be installed by using the url https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html
- JAVA_HOME environment variable should be set
- Android Studio should be installed by using the url https://developer.android.com/studio
- ANDROID_HOME environment variable should be set
- Maven 3.6 version should be installed by using the url https://dlcdn.apache.org/maven/maven-3/3.6.3/binaries/
- Maven environment variable should be set
- Restart the system after completing the above steps

###### Steps to setup:
  - Clone repo: https://bitbucket.org/venturedive/web-automation-framework/src/master/
    - On GitHub.com, navigate to the main page of the repository. 
    - To clone your repository, click on the copy icon
    - Open Git Bash.
    - Change the current working directory to the location where you want the cloned directory.
    - Type git clone, and then paste the URL you copied earlier.
    - $ git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY
    - Press Enter to create your local clone.
  - Create your own branch
    - Click on Branches Tab in Bitbucket
    - Click on Create branch
    - Type your branch name and click on create
  - Open project on IntelliJ
  - Open terminal and run command.
    - mvn clean test
    - git pull
  - Checkout your created branch
    - git checkout origin/yourbranchname

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

###### DataBase Connection

db =

dbUrl=

dbUserName=

dbPassword=2

dbPort =

1-for mysql db set **db=mysql** 

2-for postgres db set **db=postgres**

3-import venture dive jar in POM

4-initialize sonar db class  i.e **SonarDB dbconn= new SonarDB();**

5- use **dbconn.getResult(String query)** for select query return the resultSet

6- use **dbconn.executeQuery(String query)** for update query , delete and insert query



