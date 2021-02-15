#!/bin/sh
mvn clean package && docker build -t com.github.leventarican/jakartaee-example .
docker rm -f jakartaee-example || true && docker run -d -p 8080:8080 -p 4848:4848 --name jakartaee-example com.github.leventarican/jakartaee-example 
