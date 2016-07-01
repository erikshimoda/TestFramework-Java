package com.testframeworkdemo.step_definitions.mobile;

import com.testframeworkdemo.page_object.mobile.CadastroPage;

import cucumber.api.java.pt.Quando;

public class CadastroSteps {
	private CadastroPage cadastroPage;

	public CadastroSteps(CadastroPage cadastroPage) {
		this.cadastroPage = cadastroPage;
	}

	@Quando("^eu informo o nome \"(.*?)\"$")
	public void eu_informo_o_nome(String nome) {
		cadastroPage.retornarInputNomeId().sendKeys(nome);
	}

	@Quando("^eu informo a idade \"(.*?)\"$")
	public void eu_informo_a_idade(String idade) {
		cadastroPage.retornarInputIdadeIdadeId().sendKeys(idade);
	}

	@Quando("^eu clico no Prosseguir$")
	public void eu_clico_no_Prosseguir() {
		cadastroPage.retornarBotaoProsseguirPontosrId().click();
	}
}
