package HR.test;

import BaseClasses.TestBase;
import HR.pages.AdminPage;
import HR.pages.DashboardPage;
import HR.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {

    public void adminLogin() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.userName.sendKeys(testDataProp.getProperty("username"));
        loginPage.password.sendKeys(testDataProp.getProperty("password"));
        loginPage.loginBtn.click();
        //ensure user is login --- Add assertion
    }

    @Test(description = "Ensure that Admin is created successfully")
    public void CreateAdminTest() {
        sleep(20);
        adminLogin();

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.adminLinkSidebar.click();

        //create admin page assertion
        AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);
        String breadcrumbText = adminPage.adminHeader.getText();
        Assert.assertTrue(breadcrumbText.contains("Admin") && breadcrumbText.contains("User Management"),
                "Admin and/or User Management are NOT visible");
    }
}
