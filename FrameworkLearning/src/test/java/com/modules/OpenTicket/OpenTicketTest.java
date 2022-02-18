package com.modules.OpenTicket;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.modules.login.OpenTicketPage;
import org.testng.annotations.Test;
import com.modules.login.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class OpenTicketTest extends BaseTest {

    @Test(priority = 2)
    public void testOpenTicket() throws IOException {
        logger = extent.startTest("Open A Ticket ");
        OpenTicketPage openTicket = new OpenTicketPage(driver);
        logger.log(LogStatus.PASS, "Clicked on Open Ticket ");
        openTicket.clickOnOpenTicket();
        logger.log(LogStatus.PASS, "Clicked on Bugs and Errors ");
        openTicket.clickOnBugsNErrors();
        logger.log(LogStatus.PASS, "Selected High as Bug Priority ");
        openTicket.dropDown();
        logger.log(LogStatus.PASS, "Entered the Subject name ");
        openTicket.enterSubjectName(prop.getProperty("enterSubject"));
        logger.log(LogStatus.PASS, "Entered the Error Body Message ");
        openTicket.entermMessageBody(prop.getProperty("ErrorBodyMessage"));
        logger.log(LogStatus.PASS, "File Uploaded successfully ");
        openTicket.fileUpload();
        logger.log(LogStatus.PASS, "Verifiyng file uploaded message ");
        openTicket.clickOnContinue();
        logger.log(LogStatus.PASS, "Navigating back to Home page ");
        openTicket.setHomePage();





    }
}
