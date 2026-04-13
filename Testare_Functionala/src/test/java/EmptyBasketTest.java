import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertEquals;

public class EmptyBasketTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Initializam driverul
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testEmptyBasketFunctionality() {
        // Mergem la pagina cu produse
        driver.get("https://sweetshop.netlify.app/sweets");
        sleep(2000);

        // Adaugam un produs in cos
        driver.findElement(By.cssSelector("a[data-id='1']")).click();
        sleep(1000);

        // Navigam spre pagina de basket
        driver.findElement(By.cssSelector("a.nav-link[href='/basket']")).click();
        sleep(1000);

        // Identificam si apasam pe link-ul de golire a cosului
        driver.findElement(By.linkText("Empty Basket")).click();
        sleep(1000);

        // Gestionam alerta de browser care apare pentru confirmare
        Alert alert = driver.switchTo().alert();
        System.out.println("Mesaj alerta: " + alert.getText());
        alert.accept(); // Apasam pe butonul OK din alerta

        sleep(1000); // Asteptam confirmarea golirii

        // Verificam daca numarul produselor din cos a redevenit 0
        String cartCount = driver.findElement(By.cssSelector("span.badge-success")).getText();

        // Cos gol
        assertEquals("0", cartCount);

        System.out.println("Test TC-05 reusit: Am golit cosul si indicatorul este 0.");
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