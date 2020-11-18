# Important Information

1. This Application uses Java 1.8, Spring Boot 2.4 and JUnit 4.

2. Run [mvn clean install] to install and run all the test cases.

3. To run SonarQube report run [mvn sonar:sonar] after starting the SonarQube service. Report will be accessible in http://localhost:9000/

4. Class diagram is added in project base path. Filename: ClassDiagram.jpg

5. Code coverage is run using EclEmma coverage tool. To run the code coverage scan in IDE, Right-click on project>Coverage As>Junit Test.
Screenshot is added in project base path. FileName: EclEmmaCodeCoverage.jpg

6. SonarQube report screenshot is added in project base path. FileName: SonarQubeReport.jpg

7. Error Logging is done using slf4j


# Information on entities involved

**Item** represents products along with quantity

**User** represents end user purchasing the items, contains attribute like usertype and registration date

**Product** represents each product, contains attributes like price, type of product