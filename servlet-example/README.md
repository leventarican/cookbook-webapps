# minimum servlet demo
* we have only a web.xml and a Servlet
* sample based on java ee 5 (Servlet 2.5)
* package and deploy to glassfish
```
javac -cp <GLASSFISH>\glassfish4\glassfish\lib\javaee.jar src\Foobar.java -d WEB-INF\classes & jar cvf <GLASSFISH>\glassfish4\glassfish\domains\domain1\autodeploy\foobar.war WEB-INF
```
* app is now reachable
```
localhost:8080/foobar/Foobar
```
