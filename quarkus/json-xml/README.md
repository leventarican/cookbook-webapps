# JSON and XML serialization / de-serialization

* jackson: JSON, Avro, YAML, XML, ...
    * https://github.com/FasterXML/jackson
* JSON-B: Java API for JSON Binding
    * https://javaee.github.io/jsonb-spec/
* JAXB: Java Architecture for XML Binding
    * https://javaee.github.io/jaxb-v2/

## used quarkus extensions
* RESTEasy JAX-RS: REST endpoint framework implementing JAX-RS and more
* RESTEasy Jackson: Jackson serialization support for RESTEasy
~~* REST Client: Call REST services~~
~~* REST Client Jackson: Enable Jackson serialization for the REST Client~~

## run
```
mvn compile quarkus:dev
```

## curl
* plain text
```
curl -i -v localhost:8080/developer/code

*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /developer/code HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.68.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 OK
HTTP/1.1 200 OK
< Content-Length: 4
Content-Length: 4
< Content-Type: text/plain;charset=UTF-8
Content-Type: text/plain;charset=UTF-8

< 
* Connection #0 to host localhost left intact
code
```
* xml
```
curl -i -H "Accept: application/xml" localhost:8080/developer/code/json-xml
HTTP/1.1 200 OK
Content-Length: 135
Content-Type: application/xml;charset=UTF-8

<?xml version="1.0" encoding="UTF-8" standalone="yes"?><developer><id>0</id><programmingLanguage>java</programmingLanguage></developer>
```
* json 
```
curl -i -H "Accept: application/json" localhost:8080/developer/code/json-xml
HTTP/1.1 200 OK
Content-Length: 39
Content-Type: application/json

{"id":"0","programmingLanguage":"java"}
```

## troubleshooting
* for xml you need to decorate your Entity with JAXB Annotations. if not you could receive the `MessageBodyWriter` error.
* for json you dont need that
```
curl -i -v -H "Accept: application/xml" localhost:8080/developer/code/json-xml

Could not find MessageBodyWriter for response object of type: com.github.leventarican.Developer of media type: application/xml;charset=UTF-8
```

## JAX-RS client example
* check `cookbook` repository: `java > java-lang > com.github.leventarican.client.Rest`
