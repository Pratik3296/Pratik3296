package com.modules.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//input[@id='txtUsername']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='txtPassword']")
    private WebElement passWord;
    @FindBy(xpath = "//input[@name='Submit']")
    private WebElement loginButton;



    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setUserName()
    {
        userName.sendKeys("Admin");
    }
    public void setPassword()
    {
        passWord.sendKeys("admin123");
    }

    public void setLoginButton()
    {
        loginButton.click();

    }



}


