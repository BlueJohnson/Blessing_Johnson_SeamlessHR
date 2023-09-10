package HR.test;

import BaseClasses.TestBase;
import HR.pages.LoginPage;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {

    public void initializer() {
        LoginPage loginPage = new LoginPage(driver);

        String username = testDataProp.getProperty("username");
        String password = testDataProp.getProperty("password");
        loginPage.userLogin(username, password);
    }

    @Test(description = "Ensure that Admin is created successfully")
    public void CreateAdminTest() {
        sleep(35);
        initializer();
    }
}
