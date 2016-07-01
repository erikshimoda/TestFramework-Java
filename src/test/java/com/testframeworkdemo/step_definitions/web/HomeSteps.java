package com.testframeworkdemo.step_definitions.web;

import com.testframeworkdemo.page_object.web.HomePage;

import cucumber.api.java.pt.Quando;

public class HomeSteps {
    private HomePage homePage;

    public HomeSteps(HomePage homePage) {
        this.homePage = homePage;
    }
	
	@Quando("^eu clico na opcao Abra sua Conta$")
	public void eu_clico_na_opcao_Abra_sua_Conta() throws Throwable {
		HomePage.abrirSuaConta();
		Thread.sleep(1000);
	}
}
