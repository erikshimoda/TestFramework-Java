#language: pt
#encoding: iso-8859-1

@testesFuncionaiss

Funcionalidade: No portal do Santander, preencher os dados para abrir uma nova conta corrente

Contexto:
	Dado que eu acesso "https://www.santander.com.br/br/"
Cenario: Abrir o site do santander e preencher o formulário para criar uma conta corrente pessoa física
	
	Quando eu clico na opcao Abra sua Conta
	Quando escolho a opcao Para Voce
	E escolho a opcao Eu Trabalho
	E preencho o nome completo "Zeca Neto João Silva"
	E preencho com o cpf "868-482-072-09"
	E preencho a data de nascimento "25/08/1984"
	E preencho o e-mail "zeca.neto@mailinator.com"
	E seleciono o sexo Masculino
	E preencho o nome da mae "Maria Josefa Josefina"
	E preencho o celular "11 95467-9090"
	E preencho o telefone fixo "11 4456-3232"
	E eu informo a renda
	E clico no botao Continuar
	Entao eu visualizo o formulario de Endereco
	E eu preencho o cep "09111-000"
	E eu clico no botao Continuar
	Entao eu visualizo um alerta de campo obrigatorio para o numero com a mensagem "Este campo é obrigatório"