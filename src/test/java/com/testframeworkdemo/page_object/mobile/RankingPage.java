package com.testframeworkdemo.page_object.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testframeworkdemo.framework.AndroidObject;
import com.testframeworkdemo.framework.helpers.AndroidDriverHelper;

public class RankingPage extends AndroidObject {

	private By labelNomeId = By.id("rownome");
	private By labelIdadeId = By.id("rowidade");
	private By labelPontosId = By.id("rowpontos");
	private By labelTempoId = By.id("rowtempo");
	private By labelQiId = By.id("rowqi");

	public RankingPage(AndroidDriverHelper androidDriver) {
		super(androidDriver);
	}

	public WebElement retornarLabelNomeId() {
		return waitForClickabilityOf(labelNomeId);
	}

	public WebElement retornarLabelIdadeId() {
		return waitForClickabilityOf(labelIdadeId);
	}

	public WebElement retornarLabelPontosrId() {
		return waitForClickabilityOf(labelPontosId);
	}

	public WebElement retornarLabelTempoId() {
		return waitForVisibilityOf(labelTempoId);
	}

	public WebElement retornarLabelQiId() {
		return waitForVisibilityOf(labelQiId);
	}
}