## Trace

Quando temos vários microservices trabalhando juntos em nossa arquitetura e tarefa difícil entendermos em qual microservico quebrou alguma coisa, e uma estrutura de log bem organizada nos ajudará bastante nessa tarefa, mas nesses exemplos vamos ver como podemos analisar por onde uma determinada requisição passou.

**O Básico**

Basicamente para cada requisição será criada um **ID** e esse identificador será trafegado por todo o caminho percorrido entre os serviços até voltar ao ponto que foi criado.

**O Exemplo**

Nosso cenário e bem simples, teremos 2 serviços e o **serviço a** chama o **servico b** que retorna um json que o **servico a** que retorna esse json para o usuário.

Para que consigamos observar esse rastreamento usaremos algumas ferramentas para nos auxiliar como o Zipkin.

Acesse cada exemplo e faça os testes.
