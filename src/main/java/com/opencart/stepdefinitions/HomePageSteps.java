package com.opencart.stepdefinitions;

import com.google.j2objc.annotations.Weak;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("HomePage is displayed")
    public void homepageIsDisplayed() {
        driver.get("https://www.andreisecuqa.host/");
        System.out.println("The driver accessed the home page");
    }

    @When("registerLink from Header menu is clicked")
    public void registerlinkFromHeaderMenuIsClicked() {
        homePage.navigateToRegisterPageFromHeader();
        System.out.println("The register link ha been accessed from the header menu");
    }
}
