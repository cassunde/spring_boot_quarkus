## Quarkus

Esse projeto implementa a solução usando as seguintes tecnologias:
 
- [RabbitMQ](https://www.rabbitmq.com/)

**Obs:** Não existe um plugin do quarkus para lidar com o RabbitMQ em específico,então usei a biblioteca padrão do mesmo e implementei uma estrutura bem simples usando funcionalidades do CDI como:
- Observer
- Qualifier

No projeto **Consumer** isso ficou mais claro, pois a aplicação deve está o tempo todo escutando a fila.

## Testando

- Levante rabbitMQ

> docker run -d --hostname my-rabbit --name some-rabbit rabbitmq:3-management


- Start os projetos quarkus com o comando abaixo em cada projeto

> ./mvnw quarkus:dev

- Chame a seguinte URL

> http://localhost:8080/sales

URL acima irá simboliza uma nova venda, assim disparando toda a estrutura de mensageria.

