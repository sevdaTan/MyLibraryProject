package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinition {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        String url = ConfigurationReader.getProperty("qa2_url");
        Driver.getDriver().get(url);

    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {

       String lib44_username = ConfigurationReader.getProperty("librarian44_username");
       String lib44_password = ConfigurationReader.getProperty("librarian44_password");

       loginPage.usernameInput.sendKeys(lib44_username);
       loginPage.passwordInput.sendKeys(lib44_password);
       loginPage.signInBtn.click();


    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        String expected = "dashboard";

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains(expected));

        BrowserUtils.wait(2);
        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
        Driver.closeDriver();

    }



    @When("I login as a student")
    public void i_login_as_a_student() {

        String stu33_username = ConfigurationReader.getProperty("student33_username");
        String stu33_password = ConfigurationReader.getProperty("student33_password");

        loginPage.usernameInput.sendKeys(stu33_username);
        loginPage.passwordInput.sendKeys(stu33_password);
        loginPage.signInBtn.click();

    }


    @Then("books should be displayed")
    public void books_should_be_displayed() {

        String expected = "books";

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains(expected));

        BrowserUtils.wait(2);
        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
        Driver.closeDriver();

    }





}
