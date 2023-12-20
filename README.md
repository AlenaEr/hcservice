You can run app from IDE or from console.
If you want to do that from console.
Move to your app directory and run with command.
MacOS ./start_app.sh
Linux ./start_app.bat
Windows java -jar target\hcservices-0.0.1-SNAPSHOT.jar

When starting the application, the database will be created automatically.

Now you can see java docs
http://localhost:63342/hcservices/target/site/apidocs/index.html

For convenience, you can use the user interface for look data base. 
For this, follow the link and connect with settings
http://localhost:8080/h2-console

Saved Settings: Generic H2 (Embedded)
Setting Name: Generic H2 (Embedded)
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:


also you can go and test it through swagger,
http://127.0.0.1:8080/swagger-ui/index.html#/
Valid json for first endpoint Submit a new measurement

```json
{
"id": 0,
"userId": 1,
"submittedDateTime": "2023-12-20T15:52:09.245Z",
"fromDateTime": "2023-12-20T15:52:09.245Z",
"toDateTime": "2023-12-20T15:52:09.245Z",
"gasUsage": 60,
"coldWaterUsage": 75,
"hotWaterUsage": 53
}
```

Valid json for second endpoint Get user measurement history
```json
{
"page": 0,
"size": 1
}
```
or
```json
{
"page": 0,
"size": 1,
"sort": [
"submittedDateTime" //specify the field by which you want to sort
]
}
```
TODO LIST
Add Security logic using Spring security or third party app.
Use OAuth, JWT..
Control role of users: admin, guest...

Add more tests(integration, unit, performance)

Add Health check monitoring: for example Spring Boot Actuator, Kibana, Grafana or Melody..

ADd test coverage control: integrate SonarCube, JaCoCo(the simplest check and adjustment of test coverage )

Add additional endpoints

1. Get all user measurements for a specific period:

2. endpoint that takes a user ID and dates "from" and "to" and returns all measurements in that range.
   Retrieve measurement statistics:

For example, an endpoint that returns statistical data about measurements, such as averages, sums, medians, etc.
Update an existing measurement:

3. Add an endpoint to update a specific measurement based on its identifier.
   Delete a measurement:

4. An endpoint to delete a measurement based on its identifier.

Get a list of users:

5. Add an endpoint to retrieve a list of users.

Search measurements based on specific criteria:

6. Add the ability to search for measurements based on criteria such as type, date range, etc.

Retrieve updated information about a measurement:

7. Endpoint that returns updated information about a specific measurement after an update.




