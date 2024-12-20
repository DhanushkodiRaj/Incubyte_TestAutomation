package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

    By signInButton = By.linkText("Sign In");
    By accountLink = By.xpath("//div[text()='Thank you for registering with Main Website Store.']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
		PageFactory.initElements(driver, this);
    }

    public void clickSignInButton() {
        driver.findElement(By.xpath("//a[text()='Create an Account']")).click();
    }

    public boolean isAccountLinkVisible() {
        return driver.findElement(accountLink).isDisplayed();
    }
}