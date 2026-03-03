```shell
docker compose up -d
```
```shell
./mvnw clean package
```
```shell
java -jar target/rabbitmq-spring-amqp-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello-world,sender
``` 
```shell
java -jar target/rabbitmq-spring-amqp-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello-world,receiver
```