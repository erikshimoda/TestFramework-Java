#language: pt 
#encoding: iso-8859-1

@testeMobiles

Funcionalidade: App que avalia o QI de uma pessoas
Contexto:
	Dado que eu abro o app Teste de QI 

Cenario: Abrir o app e navegar entre as opções existentes
	Quando eu clico em Informações Gerais
	E eu clico no voltar
	Entao eu visualizo o menu de opções
	Quando eu clico em Ranking
	E eu clico no voltar
	Entao eu visualizo o menu de opções
	Quando eu clico no Iniciar Avaliação
	E eu informo o nome "Francisco"
	E eu informo a idade "46"
	E eu clico no Prosseguir
	E eu clico no voltar
	Entao eu visualizo o menu de opções