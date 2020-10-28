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
* for openapi add respectivly the extension
```
mvn quarkus:add-extension -Dextensions="quarkus-smallrye-openapi"
```
* now check openapi (yaml) and swagger ui
```
curl http://localhost:8080/openapi
http://localhost:8080/swagger-ui/
```
* for enabling swagger ui in prod set this property in your `application.properties`
```
quarkus.swagger-ui.always-include=true
```
