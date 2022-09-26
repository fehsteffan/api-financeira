# api-financeira
https://github.com/fehsteffan/api-financeira

SOBRE: 

API REST T que recebe transações utilizando-se de Java e Spring 
Boot.

DOCUMENTAÇÃO:

http://localhost:8080/swagger-ui.html#/user-resource


1. POST /transacao
Este é o endpoint que irá receber as Transações. Cada transação consiste de um valor e 
uma dataHora de quando ela aconteceu:

OBS: Uma transação aceita DEVE gerar uma resposta 201 Created sem nenhum corpo;


{ "valor": 123.45,
 "dataHora": "2020-08-07T10:11:12.000Z"}
 
 
2. DELETE /transacao
Esta requisição simplesmente apaga todos os dados de transação que estejam 
armazenados.
 
