import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;

public class KatalonTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        //pentru Java 11+
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://katalon-test.s3.amazonaws.com/aut/html/form.html");
        driver.manage().window().maximize();
    }

    @Test
    public void testCommonActions() {

        driver.findElement(By.id("first-name")).click();
        sleep(1000);
        driver.findElement(By.id("first-name")).sendKeys("Alex");
        sleep(1000);
        driver.findElement(By.id("last-name")).sendKeys("Smith");
        sleep(1000);
        driver.findElement(By.name("gender")).click();
        sleep(1000);
        driver.findElement(By.id("dob")).click();
        sleep(1000);
        driver.findElement(By.xpath("//tr[4]/td[3]")).click();
        sleep(1000);
        driver.findElement(By.id("address")).click();
        sleep(1000);
        driver.findElement(By.id("address")).sendKeys("123456 Wakanda");
        sleep(1000);
        driver.findElement(By.id("email")).click();
        sleep(1000);
        driver.findElement(By.id("email")).sendKeys("alex@wakanda.gov");
        sleep(1000);
        driver.findElement(By.id("password")).click();
        sleep(1000);
        driver.findElement(By.id("password")).sendKeys("secret");
        sleep(1000);
        driver.findElement(By.id("company")).click();
        sleep(1000);
        driver.findElement(By.id("company")).sendKeys("Dora");
        sleep(1000);
        new Select(driver.findElement(By.id("role"))).selectByVisibleText("Manager");
        sleep(1000);
        driver.findElement(By.id("role")).click();
        sleep(1000);
        new Select(driver.findElement(By.id("expectation"))).selectByVisibleText("Nice manager/leader");
        sleep(1000);
        driver.findElement(By.xpath("//select[@id='expectation']/option[2]")).click();
        sleep(1000);
        new Select(driver.findElement(By.id("expectation"))).selectByVisibleText("Excellent colleagues");
        sleep(1000);
        driver.findElement(By.xpath("//select[@id='expectation']/option[3]")).click();
        sleep(1000);
        new Select(driver.findElement(By.id("expectation"))).selectByVisibleText("Good teamwork");
        sleep(1000);
        driver.findElement(By.xpath("//select[@id='expectation']/option[4]")).click();
        sleep(1000);
        driver.findElement(By.xpath("//input[@value='']")).click();
        sleep(1000);
        driver.findElement(By.xpath("(//input[@value=''])[2]")).click();
        sleep(1000);
        driver.findElement(By.id("comment")).click();
        sleep(1000);
        driver.findElement(By.id("comment")).sendKeys("Added by Alex.");
        sleep(1000);
        driver.findElement(By.id("submit")).click();
        sleep(1000);
        driver.close();
    }
}
