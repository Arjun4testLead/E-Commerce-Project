package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginPageTest extends Base{
	
	WebDriver drivder;
	HomePage homePage;
	LoginPage loginPage;
	
	String url = "https://tutorialsninja.com/demo/";
	
	@BeforeMethod
	public void setup() throws Exception {
		driver = startBrowserAndGoToURL("Chrome", url);
		homePage = new HomePage(driver);
		loginPage = homePage.goToLoginPage();
	}
	
	@Test
	public void verifyLoginWithValidCredentials() {
		loginPage.loginToApplication("cPjt1VuKY@gmail.com", "nQQCkC");
		System.out.println("title: "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "My Account");
	}
	
	@Test
	public void verifyLoginWithvalidIdAndInvalidPassword() {
		loginPage.loginToApplication("AKMI4dMUh@gmail.com", "qDEBeXy");
		Assert.assertEquals((loginPage.getAlerttext().equals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.")||loginPage.getAlerttext().equals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.")), true);
	}
	
	@Test
	public void verifyLoginWithInvalidIdAndvalidPassword() {
		loginPage.loginToApplication("fFJ56ofZMPQ@gmail.com", "YYnqFp");
		Assert.assertEquals(loginPage.getAlerttext(), "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour." );
	}
	
	@Test
	public void verifyLoginWithInvalidIdAndInvalidPassword() {
		loginPage.loginToApplication("6v6Chgro2JE@gmail.com", "IPcffLxQ");
		Assert.assertEquals(loginPage.getAlerttext(), "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour." );
	}
	

}
