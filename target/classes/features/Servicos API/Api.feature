#language: pt 
#encoding: iso-8859-1

@servicos

Funcionalidade: Acessar uma API e realizar uma requisição

Contexto:
	Dado que eu realizo um request para a API "http://jsonplaceholder.typicode.com"

Cenario: Realizar um POST request na API no caminho /posts, devo visualizar um post
	Quando eu realizo um GET request com o caminho "/posts/1"
	Entao eu recebo codigo "200" como resposta
	Entao eu recebo a resposta:
	|	userId	|	id	|
	|	1		|	1	|