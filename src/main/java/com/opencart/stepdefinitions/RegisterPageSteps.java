package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGenerator;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the register form is populated with valid random data")
    public void theRegisterFormIsPopulatedWithValidRandomData() {
        String randomEmail = RandomDataGenerator.generateRandomEmail();
        String password = RandomDataGenerator.generatePassword();
        System.out.println(randomEmail);
        System.out.println(password);
        registerPage.fillInTheRegisterForm(RandomDataGenerator.generateFirstName(),
                RandomDataGenerator.generateLastName(),
                randomEmail, password, true);
        System.out.println("The register form is populated with valid random data");
    }
    @And("Continue button is clicked")
    public void continueButtonIsClicked() {
        registerPage.clickTheContinueBtn();
        System.out.println("The continue button ha been clicked");
    }
}
