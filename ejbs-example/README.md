# enterprise javabeans example

* build EJB JAR
```
javac -cp %GLASSFISHPATH%\lib\javaee.jar src\*.java -d .
```

* create EJB JAR and deploy to glassfish (with autodeploy)
```
jar cvf %AUTODEPLOY%\foobar-ejb.jar FoobarSession.class FoobarSessionBean.class
```

* run client (commandline)
```
java -cp %JAVAEE%\lib\javaee.jar;%JAVAEE%\lib\appserv-rt.jar;. Client
ejb message: foobar
```
