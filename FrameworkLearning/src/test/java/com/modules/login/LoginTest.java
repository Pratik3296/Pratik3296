package com.modules.login;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import org.testng.annotations.Test;
import com.modules.login.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void testLogin() throws InterruptedException {
        logger = extent.startTest("Test Login");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setUserName();
        logger.log(LogStatus.PASS, "Entered UserName is " + prop.getProperty("userName"));
        loginPage.setPassword();
        logger.log(LogStatus.PASS, "Entered Password is " + prop.getProperty("password"));
        loginPage.setLoginButton();
        logger.log(LogStatus.PASS, "Clicked on Login Button");
        Thread.sleep(10000);

    }
}
