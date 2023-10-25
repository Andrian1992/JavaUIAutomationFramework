package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGenerator;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.*;

public class TestRunnerWithPageObjects {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.andreisecuqa.host/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPageFromHeader();
        RegisterPage registerPage = new RegisterPage(driver);

        String randomEmail = RandomDataGenerator.generateRandomEmail();
        String password = RandomDataGenerator.generatePassword();
        System.out.println(randomEmail);
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataGenerator.generateFirstName(), RandomDataGenerator.generateLastName(),
                randomEmail, password, true);

        registerPage.clickTheContinueBtn();

        DriverManager.getInstance().tearDown();
        System.out.println("The execution is over");
    }
}