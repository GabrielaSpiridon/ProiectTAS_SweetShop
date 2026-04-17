package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class EmptyBasketSteps {
    WebDriver driver;

    @Given("Utilizatorul are cel putin un produs in cos")
    public void adaugaProdusInCos() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.get("https://sweetshop.netlify.app/sweets");
        // Adauga primul produs din lista
        driver.findElement(By.xpath("//a[@data-id='1']")).click();
    }

    @And("Se afla pe pagina Basket")
    public void navigareBasket() {
        driver.get("https://sweetshop.netlify.app/basket");
    }

    @When("Apasa pe link-ul Empty Basket")
    public void clickEmptyBasket() {
        driver.findElement(By.linkText("Empty Basket")).click();
    }

    @And("Confirma alerta de sistem")
    public void confirmaAlerta() {
        // Gestioneaza fereastra de confirmare a golirii cosului
        driver.switchTo().alert().accept();
    }

    @Then("Cosul este golit si badge-ul din meniu devine 0")
    public void verificareCosGol() {
        // Verifica daca indicatorul numeric din meniu s-a resetat la 0
        String badgeValue = driver.findElement(By.cssSelector(".badge-pill")).getText();
        assertEquals("0", badgeValue);
        driver.quit();
    }
}