package cucumber; 

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

public class PesquisaComQA { 
	
	private static WebDriver browser;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","c:\\chromedriver\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() throws Exception {
		browser.quit();
	}
	
	@Given("^que eu acesse a pagina da VV Test$")
	public void abrirPagina(){
		browser.get("http://www.lourencodemonaco.com.br/vvtest/");
	}
	
	@And("^acesse o menu Pesquisa - QA$")
	public void acessarMenu(){
		browser.findElement(By.xpath("/html/body/div/header/div[2]/div/div/nav/div/ul/li[6]/a")).click();	
	}
	
	@When("^eu preencher todos os campos obrigatorios$")
	public void preencherCampos(){
		Select selectBox = null;
		
		browser.findElement(By.id("nf-field-5")).sendKeys("Nome");
		browser.findElement(By.id("nf-field-6")).sendKeys("Sobrenome");
		browser.findElement(By.id("nf-field-7")).sendKeys("email@email.com");
		browser.findElement(By.id("nf-field-8")).sendKeys("email@email.com");
		
		// 49+
		browser.findElement(By.id("nf-label-class-field-10-2")).click();
		
		selectBox = new Select(browser.findElement(By.id("nf-field-11")));
	    selectBox.selectByValue("menos-de-5-anos");
	    
	    selectBox = new Select(browser.findElement(By.id("nf-field-12")));
	    selectBox.selectByValue("salario");
	    	
	    // Negócio
		browser.findElement(By.id("nf-label-class-field-13-1")).click();
		browser.findElement(By.id("nf-field-14")).sendKeys("Java");
		
		browser.findElement(By.id("nf-field-16")).click();
		
	}
	
	@Then("^deve ser direcionado para uma pagina de sucesso$")
	public void checarPaginaDeSucesso(){
		browser.findElement(By.xpath("//*[contains(text(),'Your form has been successfully submitted')]"));
	}
	
}