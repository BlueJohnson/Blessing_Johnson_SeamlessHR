package HR.pages;

import BaseClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage {
    @FindBy(xpath = "//span[@class = \"oxd-topbar-header-breadcrumb\" ]")
    public WebElement adminHeader;
    @FindBy(xpath = "//div[@class='' and @data-v-957b4417='']/input[ @data-v-1f99f73c and contains (@class, \"oxd-input\")] ")
    public WebElement userName;

    @FindBy(xpath = "(//i[ @data-v-bddebfba and contains (@class, \"oxd-icon bi-caret-down-fill oxd-select-text--arrow\")])[1]")
    public WebElement userRole;

    @FindBy(xpath = "//input[contains (@placeholder, \"Type for hints...\")]")
    public WebElement employeeName;
    @FindBy(xpath = "(//i[ @data-v-bddebfba and contains (@class, \"oxd-icon bi-caret-down-fill oxd-select-text--arrow\")])[2]")
    public WebElement status;

    @FindBy(xpath = "//button[text() = \" Reset \"]")
    public WebElement resetBtn;

    @FindBy(xpath = "//button[text() = \" Search \"]")
    public WebElement searchBtn;
    @FindBy(xpath = "//button[text() = \" Add \"]")
    public WebElement addBtn;

    public void clickAddBtn() {
        click(addBtn);
    }


}
