package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.Base;

public class LoginPage extends Base{
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement usernameTextBox;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@name='password']//following::a[1]")
	WebElement passwordConfirmTextBoxt;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	WebElement alertElement;
	
	@FindBy(xpath = "//a[text()='Address Book']")
	WebElement addressbookOption;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void enterEmailAddress(String emailText) {
		usernameTextBox.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		passwordConfirmTextBoxt.sendKeys(confirmPasswordText);
	}
	
	public void clicLoginButton() {
		loginButton.click();
	}
	
	public String getAlerttext() {
		return alertElement.getText();
	}
	
	public void loginToApplication(String userEmailText, String passWordText) {
		usernameTextBox.sendKeys(userEmailText);
		passwordTextBox.sendKeys(passWordText);
		passwordConfirmTextBoxt.sendKeys(passWordText);
		loginButton.click();
	}
	
	public AddressBookPage goToAddressbookPage() {
		addressbookOption.click();
		return new AddressBookPage(driver);
	}

}
