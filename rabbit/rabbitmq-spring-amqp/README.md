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
```shell
java -jar target/rabbitmq-spring-amqp-0.0.1-SNAPSHOT.jar --spring.profiles.active=work-queues,sender
``` 
```shell
java -jar target/rabbitmq-spring-amqp-0.0.1-SNAPSHOT.jar --spring.profiles.active=work-queues,receiver
```

# Tut3
```shell
java -jar target/rabbitmq-spring-amqp-0.0.1-SNAPSHOT.jar --spring.profiles.active=pub-sub,sender
``` 
```shell
java -jar target/rabbitmq-spring-amqp-0.0.1-SNAPSHOT.jar --spring.profiles.active=pub-sub,receiver
```
```shell
sudo rabbitmqctl list_exchanges
```
```shell
sudo rabbitmqctl list_bindings
```