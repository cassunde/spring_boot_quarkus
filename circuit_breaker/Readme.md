# Circuit breaker

Esse um Design Pattern que ajudará seu serviço a lidar com a indisponibilidade ou alta latência dos seus serviços parceiros.

Imagine se um serviço que seu projeto usa pare de funcionar, se sem esse serviço seu projeto também parará então existe uma grande possibilidade de esse recurso está dentro do seu projeto, caso não temos que achar uma maneira de vivermos mesmo que momentaneamente sem esse serviço parceiro

## O Exemplo

Nessa pasta implemento um exemplo onde o serviço tem que entregar um endereço apartir de um cep, esse exemplo usa uma api pública para resgatar esses valores, porém nosso circuit breaker ira tratar o problema se a mesma estive off.

Basicamente todo cep resgatado da api externa e salvo em um banco Mongodb, quando a api estiver off o fallback irs buscar no banco local.
