
__about__
* create a persistence.xml file with type RESOURCE_LOCAL (user managed entity manger)
* use drop-and-create property
* use embedded derby (maven plugin)
* inserts are done via data.sql also in junit file
* use eclipselink as JPA provider
* create and use one JPA Enity (= Developer.class)
* write a junit file for using entitymanger, insert, read, ... data

__run__
```
mvn test -q
```
* -q for quiet: no need to log INFO and WARNING outputs