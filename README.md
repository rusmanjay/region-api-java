# region-api-java
1. Create new database

2. Create file `aplication.properties` under folder `src/main/resources/`
```
server.port=server_port (default 8080)

spring.datasource.url=jdbc:mysql://localhost:3306/db_name
spring.datasource.username=db_user
spring.datasource.password=db_password

spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
```

3. Run it on the project's root folder
```
$ mvn spring-boot:run
```
