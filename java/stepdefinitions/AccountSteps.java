package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class AccountSteps {

	public WebDriver driver;
	public HomePage homePage;
	public RegistrationPage registrationPage;
	public LoginPage loginPage;

    @Given("User is on the Magento homepage")
    public void user_is_on_the_magento_homepage() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origin=*");
    	options.addArguments("start-maximized");
    	//options.setBinary("C:\\Users\\Dhanush\\Automation_FW\\Incubyte_SeleniumFW\\src\\test\\resources\\chrome.exe");
    	driver  = new ChromeDriver(options);
    	driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("User clicks on Create an Account link")
    public void user_clicks_on_create_an_account_link() {
        homePage = new HomePage(driver);
        homePage.clickSignInButton();
    }

    @When("User fills in registration form with {string}, {string}, {string}, and {string}")
    public void user_fills_in_registration_form(String firstName, String lastName, String email, String password) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.confirmPassword(password);
        registrationPage.submitForm();
    }

    @When("User signs in with {string} and {string}")
    public void user_signs_in_with(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickSignIn();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        assertTrue(homePage.isAccountLinkVisible());
        driver.quit();
    }
}