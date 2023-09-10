package HR.pages;

import BaseClasses.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage {

    @FindBy(xpath = "//button[@role = \"none\" and contains (@class, \"oxd-main-menu-button\")]")
    public WebElement addBtn;

    public void clickAddBtn() {
        click(addBtn);
    }
}
