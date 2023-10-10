package BaseClasses;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public void BasePage(WebDriver driver ){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }


//    public void waitForVisibility(WebElement element) {
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
    public void waitForVisibility(WebElement element) {
    try {
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    } catch (TimeoutException e) {

    }
}

    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void enterText(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }
}
