package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    By emailField = By.id("email");
    By passwordField = By.id("pass");
    By signInButton = By.xpath("//button[@title='Sign In']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
		PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }
}