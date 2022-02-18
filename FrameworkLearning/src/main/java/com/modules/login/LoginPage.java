package com.modules.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.genericUtils.BasePage.elementClick;
import static com.genericUtils.BasePage.enterValue;
import static com.genericUtils.BaseTest.driver;

public class LoginPage {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//span[@id='recaptcha-anchor']")
    private WebElement captchaTick;
    @FindBy(xpath = "//input[@id='login']")
    private WebElement loginButton;



    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setUserName(String email) throws IOException {
        enterValue(userName,email);
    }
    public void setPassword(String passwordText) throws IOException {
        enterValue(password,passwordText);
    }

    public void capthcaClick() throws IOException, InterruptedException {
        Thread.sleep(Long.parseLong("1000"));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        Thread.sleep(Long.parseLong("1000"));
        elementClick(captchaTick);
    }
    public void clickOnSubmit() throws IOException {
        driver.switchTo().defaultContent();
        elementClick(loginButton);
    }



}


