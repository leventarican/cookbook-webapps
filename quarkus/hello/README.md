# quarkus
* quarkus uses eclipse microprofile, netty, vert.x, ...
* all you need is java 8 or 11, maven

## hands-on
* generate code: 
```
mvn io.quarkus:quarkus-maven-plugin:1.2.0.Final:create -DprojectGroupId=com.github.leventarican -DprojectArtifactId=hello -DclassName="com.github.leventarican.HelloResource" -Dpath="/hello"
```
* build: `mvn clean package`
* run: `java -jar target/*-runner.jar`
* 0.0.0.0:8080/hello or 0.0.0.0:8080 (for index.html)
