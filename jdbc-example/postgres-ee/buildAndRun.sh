#!/bin/sh
mvn clean package && docker build -t com.github.leventarican/postgres-ee .
docker rm -f postgres-ee || true && docker run -d -p 8080:8080 -p 4848:4848 --name postgres-ee com.github.leventarican/postgres-ee 
