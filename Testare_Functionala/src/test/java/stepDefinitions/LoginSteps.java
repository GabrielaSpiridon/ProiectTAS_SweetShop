package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;

    @Given("Utilizatorul se afla pe pagina de Login")
    public void navigareLogin() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.get("https://sweetshop.netlify.app/login");
    }

    @When("Introduce email-ul {string} si parola {string}")
    public void introducereDate(String email, String parola) {
        driver.findElement(By.id("exampleInputEmail")).sendKeys(email);
        driver.findElement(By.id("exampleInputPassword")).sendKeys(parola);
    }

    @And("Apasa butonul de Login")
    public void clickLogin() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("Utilizatorul este redirectionat catre pagina de cont")
    public void verificareRedirectionare() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("sweetshop.netlify.app"));
        driver.quit();
    }
}