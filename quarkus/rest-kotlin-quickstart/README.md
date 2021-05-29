# Quarkus and Kotlin

This project was generated with the following command.
```bash
mvn io.quarkus:quarkus-maven-plugin:1.13.6.Final:create -DprojectGroupId=com.github.leventarican -DprojectArtifactId=rest-kotlin-quickstart -DclassName="com.github.leventarican.kotlin.GreetingResource" -Dpath="/greeting" -Dextensions="resteasy,kotlin,resteasy-jackson"
```

Tested with __IntelliJ IDEA__ community edition. When using IntelliJ ensure that Maven is configured properly. Otherwise IntelliJ may use a bundled maven version.
```bash
M2_HOME is set: M2_HOME=<PATH_TO_MAVEN>
MAVEN_REPOSITORY is set: File | Settings | Appearance & Behavior | Path Variables
MAVEN is set: File | Settings | Build, Execution, Deployment | Build Tools | Maven
```
Run with quarkus dev plugin.
```bash
mvn quarkus:dev
```

## Links
https://quarkus.io/guides/kotlin