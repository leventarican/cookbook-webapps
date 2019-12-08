
# Maven

* Maven project was generated with the following command: 
```
mvn archetype:generate -DarchetypeGroupId=com.airhacks -DarchetypeArtifactId=javaee8-essentials-archetype
```

# Build
mvn clean package && docker build -t com.github.leventarican/postgres-ee .

# RUN

docker rm -f postgres-ee || true && docker run -d -p 8080:8080 -p 4848:4848 --name postgres-ee com.github.leventarican/postgres-ee 