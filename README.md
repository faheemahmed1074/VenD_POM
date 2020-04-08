# automation

Pre-requisites:
  - Java JDK 8 should be installed
  - JAVA_HOME environment variable should be set

Steps to setup:
  - Clone repo: https://github.com/zglue/automation.git
  - Open project on IntelliJ through pom.xml file
  - Checkout develop branch
      - Git checkout -f develop

Steps to execute script:
  - Right click TestSuite1.xml and Run it
  - Wait for full execution
  - After execution is completed, open /reports/ExtentReport.html on Chrome browser to view results

Setup of Jenkins Locally:
Jenkins setup: 
  * Tutorial link: https://www.guru99.com/download-install-jenkins.html
  - Click on Manage Jenkins
  - Click on Global Tool Configuration
  - Under Maven, add Name (“mvnLatest”) and check Install automatically
  - Click on Apply and then Save 

zGlue CICD integration:
  - Click on Create new Job
  - Enter item name, select Freestyle Project and click on OK
  - Click on Configure on left panel
  - Under Source Code Management, select Git
    - Add repo link: https://github.com/zglue/automation.git
    - Add credentials
    - State branch which has to be executed: */develop
  - Under Build, select Add Build Step drop down and select Invoke top-level Maven targets
    - Select mvnLatest under Maven Version
    - In Goals, add mvn clean test
  - Click on Apply and then Save

Execution: 
  - Click on Build Now
  - Simultaneously, click on the newly generated build number under Build History
  - Click on Console Output
