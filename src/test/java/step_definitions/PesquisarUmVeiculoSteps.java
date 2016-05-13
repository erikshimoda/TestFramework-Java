package step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.PendingException;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import helpers.Log;
import modules.PreencherDadosFiltroVeiculo;
import pageobjects.HomePage;

public class PesquisarUmVeiculoSteps {
	public WebDriver driver;

	public PesquisarUmVeiculoSteps() {
		Log.iniciadoCasoDeTeste("Pesquisar um Veículo no Site da BV");
		driver = Hooks.driver;
	}
	
	@Quando("eu pesquiso pelo modelo \"([^\"]*)\"$")
	public void eu_pequiso_pelo_modelo(String modelo) throws Throwable {
		PageFactory.initElements(driver, HomePage.class);
		PreencherDadosFiltroVeiculo.InformarModelo(driver, modelo);
	}

	@E("informo o ano inicial de \"([^\"]*)\"$")
	public void informo_o_ano_inicial(String anoInicio) throws Throwable {
		PageFactory.initElements(driver, HomePage.class);
		PreencherDadosFiltroVeiculo.InformarAnoInicio(driver, anoInicio);
	}

	@E("informo o ano final de \"([^\"]*)\"$")
	public void informo_o_ano_final(String anoFim) throws Throwable {
		PageFactory.initElements(driver, HomePage.class);
		PreencherDadosFiltroVeiculo.InformarAnoFim(driver, anoFim);
	}

	@Quando("^clico no Buscar$")
	public void clico_no_Buscar() throws Throwable {
		PageFactory.initElements(driver, HomePage.class);
		PreencherDadosFiltroVeiculo.ClicarBuscar(driver);
	}

	@Então("^eu visualizo os detalhes do veículo$")
	public void eu_visualizo_os_detalhes_do_veículo() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Então("^eu visualizo uma lista de modelos de veiculos$")
	public void eu_visualizo_uma_lista_de_modelos_de_veiculos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Então("^eu clico para Visualizar os Detalhes$")
	public void eu_clico_para_Visualizar_os_Detalhes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}