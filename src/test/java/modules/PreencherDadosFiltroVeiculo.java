package modules;

import org.openqa.selenium.WebDriver;

import pageobjects.HomePage;

public class PreencherDadosFiltroVeiculo {

	public static void InformarModelo(WebDriver driver, String modelo) throws Exception {
		HomePage.modelo_veiculo.sendKeys(modelo);
	}

	public static void InformarAnoInicio(WebDriver driver, String anoInicio) throws Exception {
		HomePage.comboAnoInicio.click();
		HomePage.anoInicio.click();
	}

	public static void InformarAnoFim(WebDriver driver, String anoFim) throws Exception {
		HomePage.comboAnoFim.click();
		HomePage.anoFim.click();
	}
	
	public static void ClicarBuscar(WebDriver driver) throws Exception {
		HomePage.botaoBuscar.click();
	}
}
