package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();

        // new window code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://opencart.antropy.co.uk/");
        Thread.sleep(2000);

        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        myAccountIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']"));
        registerOption.click();

        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        String firstName = RandomDataGenerator.generateFirstName();
        firstNameInput.sendKeys(firstName);
        System.out.println(firstName);

        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));
        String lastName = RandomDataGenerator.generateLastName();
        lastNameInput.sendKeys(lastName);
        System.out.println(lastName);

        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
        String randomEmail = RandomDataGenerator.generateRandomEmail();
        emailInput.sendKeys(randomEmail);
        System.out.println(randomEmail);

        WebElement phoneInput = driver.findElement(By.cssSelector("#input-telephone"));
        String randomPhoneNumber = RandomDataGenerator.generatePhoneNumber();
        phoneInput.sendKeys(randomPhoneNumber);
        System.out.println(randomPhoneNumber);


        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String password = RandomDataGenerator.generatePassword();
        passwordInput.sendKeys(password);

        WebElement confirmPassword = driver.findElement(By.cssSelector("#input-confirm"));
        confirmPassword.sendKeys(password);
        System.out.println(password);
        WebElement termsAndConditionsCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));

        termsAndConditionsCheckbox.click();

        WebElement registerButton = driver.findElement(By.xpath("//input[@value='Continue']"));

        registerButton.click();

        Thread.sleep(5000);


        System.out.println(driver.getTitle());
        driver.close();

        driver.switchTo().window(currentWindowName);
        driver.get("https://tekwill.md/");
        Thread.sleep(1000);
        System.out.println(driver.getTitle());
        driver.quit();
        System.out.println("The execution is over");
    }
}