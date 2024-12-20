package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	public WebDriver driver;

    By firstNameField = By.id("firstname");
    By lastNameField = By.id("lastname");
    By emailField = By.id("email_address");
    By passwordField = By.id("password");
    By passwordConfirmationField = By.id("password-confirmation");
    By submitButton = By.xpath("//button[@title='Create an Account']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
		PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void confirmPassword(String password) {
        driver.findElement(passwordConfirmationField).sendKeys(password);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }
}