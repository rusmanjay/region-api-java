# Spring Boot Region Rest API
1. Create new database

<<<<<<< adfd71e1b56cbc34767ab6934bc09ff2b95dcd57
2. Create file `aplication.properties` under folder `src/main/resources/`
=======
2. Create file `application.properties` under folder `src/main/resources/`
>>>>>>> Change id from int to string
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
