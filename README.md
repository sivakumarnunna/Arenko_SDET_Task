# Running the test <br />

STEP 1 : Install Java(jdk1.8) and  Apache Maven 3.8.6 then add bin directories to path variable.<br />
STEP 2 : Click on "Diwnload ZIP" from the "code" drop down menu.<br />
It will down loand the project to your local machine.<br />
STEP 3 : Extract the zip file.<br />
STEP 4 : In the file /applicationUnderTest.properties provide valid application property values for below properties. <br />
baseURL=<br />
orderendpoint=<br />
userrname=<br />
password=<br />
STEP 5 :navigate to folder where pom.xml file resides in command promt <br />
STEP 6 : execute command  :   mvn clean verify <br />
STEp 7 : you can find serinity test report at \target\site\serenity\index.html location
