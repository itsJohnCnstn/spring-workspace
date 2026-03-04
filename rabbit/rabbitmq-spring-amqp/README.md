# General
```shell
docker compose up -d
```
```shell
./mvnw clean package
```
# Tut1
```shell
java -jar target/rabbitmq-spring-amqp-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello-world,sender
``` 
```shell
java -jar target/rabbitmq-spring-amqp-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello-world,receiver
```

# Tut2