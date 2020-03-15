# decorators
* run: `mvn clean test`

__good to know__
* CDI injects a proxy when a bean is decorated
* the proxy _delegate_ method calls to _decorator_ instead of the bean itself
