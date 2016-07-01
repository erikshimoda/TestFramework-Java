package com.testframeworkdemo.step_definitions.mobile;

import static org.assertj.core.api.Assertions.assertThat;

import com.testframeworkdemo.page_object.mobile.MainPage;

import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class MainSteps {
	private MainPage mainPage;

	public MainSteps(MainPage mainPage) {
		this.mainPage = mainPage;
	}
	
	@Quando("^eu clico em Informações Gerais$")
	public void eu_clico_em_Informações_Gerais() throws Throwable {
		mainPage.retornarOpcaoInformacoesGeraisId().click();
	}

	@Quando("^eu clico no voltar$")
	public void eu_clico_no_voltar() {
		mainPage.clicoNoVoltar();
	}

	@Quando("^eu clico em Ranking$")
	public void eu_clico_em_Ranking() {
		mainPage.retornarOpcaoRankingId().click();
	}
	
	@Quando("^eu clico no Iniciar Avaliação$")
	public void eu_clico_no_Iniciar_Avaliação() {
		mainPage.retornarOpcaoIniciarAvaliacaoId().click();
	}
		
	@Entao("^eu visualizo o menu de opções$")
	public void eu_visualizo_o_menu_de_opções() {
		boolean visivelOpcaoInformacoesGerais = mainPage.retornarOpcaoInformacoesGeraisId().isDisplayed();
		boolean visivelOpcaoRanking = mainPage.retornarOpcaoRankingId().isDisplayed();
		boolean visivelOpcaoSignificado = mainPage.retornarOpcaoSignificadoId().isDisplayed();
		boolean visivelOpcaoIniciarAvaliacao = mainPage.retornarOpcaoIniciarAvaliacaoId().isDisplayed();
		
		assertThat(visivelOpcaoInformacoesGerais).isTrue();
		assertThat(visivelOpcaoRanking).isTrue();
		assertThat(visivelOpcaoSignificado).isTrue();
		assertThat(visivelOpcaoIniciarAvaliacao).isTrue();		
	}
}
