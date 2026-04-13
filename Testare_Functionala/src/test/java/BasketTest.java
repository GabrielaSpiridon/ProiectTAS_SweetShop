import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertTrue;

public class BasketTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Initializare driver
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testCheckoutValidation() {
        // Intram pe pagina de produse pentru a incepe fluxul de cumparare
        driver.get("https://sweetshop.netlify.app/sweets");
        sleep(2000);

        // Adaugam primul produs in cos folosind ID-ul lui unic
        driver.findElement(By.cssSelector("a[data-id='1']")).click();
        sleep(1000);

        // Navigam catre cos folosind link-ul din meniul principal
        driver.findElement(By.cssSelector("a.nav-link[href='/basket']")).click();
        sleep(1000);

        // Identificam butonul de finalizare comanda
        WebElement submitBtn = driver.findElement(By.cssSelector("button.btn-block"));

        // Facem scroll pana la buton pentru a ne asigura ca este vizibil pe ecran inainte de click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        sleep(1000);

        // Incercam sa finalizam comanda fara a completa campurile obligatorii
        submitBtn.click();
        sleep(1000);

        // Verificam daca sistemul afiseaza mesajul de eroare asteptat pentru campul First Name
        WebElement firstNameError = driver.findElement(By.xpath("//div[contains(text(), 'Valid first name is required')]"));

        // Validam faptul ca eroarea este vizibila pentru utilizator
        assertTrue("Mesajul de eroare nu a aparut la trimiterea formularului gol", firstNameError.isDisplayed());

        System.out.println("TC-04: Validarea campurilor obligatorii la Checkout a fost confirmata cu succes!");
    }

    @After
    public void tearDown() {
        // Inchidem browserul
        if (driver != null) {
            sleep(2000);
            driver.quit();
        }
    }
}