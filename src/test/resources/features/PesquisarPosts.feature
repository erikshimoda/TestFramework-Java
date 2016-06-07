#language: pt
@testesApi
Funcionalidade: No portal da BV, exibir os veículos disponíveis em nosso sistema, para que os clientes possam comprar
Contexto:
	Dado que eu acesso a API "http://jsonplaceholder.typicode.com/" 

Cenário: Pesquisar por um veículo no site da BV Financeira

 	Quando eu pesquiso por um post com código "2"
	Então eu visualizo oo título "qui est esse"