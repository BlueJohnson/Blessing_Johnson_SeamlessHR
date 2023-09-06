import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.fail;


public class Login {
    WebDriver driver;
    @BeforeClass void setUp() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
    }
    @BeforeMethod
    void  reloadPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    private static final long shortTimeout = 15;
    private static final long longTimeout = 30;
    @Test public void LoginAdmin() {
        //Waiting and checking the page has loaded correctly
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(shortTimeout));
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));

        try {
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        } catch (TimeoutException ex) {
            fail("username input field not found.");
        }
        //Locate and Enter username
        driver.findElement(By.name("username")).sendKeys("Admin");

        //Locate and Enter password
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Locate and click Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Locate and click Admin on sidebar
        driver.findElement(By.name( "oxd-text oxd-text--span oxd-main-menu-item--name")).click();
    }
}
