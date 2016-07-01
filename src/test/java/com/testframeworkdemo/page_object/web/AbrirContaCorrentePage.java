package com.testframeworkdemo.page_object.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testframeworkdemo.framework.PageObject;
import com.testframeworkdemo.framework.helpers.WebDriverHelper;

public class AbrirContaCorrentePage extends PageObject {
	
    private By opcaoParaVoceId = By.id("rd_pessoa");
    
    private By opcaoEuTrabalhoId = By.id("rd_tabalho");
    
    private By inputNomeName = By.name("nome");
    
    private By inputCPFId = By.id("ipt-cpf");
    
    private By inputDtNascimentoId = By.id("ipt-nascimento");
    
    private By inputEmailName = By.name("email");
    
    private By selectSexoName = By.name("sexo");
    
    private By inputNomeMaeName = By.name("nome_mae");
    
    private By inputCelularId = By.id("ipt-tel-cel");
    
    private By inputResidencialId = By.id("ipt-tel-res");
    								
    private By frameRangeClass = By.className("range");
    
    private By sliderRendaId = By.id("Renda");
    
	public AbrirContaCorrentePage (WebDriverHelper webDriver) {
		super(webDriver);
	}
    
    public WebElement retornarOpcaoParaVoceId() {
    	return waitForExpectedElement(opcaoParaVoceId);
    }

    public WebElement retornarOpcaoEuTrabalhoId() {
    	return waitForExpectedElement(opcaoEuTrabalhoId);
    }

    public WebElement retornarInputNomeName() {
    	return waitForExpectedElement(inputNomeName);
    }

    
    public WebElement retornarInputCPFId() {
    	return waitForExpectedElement(inputCPFId);
    }
    
    public WebElement retornarInputDtNascimentoId() {
    	return waitForExpectedElement(inputDtNascimentoId);
    }
    
    public WebElement retornarInputEmailName() {
    	return waitForExpectedElement(inputEmailName);
    }
    
    public WebElement retornarSelectSexoName() {
    	return waitForExpectedElement(selectSexoName);
    }
    
    public WebElement retornarInputNomeMaeName() {
    	return waitForExpectedElement(inputNomeMaeName);
    }
    
    public WebElement retornarInputCelularId() {
    	return waitForExpectedElement(inputCelularId);
    }
    
    public WebElement retornarInputResidencialId() {
    	return waitForExpectedElement(inputResidencialId);
    }
    
    public WebElement retornarFrameRangeClass() {
    	return waitForExpectedElement(frameRangeClass);
    }

    public WebElement retornarSliderRendaId() {
    	return waitForExpectedElement(sliderRendaId);
    }
}

