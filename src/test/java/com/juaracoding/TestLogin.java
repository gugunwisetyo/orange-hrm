package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {

    private WebDriver driver;

    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testValidLogin(){
        loginPage.loginForm("Admin", "admin123");
        Assert.assertEquals(loginPage.getTxtDashboard(), "Dashboard");
        System.out.println("Test case valid login");
    }

    @Test(priority = 2)
    public void testInvalidLogin(){
        loginPage.logout();
        loginPage.loginForm("Adminn", "admin123");
        Assert.assertEquals(loginPage.getTxtInvalid(), "Invalid credentials");
        System.out.println("Test case invalid login");
    }

    @Test(priority = 3)
    public void testBlankUser(){
        loginPage.loginForm("", "admin123");
        Assert.assertEquals(loginPage.getTxtBlank(), "Required");
        System.out.println("Test case blank username");
    }

    @Test(priority = 4)
    public void testBlankPass(){
        loginPage.clearUser();
        loginPage.clearPass();
        loginPage.loginForm("Admin", "");
        Assert.assertEquals(loginPage.getTxtBlank(), "Required");
        System.out.println("Test case blank password");
    }

}
