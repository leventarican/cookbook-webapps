
# endpoint
* reachable under: [localhost:8080/postgres-ee/resources/ping]

# Maven

* Maven project was generated with the following command: 
```
mvn archetype:generate -DarchetypeGroupId=com.airhacks -DarchetypeArtifactId=javaee8-essentials-archetype
```

# postgres JDBC with Java EE

* example with payara5
* ensure that you have a copy of postgres JDBC lib: https://jdbc.postgresql.org/download.html

```
payara5/glassfish/domains/domain1/libpostgresql-42.2.9.jar
```

* or add within `asadmin`

```
asadmin> add-library postgresql-42.2.11.jar
Command add-library executed successfully.
```

* details under: https://blog.payara.fish/using-postgresql-with-payara-server

__JDBC Connection Pool__
* localhost:4848 > Resources > JDBC Connection Pools > New

```
Pool Name: postgresPool
Resource Type: javax.sql.DataSource
Database Driver Vendor: Postgresql
```

* > Next > (set properties) > Ping (for a test)
* > Additional Properties > Save
```
User: postgres
Server: localhost
Password: ""
Url: jdbc:postgresql://localhost:5432/developer-db
URL: jdbc:postgresql://localhost:5432/developer-db
```
__JDBC Resources__
* Resources > JDBC > JDBC Resources > New.

```
JNDI Name: jdbc/postgrespool
Pool Name: postgresPool
```

# Build
mvn clean package && docker build -t com.github.leventarican/postgres-ee .

# RUN

docker rm -f postgres-ee || true && docker run -d -p 8080:8080 -p 4848:4848 --name postgres-ee com.github.leventarican/postgres-ee 
