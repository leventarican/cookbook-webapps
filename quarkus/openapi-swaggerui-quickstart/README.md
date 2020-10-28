# OpenAPI and Swagger UI
* example based on: https://quarkus.io/guides/openapi-swaggerui
* create initial project
```
mvn io.quarkus:quarkus-maven-plugin:1.9.0.Final:create \
    -DprojectGroupId=org.acme \
    -DprojectArtifactId=openapi-swaggerui-quickstart \
    -DclassName="org.acme.openapi.swaggerui.FruitResource" \
    -Dpath="/fruits" \
    -Dextensions="resteasy-jsonb"
cd openapi-swaggerui-quickstart
```
* navigate into this directory and launch your application with `mvn quarkus:dev`
* app will be accessible on `http://localhost:8080`
