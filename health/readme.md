## Helth

Em nosso ecossistema precisamos monitorar a saúde de nossas aplicações para tomar ações quando alguma ficar **off**.

Basicamente em nossas aplicações expomos um end-point que irá informar como está a saúde, podemos inclusive personalizar esses end-points observando outros componentes como banco de dados, rede e etc.

Na maioria dos orquestradores de containers conseguimos configurar o endereço e a frequência em que esses end-points serão verificados, sempre que for detectado que uma determinada aplicação não está saudável automaticamente as mesmas serão reinicadas.

## O Exemplo

Aqui será mostrado um exemplo simples que expomos um end-point que diz se a aplicação está **up**, será criada também um exemplo customizado.
