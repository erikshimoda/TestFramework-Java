#language: pt
@testesApi

Funcionalidade: Acessar a API a retornar os Posts

Contexto:
	Dado que eu acesso a API "http://jsonplaceholder.typicode.com" 

Cenário: Pesquisar por um veículo no site da BV Financeira

 	Quando eu pesquiso por um post com código "2"
	Então eu visualizo oo título "qui est esse"