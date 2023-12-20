@echo off

chmod +x target\hcservices-0.0.1-SNAPSHOT.jar

if exist "target\hcservices-0.0.1-SNAPSHOT.jar" (
    echo Running the application: target\hcservices-0.0.1-SNAPSHOT.jar
    java -jar target\hcservices-0.0.1-SNAPSHOT.jar
) else (
    echo Error: JAR file not found.
)