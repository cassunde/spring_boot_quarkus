## Quarkus

Esse projeto implementa a solução usando as seguintes tecnologias:
 
- [Smallrye](https://quarkus.io/guides/microprofile-fault-tolerance)

## Testando

- Levante o mongodb

> docker run --name my_mongo -d -p 127.0.0.1:27017:27017 mongo:latest


- Start quarkus

> ./mvnw quarkus:dev

- Chame a seguinte URL

> http://localhost:8080/v1/ceps/61655220
