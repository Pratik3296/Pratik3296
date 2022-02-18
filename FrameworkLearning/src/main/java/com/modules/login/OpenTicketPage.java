package com.modules.login;

import com.genericUtils.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

import static com.genericUtils.BasePage.elementClick;
import static com.genericUtils.BasePage.enterValue;
import static com.genericUtils.BaseTest.*;

public class OpenTicketPage {

    @FindBy(xpath = "//span[text()='Open Ticket']")
    private WebElement clickOnOpenTicket;
    @FindBy(xpath = "//p[text()='Report For Bugs or Errors You Encountered ']")
    private WebElement clickOnBugsNErrors;
    @FindBy(xpath = "//input[@name='subject']")
    private WebElement enterSubject;
    @FindBy(xpath = "//textarea[@id='inputMessage']")
    private WebElement enterBody;
    @FindBy(xpath = "//input[@name='attachments[]']")
    private WebElement fileUpload;
    @FindBy(xpath = "//input[@id='openTicketSubmit']")
    private WebElement clickOnSubmit;
    @FindBy(xpath = "//h2[@class='message-title']")
    private WebElement verifyTicketCreatedMessage;
    @FindBy(xpath = "(//a[@class='btn btn-primary'])[2]")
    private WebElement clickOnContinue;
    @FindBy(xpath = "(//img[@title='PHPTRAVELS'])[1]")
    private WebElement homePage;

    public OpenTicketPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void clickOnOpenTicket() throws IOException {
        elementClick(clickOnOpenTicket);
    }
    public void clickOnBugsNErrors() throws IOException {
        elementClick(clickOnBugsNErrors);
    }

    public void dropDown(){
        Select select = new Select(driver.findElement(By.xpath("//select[@id='inputPriority']")));
        select.selectByVisibleText(prop.getProperty("Priority"));
    }

    public void enterSubjectName(String subject) throws IOException {
        enterValue(enterSubject,subject);
    }

    public void entermMessageBody(String message) throws IOException {
        enterValue(enterBody,message);
    }

    public void fileUpload(){
        System.out.println("File is Uploaded");
        driver.findElement(By.xpath("//input[@name='attachments[]']")).sendKeys("D:\\Pratik\\DXP\\Pratik3296\\FrameworkLearning\\src\\test\\resources\\upload\\blank.pdf");
        clickOnSubmit.click();
        driver.navigate().refresh();
    }
    public void clickOnContinue(){
        clickOnContinue.click();
       }
    public void setHomePage() throws IOException {
        elementClick(homePage);
    }

}
