package com.testframeworkdemo.page_object.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testframeworkdemo.framework.AndroidObject;
import com.testframeworkdemo.framework.helpers.AndroidDriverHelper;

public class CadastroPage extends AndroidObject {

	private By inputNomeId = By.id("ednome");
	private By inputIdadeId = By.id("edtidade");
	private By botaoProsseguirId = By.id("btnprosseguir");

	public CadastroPage(AndroidDriverHelper androidDriver) {
		super(androidDriver);
	}
	public WebElement retornarInputNomeId() {
		return waitForClickabilityOf(inputNomeId);
	}

	public WebElement retornarInputIdadeIdadeId() {
		return waitForClickabilityOf(inputIdadeId);
	}

	public WebElement retornarBotaoProsseguirPontosrId() {
		return waitForClickabilityOf(botaoProsseguirId);
	}
}