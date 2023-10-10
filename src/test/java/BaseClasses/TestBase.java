package BaseClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

public class TestBase {

    public static WebDriver driver;
    public static String filePath_testDataProp = "src/test/java/TestData.properties";
    public static FileInputStream testDataFile;
    public static Properties testDataProp;
    public static String browser;
    public static String baseUrl;


    public TestBase() {
        loadDataProps();
        TestBaseInitializer();
    }

    public void loadDataProps() {
        testDataProp = new Properties();
        try {
            testDataFile = new FileInputStream(filePath_testDataProp);
            testDataProp.load(testDataFile);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void TestBaseInitializer(){
        browser = testDataProp.getProperty("browser");
        baseUrl = testDataProp.getProperty("baseURL");
    }

    private void setupChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    private void setupEdgeDriver() {
        EdgeOptions options = new EdgeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(options);
    }

    private void setupFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver(options);
    }

    @BeforeMethod
    public void setUp() {

        switch (browser.toLowerCase()) {
            case "chrome" -> setupChromeDriver();
            case "edge" -> setupEdgeDriver();
            case "firefox" -> setupFirefoxDriver();
            default -> throw new IllegalStateException("Invalid browser specified: " + browser);
        }
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
    }

//    public WebDriver getDriver() {
//        return driver;
//    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
