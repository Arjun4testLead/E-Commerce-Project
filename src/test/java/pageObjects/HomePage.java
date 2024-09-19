package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccountOption;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li[1]/a")
	WebElement registerOption;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a")
	WebElement loginOption;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public RegisterPage goToRegisterPage() {
		myAccountOption.click();
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public LoginPage goToLoginPage() {
		myAccountOption.click();
		loginOption.click();
		return new LoginPage(driver);
	}

}
