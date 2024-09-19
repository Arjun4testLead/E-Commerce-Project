package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class RegisterPageTest extends Base{
	
	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	Faker faker;
	
	String url = "https://tutorialsninja.com/demo/";
	String firstnameText, lastnameText, emailText, telephoneText, passwordText, passwordConfirmText;
	
	@BeforeMethod
	public void setup() {
		faker = new Faker();
		firstnameText = faker.name().firstName();
		lastnameText = faker.name().lastName();
		emailText = RandomStringUtils.randomAlphanumeric(9)+"@gmail.com";
		telephoneText = faker.phoneNumber().cellPhone();
		passwordText = RandomStringUtils.randomAlphabetic(6);
		passwordConfirmText = passwordText;
		
		driver = startBrowserAndGoToURL("Chrome", url);
		homePage = new HomePage(driver);
		registerPage = homePage.goToRegisterPage();
		
		System.out.println("userName: "+emailText);
		System.out.println("password: "+passwordText);
	}
	
	@Test
	public void verifyRegisterWihAllFields() {
		registerPage.registerWithAllFields(firstnameText, lastnameText, emailText, telephoneText, passwordText, passwordConfirmText);
		Assert.assertEquals(registerPage.registerStatusMessage(), "Your Account Has Been Created!");
	}
	
	@Test
	public void verifyRgisterWithMandatoryFields() {
		registerPage.registerWithMandatoryFields(firstnameText, lastnameText, emailText, telephoneText, passwordText, passwordConfirmText);
		Assert.assertEquals(registerPage.registerStatusMessage(), "Your Account Has Been Created!");
	}
	

}
