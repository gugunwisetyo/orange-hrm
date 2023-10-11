package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //locator use page factory
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement profile;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement btnLogout;

    @FindBy(xpath = "//h6[contains(@class, 'header-breadcrumb')]")
    private WebElement txtDashboard;

    @FindBy(xpath = "//p[contains(@class, 'alert-content')]")
    private WebElement loginInvalid;

    @FindBy(xpath = "//span[contains(@class, 'field-error-message')]")
    private WebElement blankForm;

//    public void login(){
//        username.sendKeys("Admin");
//        password.sendKeys("admin123");
//        btnLogin.click();
//    }

    public void loginForm(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }

    public void clearUser(){
        username.sendKeys(Keys.CONTROL+"a");
        username.sendKeys(Keys.DELETE);
    }
    public void clearPass(){
        password.sendKeys(Keys.CONTROL+"a");
        password.sendKeys(Keys.DELETE);
    }

    public void logout(){
        profile.click();
        DriverSingleton.delay(1);
        btnLogout.click();
    }

    public String getTxtDashboard(){
        return txtDashboard.getText();
    }

    public String getTxtInvalid(){
        return loginInvalid.getText();
    }

    public String getTxtBlank(){
        return blankForm.getText();
    }

}
