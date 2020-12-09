package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver= Driver.getDriver();

    protected WebDriverWait wait = new WebDriverWait(driver, 20);

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }







}
