# Running the test <br />

software prerequisites : Install Java(jdk1.8) and  Apache Maven 3.8.6 then add bin directories to path variable.<br />

STEP 1 : Download and extract the attached ZIP folder into your local windows machine. <br />
STEP 2 :navigate to folder (root folder of the project)  where pom.xml file resides in command promt <br />
STEP 3 : execute command  :   mvn clean verify <br />
If you want to run only smoke test cases use below command <br />
mvn clean verify -Dcucumber.options="--tags '@smoke'"  <br />
STEP 4 : Execute below command to open the serinity test report. <br />
start target\site\serenity\index.html <br />
