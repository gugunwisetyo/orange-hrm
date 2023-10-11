package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RecruitmentPage;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.WebDriver;

public class MainApp {

    private static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
//        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(Constants.URL);

        //step
        LoginPage loginPage = new LoginPage();
        //loginPage.login();
        loginPage.loginForm("Admin","admin123");
        System.out.println("Login valid");
        RecruitmentPage recruitPage = new RecruitmentPage();
        recruitPage.recruit();
        loginPage.logout();
        loginPage.loginForm("Adminn","admin123");
        System.out.println("Login invalid");

        //untuk close
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}