package br.com.rsi.testframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BaseClass{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
    @FindBy(how=How.ID, using="q")
	public static WebElement modelo_veiculo;
	
    @FindBy(how=How.CSS, using="#sarea0")
	public static WebElement comboAnoInicio;
    
    @FindBy(how=How.CSS, using="div#optionsDiv0.optionsDivVisible p:nth-child(6) a")
	public static WebElement anoInicio;

    @FindBy(how=How.ID, using="sarea1")
	public static WebElement comboAnoFim;
    
    @FindBy(how=How.CSS, using="div#optionsDiv1.optionsDivVisible p:nth-child(6) a")
    public static WebElement anoFim;
    
    @FindBy(how=How.CLASS_NAME, using="btMBuscar")
    public static WebElement botaoBuscar;
}