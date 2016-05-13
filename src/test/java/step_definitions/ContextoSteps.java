package step_definitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.pt.Dado;

public class ContextoSteps {
	public WebDriver driver;

	public ContextoSteps() {
		driver = Hooks.driver;
	}

	@Dado("que eu acesso \"([^\"]*)\"$")
	public void queEuAcesso(String url) throws Throwable {
		driver.get(url);
	}
}
