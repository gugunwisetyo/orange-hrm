package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

    private WebDriver driver;

    public RecruitmentPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //locator

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement recruitBtn;

    @FindBy(xpath = "//a[normalize-space()='Vacancies']")
    private WebElement vacanciesBtn;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addBtn;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active']")
    private WebElement name;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    private WebElement jobTitle;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement hiringManager;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSave;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
    private WebElement txtMessageSuccessfull;

    public void recruit(){
        recruitBtn.click();
    }

    public void vacancyForm(){
        vacanciesBtn.click();
        addBtn.click();
        name.sendKeys("Test");
        jobTitle.sendKeys("Chief");
        hiringManager.sendKeys("Sara");
        btnSave.click();
    }

    public String getTextMessageSuccessfull(){
        return txtMessageSuccessfull.getText();
    }
}
