import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.fail;

public class adminDashboard {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
    }

    @BeforeMethod
    public void adminLogin(){

    }

    private static final long shortTimeout = 15;

    @Test public void createAdmin(){

        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(shortTimeout));
        //wait
        try {
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Admin")));
        } catch (TimeoutException ex) {
            fail("Admin link text not found.");
        }
        //Locate and click Admin on sidebar
        driver.findElement(By.linkText( "Admin")).click();

        try {
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//div[1]/div[2]/div[2]/div/div[2]/div[1]/button")));
        } catch (TimeoutException ex) {
            fail("Add button not found.");
        }
        driver.findElement(By.xpath( "//div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();

        try {
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//form/div[1]/div/div[1]/div/div[2]/div/div")));
        } catch (TimeoutException ex) {
            fail("select");
        }
    }
}

