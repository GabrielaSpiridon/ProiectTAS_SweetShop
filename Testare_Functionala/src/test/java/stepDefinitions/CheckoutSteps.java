package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class CheckoutSteps {
    WebDriver driver;

    @Given("Utilizatorul are un produs in cos")
    public void adaugareProdus() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.get("https://sweetshop.netlify.app/sweets");
        driver.findElement(By.xpath("//a[@data-id='1']")).click();
    }

    @And("Navigheaza la pagina Basket")
    public void navigareCos() {
        driver.get("https://sweetshop.netlify.app/basket");
    }

    @When("Apasa pe butonul Checkout")
    public void clickCheckout() {
        driver.findElement(By.linkText("Checkout")).click();
    }

    @And("Lasa toate campurile goale si apasa Continue to checkout")
    public void trimiteFormularGol() {
        driver.findElement(By.xpath("//button[contains(text(),'Continue to checkout')]")).click();
    }

    @Then("Sistemul afiseaza mesaje de eroare pentru campurile obligatorii")
    public void verificareMesajeEroare() {
        // Verificăm prezența mesajului de eroare pentru prenume conform documentației [cite: 271, 281]
        WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(), 'Valid first name is required')]"));
        assertTrue(errorMsg.isDisplayed());
        driver.quit();
    }
}