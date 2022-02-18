package com.modules.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

import static com.genericUtils.BasePage.elementClick;
import static com.genericUtils.BaseTest.driver;
import static com.genericUtils.BaseTest.prop;

public class OpenTicketPage {

    @FindBy(xpath = "//span[text()='Open Ticket']")
    private WebElement clickOnOpenTicket;
    @FindBy(xpath = "//p[text()='Report For Bugs or Errors You Encountered ']")
    private WebElement clickOnBugsNErrors;


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
}
