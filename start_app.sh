#!/bin/bash

chmod +x target/hcservices-0.0.1-SNAPSHOT.jar

if [ -e "target/hcservices-0.0.1-SNAPSHOT.jar" ]; then
    echo "Run application: target/hcservices-0.0.1-SNAPSHOT.jar"
    java -jar target/hcservices-0.0.1-SNAPSHOT.jar
else
    echo "Exception: JAR-file not found."
fi