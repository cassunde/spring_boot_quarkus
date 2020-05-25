## Quarkus

Esse projeto implementa a solução usando as seguintes tecnologias:
 
- [RabbitMQ](https://www.rabbitmq.com/)

## Testando

- Levante rabbitMQ

> docker run -d --hostname my-rabbit --name some-rabbit rabbitmq:3-management

- Start os projetos spring-boot com o comando abaixo em cada projeto

> ./gradlew bootRun

- Chame a seguinte URL usando POST

> http://localhost:8080/sales

URL acima irá simboliza uma nova venda, assim disparando toda a estrutura de mensageria.

### Consumer
O projeto consumer está rodando na porta 8090 e escutando todas as mensagens enviadas para a fila `sales` 
