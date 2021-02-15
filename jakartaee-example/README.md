# Jakartaa EE
* project was created with archetype `jakartaee-essentials-archetype` 
* either use `mvn` or an ide (netbeans, ...)
```
mvn archetype:generate -DarchetypeGroupId=com.airhacks -DarchetypeArtifactId=jakartaee-essentials-archetype -DarchetypeVersion=0.0.7
```
* this project is using payara as base image instead of glassfish: `FROM airhacks/payara`
* build and run (container will be deleted if its already exists): `buildAndRun.sh`
* or delete manually: `docker rm -f <container-name>`
```
curl localhost:8080/jakartaee-example/resources/ping
Enjoy Jakarta EE 8 with MicroProfile 3+!
```

## Test
* ensure that server with deployed app is running
```
cd jakartaee-example-st
mvn test-compile failsafe:integration-test
```

## Links
* https://github.com/AdamBien/JakartaEE-essentials-archetype
* https://www.adam-bien.com/roller/abien/entry/setup_creation_and_system_test
