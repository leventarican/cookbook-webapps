# create project
* check https://code.quarkus.io/

# add extensions
* example: add REST client with Maven
* alternativly you can add the dependency directly in your `pom.xml`
```
mvn quarkus:add-extension -Dextensions="io.quarkus:quarkus-rest-client"
```
* example with pom.xml snippet
```
<dependency>
	<groupId>io.quarkus</groupId>
	<artifactId>quarkus-rest-client</artifactId>
</dependency>
```

# run
* expose server (default port: 8080) with your app
```
mvn compile quarkus:dev
```

