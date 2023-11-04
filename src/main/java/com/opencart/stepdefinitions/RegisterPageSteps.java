package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGenerator;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

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

    @When("the register form is populated with the following data:")
    public void theRegisterFormIsPopulatedWithTheFollowingData(Map<String, String> formDataMap) {
        String firstNameValue = formDataMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")){
            firstNameValue = RandomDataGenerator.generateFirstName();

        }
        String lastNameValue = formDataMap.get("lastName");
            if (lastNameValue != null && lastNameValue.equalsIgnoreCase("RANDOM")) {
                lastNameValue = RandomDataGenerator.generateLastName();
            }
        String emailInput = formDataMap.get("email");
            if (emailInput != null && emailInput.equalsIgnoreCase("RANDOM")) {
                emailInput = RandomDataGenerator.generateRandomEmail();
            }
        String password = formDataMap.get("password");
        registerPage.fillInTheRegisterForm(firstNameValue, lastNameValue, emailInput, password, true);
            if (password != null && password.equalsIgnoreCase("RANDOM")) {
                password = RandomDataGenerator.generatePassword();
            }
    }
}
