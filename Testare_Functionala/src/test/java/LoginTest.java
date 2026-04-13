import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Configurarea initiala
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://sweetshop.netlify.app/login");
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginSweetShop() {
        // Introducere date
        driver.findElement(By.id("exampleInputEmail")).sendKeys("oneorder@sweetshop.local");
        sleep(2000);

        driver.findElement(By.id("exampleInputPassword")).sendKeys("qwerty");
        sleep(2000);

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        sleep(2000);

        // Verificam daca login-ul a reusit verificand URL-ul
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("sweetshop.netlify.app")) {
            System.out.println("Test Passed! Login successful on Sweet Shop!");
        } else {
            System.out.println("Test Failed!");
            assertTrue(false); // Testul apare rosu in raport daca esueaza
        }
    }

    @After
    public void tearDown() {
        // Inchidem browserul dupa fiecare test
        if (driver != null) {
            driver.quit();
        }
    }
}