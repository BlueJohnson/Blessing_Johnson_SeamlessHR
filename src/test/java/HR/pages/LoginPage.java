package HR.pages;

import BaseClasses.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        super();
    }

    public void LoginPage(WebDriver driver){
       this.driver = driver;
    }

    @FindBy(xpath = "//input[@name=\"username\"]")
    public WebElement userName;

    @FindBy(xpath = "//input[@name=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "//button[contains(@class, \"orangehrm-login-button\")]")
    public WebElement loginBtn;

    public void enterUserName(String name) {
        enterText(userName, name);
    }

    public void enterPassword(String passwordText) {
        enterText(password, passwordText);
    }

    public void clickLoginBtn() {
      click(loginBtn);
    }

    public void userLogin(String usernameText, String passwordText) {
        enterUserName(usernameText);
        enterPassword(passwordText);
        clickLoginBtn();
    }


}
