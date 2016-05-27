package step_definitions;

import org.apache.jorphan.collections.HashTree;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import helpers.JmeterRequisicoesHelper;
import modules.RetornarPoststApi;

public class PesquisarPostsApi {
	RetornarPoststApi retornarPoststApi;
	JmeterRequisicoesHelper jmeterRequisicoes;

	String url;

	@Dado("que eu acesso a API \"([^\"]*)\"$")
	public void que_Eu_Acesso_A_API(String url) throws Throwable {
		jmeterRequisicoes = new JmeterRequisicoesHelper();

		HashTree testPlanTree = jmeterRequisicoes.generateTestPlan("TestPlanName", "WhateverThreadGroup", url, 80, "/", "GET");

		jmeterRequisicoes.runSuite(testPlanTree);
	}

	@Quando("^eu pesquiso por um post com código \"(.*?)\"$")
	public void eu_pesquiso_por_um_post_com_código(String codigo) throws Throwable {
		throw new PendingException();
	}

	@Então("^eu visualizo oo título \"(.*?)\"$")
	public void eu_visualizo_oo_título(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
}
