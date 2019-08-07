# straight forward java ee 7 web application
* using Servlets
* maven project based on (Version 1.4)
```
mvn archetype:generate -Dfilter=com.airhacks:javaee7-essentials-archetype -DgroupId=com.github.leventarican -Dversion=0.0.1 -DartifactId=code
```

##config payara for oracle db
* ensure you put oracle thin driver to payara /lib folder
* change default derby driver to oracle driver in configuration > server-config > JVM options
```
-Djdbc.drivers=org.apache.derby.jdbc.ClientDriver
-Djdbc.drivers=oracle.jdbc.OracleDriver
```
* to be java ee compliant add this options
``` 
-Doracle.jdbc.J2EE13Compliant=true
```
__JDBC Connection Pool__
* Resources > JDBC > JDBC Connection Pools
	* name (specify a name): `developer`
	* Resource Type: `javax.sql.DataSource`
	* Classname: `oracle.jdbc.pool.OracleConnectionPoolDataSource`
* add properties for database connection
	* url: `jdbc:oracle:thin:@//localhost:1521/XE`
	* user and password
* do a ping to test the connection
* alternativly you can do this configuration with `asadmin`

__JDBC Resource__
* Resources > JDBC > JDBC Resource
	* change Pool Name to `developer`
