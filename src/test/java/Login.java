import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


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

    
}
