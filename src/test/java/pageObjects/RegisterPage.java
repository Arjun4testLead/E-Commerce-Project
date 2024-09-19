package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstnameTextBox;
	
	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastnameTextBox;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailTextBox;
	
	@FindBy(xpath = "//input[@name='telephone']")
	WebElement telephoneTextBox;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@name='confirm']")
	WebElement passwordConfirmTextBox;
	
	@FindBy(xpath = "//div[@class='col-sm-10']/label[1]")
	WebElement subscribeYes;
	
	@FindBy(xpath = "//div[@class='col-sm-10']/label[2]")
	WebElement subscribeNo;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement privatePoliceyTickBox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement registerStatusElement;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstname(String firstnameText) {
		firstnameTextBox.sendKeys(firstnameText);
	}
	
	public void enterlastname(String lastnameText) {
		lastnameTextBox.sendKeys(lastnameText);
	}
	
	public void enterEmail(String emailText) {
		emailTextBox.sendKeys(emailText);
	}
	
	public void enterTelephoneNo(String telephoneText) {
		telephoneTextBox.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		passwordConfirmTextBox.sendKeys(confirmPasswordText);
	}
	
	public void clickSubscribeYes() {
		subscribeYes.click();
	}
	
	public void clickSubscribeNo() {
		subscribeNo.click();
	}
	
	public void clickPolicyAgreement() {
		privatePoliceyTickBox.click();
	}
	
	public void clickContinueButton() {
		continueButton.click();
	}
	
	public String registerStatusMessage() {
		return registerStatusElement.getText();
	}
	
	public void registerWithAllFields(String firstnameText, String lastnameText, String emailText, String telephoneText, String passwordText, String passwordConfirmText) {
		firstnameTextBox.sendKeys(firstnameText);
		lastnameTextBox.sendKeys(lastnameText);
		emailTextBox.sendKeys(emailText);
		telephoneTextBox.sendKeys(telephoneText);
		passwordTextBox.sendKeys(passwordText);
		passwordConfirmTextBox.sendKeys(passwordConfirmText);
		subscribeNo.click();
		privatePoliceyTickBox.click();
		continueButton.click();
	}
	
	public void registerWithMandatoryFields(String firstnameText, String lastnameText, String emailText, String telephoneText, String passwordText, String passwordConfirmText) {
		firstnameTextBox.sendKeys(firstnameText);
		lastnameTextBox.sendKeys(lastnameText);
		emailTextBox.sendKeys(emailText);
		telephoneTextBox.sendKeys(telephoneText);
		passwordTextBox.sendKeys(passwordText);
		passwordConfirmTextBox.sendKeys(passwordConfirmText);
		privatePoliceyTickBox.click();
		continueButton.click();
	}

}
