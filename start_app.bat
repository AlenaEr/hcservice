@echo off
mvn clean install
chmod +x target\hcservices-0.0.1-SNAPSHOT.jar
mvn javadoc:javadoc
if exist "target\hcservices-0.0.1-SNAPSHOT.jar" (
    echo Running the application: target\hcservices-0.0.1-SNAPSHOT.jar
    java -jar target\hcservices-0.0.1-SNAPSHOT.jar
) else (
    echo Error: JAR file not found.
    mvn spring-boot:run
)