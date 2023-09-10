package HR.pages;

import BaseClasses.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//a[contains (@href, \"web/index.php/admin/viewAdminModule\")]")
    public WebElement adminLinkSidebar;
    @FindBy(xpath = "//a[contains (@href, \"web/index.php/pim/viewPimModule\")]")
    public WebElement PIMLinkSidebar;
    public void clickAdminLink() {
        click(adminLinkSidebar);
    }
    public void clickPIMLink() {
        click(PIMLinkSidebar);
    }
}
