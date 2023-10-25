package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGenerator;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();

        // new window code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.andreisecuqa.host/");
        Thread.sleep(2000);

        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccountIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
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

//        WebElement phoneInput = driver.findElement(By.cssSelector("#input-telephone"));
//        String randomPhoneNumber = RandomDataGenerator.generatePhoneNumber();
//        phoneInput.sendKeys(randomPhoneNumber);
//        System.out.println(randomPhoneNumber);

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String password = RandomDataGenerator.generatePassword();
        passwordInput.sendKeys(password);

//        WebElement confirmPassword = driver.findElement(By.cssSelector("#input-confirm"));
//        confirmPassword.sendKeys(password);
        System.out.println(password);


        WebElement termsAndConditionsToggleBar = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));

        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);" , termsAndConditionsToggleBar);
        Thread.sleep(1000);
        termsAndConditionsToggleBar.click();
        WebElement registerButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
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