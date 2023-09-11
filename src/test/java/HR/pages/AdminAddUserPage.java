package HR.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AdminAddUserPage {
    @FindBy(xpath = "(//i[contains(@class, \"oxd-select-text--arrow\")])[1]")
    public WebElement selectRole;

    public void setDropdown() {
        Select dropdown = new Select(selectRole);
        // Select an option by its visible text
        dropdown.selectByVisibleText("Admin");
    }
}
