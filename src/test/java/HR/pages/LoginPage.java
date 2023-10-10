package HR.pages;

import BaseClasses.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name=\"username\"]")
    public WebElement userName;
    @FindBy(xpath = "//input[@name=\"password\"]")
    public WebElement password;
    @FindBy(xpath = "//button[contains(@class, \"orangehrm-login-button\")]")
    public WebElement loginBtn;
}
