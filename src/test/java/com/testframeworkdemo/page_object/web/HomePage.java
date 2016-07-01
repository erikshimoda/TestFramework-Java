package com.testframeworkdemo.page_object.web;

import org.openqa.selenium.By;

import com.testframeworkdemo.framework.PageObject;
import com.testframeworkdemo.framework.helpers.WebDriverHelper;

public class HomePage extends PageObject {

	public HomePage(WebDriverHelper webDriver) {
		super(webDriver);
	}
	
    private static By abraSuaContaLinkText = By.linkText("Abra sua conta");
    
	public static void abrirSuaConta() {
		waitForExpectedElement(abraSuaContaLinkText).click();
		
		switchToLandingPage();
	}
}