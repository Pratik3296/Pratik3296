package com.modules.login;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import org.testng.annotations.Test;
import com.modules.login.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;

public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void testLogin() throws InterruptedException, IOException {
        logger = extent.startTest("Test Login");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setUserName(prop.getProperty("userName"));
        logger.log(LogStatus.PASS, "Entered UserName is " + prop.getProperty("userName"));
        loginPage.setPassword(prop.getProperty("password"));
        logger.log(LogStatus.PASS, "Entered Password is " + prop.getProperty("password"));
       // loginPage.capthcaClick();
        Thread.sleep(1000);

        logger.log(LogStatus.PASS, "Cicked on Capthca ");
        loginPage.clickOnSubmit();
        logger.log(LogStatus.PASS, "Cicked on Subit Button ");
        logger.log(LogStatus.PASS, "Clicked on Login Button");
       // Thread.sleep(1000);

    }
}
