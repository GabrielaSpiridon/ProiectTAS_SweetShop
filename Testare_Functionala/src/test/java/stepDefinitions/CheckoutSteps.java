package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertTrue;

public class CheckoutSteps {
    WebDriver driver;

    @Given("Utilizatorul are un produs in cos")
    public void adaugareProdus() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://sweetshop.netlify.app/sweets");
        sleep(2000);

        // Adaugam produsul
        driver.findElement(By.cssSelector("a[data-id='1']")).click();
        sleep(1000);
    }

    @And("Navigheaza la pagina Basket")
    public void navigareCos() {
        // Navigare catre cos folosind link-ul
        driver.findElement(By.cssSelector("a.nav-link[href='/basket']")).click();
        sleep(1000);
    }

    @When("Apasa pe butonul Checkout")
    public void clickCheckout() {
        sleep(1000);
    }

    @And("Lasa toate campurile goale si apasa Continue to checkout")
    public void trimiteFormularGol() {
        // Btn de finalizare
        WebElement submitBtn = driver.findElement(By.cssSelector("button.btn-block"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        sleep(1000);

        // Click pe butonul de finalizare
        submitBtn.click();
        sleep(1000);
    }

    @Then("Sistemul afiseaza mesaje de eroare pentru campurile obligatorii")
    public void verificareMesajeEroare() {
        // Verificam eroarea pentru First Name
        WebElement firstNameError = driver.findElement(By.xpath("//div[contains(text(), 'Valid first name is required')]"));

        assertTrue("Mesajul de eroare nu a aparut la trimiterea formularului gol", firstNameError.isDisplayed());

        System.out.println("TC-04: Validarea campurilor obligatorii la Checkout a fost confirmata!");

        // Inchidem driverul la finalul scenariului
        if (driver != null) {
            sleep(2000);
            driver.quit();
        }
    }
}