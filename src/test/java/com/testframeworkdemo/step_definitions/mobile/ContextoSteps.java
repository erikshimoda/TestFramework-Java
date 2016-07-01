package com.testframeworkdemo.step_definitions.mobile;

import com.testframeworkdemo.framework.AndroidObject;
import com.testframeworkdemo.framework.helpers.AndroidDriverHelper;

import cucumber.api.java.pt.Dado;

public class ContextoSteps extends AndroidObject {
	public ContextoSteps(AndroidDriverHelper androidDriver) {
		super(androidDriver);
	}

	@Dado("^que eu abro o app Teste de QI$")
	public void que_eu_abro_o_app_Teste_de_QI() throws Throwable {
		androidDriver.closeApp();
		androidDriver.launchApp();
	}
}
