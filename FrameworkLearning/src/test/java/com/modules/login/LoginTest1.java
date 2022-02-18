package com.modules.login;

import com.genericUtils.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class LoginTest1 extends BaseTest {
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
