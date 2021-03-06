# Dogs REST API
Value of  JDBC route from src/main/resources/application.properties:
```spring.datasource.url=jdbc:h2:mem:dogdata```
H2 console enabled with:
```spring.h2.console.enabled=true```
Path to h2:
```spring.h2.console.path=/h2```
There is no password, just login.
![connect_to_h2](src/main/resources/static/images/Dogs-%20connect_to_h2.png)
![run query in h2](src/main/resources/static/images/Dogs%20-%20run%20query.png)
## REST API
![GET dogs](src/main/resources/static/images/Dogs%20-%20getDogs.png)
![GET breed of id that exists in the db](src/main/resources/static/images/Dogs%20-%20get%20breed%20of%20id%20that%20exists%20in%20the%20db.png)
![GET breed of id that doesn't exist in the db](src/main/resources/static/images/Dogs%20-%20get%20breed%20of%20id%20that%20doesn't%20exist%20in%20the%20db.png)

## GRAPHQL
![query](src/main/resources/static/images/Dogs%20-%20graphQL%20query.png)
![mutation](src/main/resources/static/images/Dogs%20-%20graphQL%20mutation.png)

## MICROSERVICES
Only the entity and repository folders are needed for microservices. Check more info [in the parent project](https://github.com/Ioana-Postolache/dogs-multi-modules#readme)

## Basic auth
![Basic auth](src/main/resources/static/images/Spring%20Security%20-%20Basic%20Auth.png)

## Swagger UI
Swagger available at: http://localhost:8762/swagger-ui/index.html
![Added swagger](src/main/resources/static/images/Swagger-UI.png)
