# java ee 7 and postgresql
* dev environment: ubuntu, netbeans (11.3), payara (Payara Server 5.201), postgresql (docker container), JDK 1.8, Java EE 7
* mainly focus is EJB's
* servlet: http://localhost:8080/jee-postgres/code
* webservice: http://localhost:8080/jee-postgres/data-service?Tester

## postgresql
* i use postgresql in a container
* database: dev; user: dev; pw: dev
* see docker repository for how to create a container and how to create a db and user.

## payara
* add lib to server: `asadmin add-library postgresql.jar`

__set up JDBC resources__
* JDBC Connection Pools
    * Pool Name: `PostgresqlPool`
    * Resource Type: `javax.sql.DataSource`
    * Datasource Classname: `org.postgresql.ds.PGSimpleDataSource`
    * Properties: User=dev; Password=dev; Servername: localhost
* JDBC Resources
    * JNDI Name: `jdbc/__default`
    * Pool Name: `PostgresqlPool`

## code
* add dependeny `eclipseLink` to pom.xml
* create persistence.xml with `JTA` transaction type
* create Entity classes or generate in netbeans: `new > Entity Class from Database`
* use annotation `@PersistenceContext`
* if you use netbeans you can also connect to the database: Services > Databases > Driver PostgreSQL ...
