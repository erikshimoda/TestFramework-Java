#language: pt
@testeAceitacao

Funcionalidade: No portal da BV, exibir os veículos disponíveis em nosso sistema, para que os clientes possam comprar

Contexto:
	Dado que eu acesso "http://www.bvfinanceira.com.br" 

Cenario: Pesquisar por um veículo no site da BV Financeira
 	Quando eu pesquiso pelo modelo "Ford"
    E informo o ano inicial de "2013"
    E informo o ano final de "2016"
    E clico no Buscar
 	Entao eu visualizo uma lista de modelos de veiculos
	E eu clico para Visualizar os Detalhes
	Entao eu visualizo os detalhes do veiculo
