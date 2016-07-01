package com.testframeworkdemo.step_definitions.web;

import org.openqa.selenium.WebDriver;

import com.testframeworkdemo.framework.helpers.WebDriverHelper;

import cucumber.api.java.pt.Dado;

public class ContextoSteps {
	public static WebDriver webDriver;

	public ContextoSteps (WebDriverHelper webDriver) {
		ContextoSteps.webDriver = WebDriverHelper.getSharedDriver();
	}

	@Dado("que eu acesso \"([^\"]*)\"$")
	public void queEuAcesso(String url) throws Throwable {
		webDriver.get(url);
	}
}
