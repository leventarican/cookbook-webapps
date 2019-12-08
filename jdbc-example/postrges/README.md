# postgres JDBC with Java EE

* example with payara5
* ensure that you have a copy of postgres JDBC lib: https://jdbc.postgresql.org/download.html

```
payara5/glassfish/domains/domain1/libpostgresql-42.2.9.jar
```

* details under: https://blog.payara.fish/using-postgresql-with-payara-server
* localhost:4848 > Resources > JDBC Connection Pools > New

```
Pool Name: postgresPool
Resource Type: javax.sql.DataSource
Database Driver Vendor: Postgresql
```

* > Next > (set properties) > Ping (for a test)

```
User: postgres
Server: localhost
Password: ""
```

* Resources > JDBC > JDBC Resources > New.

```
JNDI Name: jdbc/postgrespool
Pool Name: postgresPool
```

