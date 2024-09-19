package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressBookPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//a[text()='New Address']")
	WebElement newAddressOption;

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstnameTextBox;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastnameTexBox;

	@FindBy(xpath = "//input[@name='company']")
	WebElement companyNameTextBox;

	@FindBy(xpath = "//input[@name='address_1']")
	WebElement addressTexBox1;

	@FindBy(xpath = "//input[@name='address_2']")
	WebElement addressTextBox2;

	@FindBy(xpath = "//input[@name='city']")
	WebElement citinameTextBox;

	@FindBy(xpath = "//input[@name='postcode']")
	WebElement postcodeTextBox;

	@FindBy(css = "#input-country")
	WebElement countryDropdown;

	@FindBy(xpath = "//select[@name='zone_id']")
	WebElement stateDropdown;

	@FindBy(xpath = "//input[@name='default' and @value='0']")
	WebElement defaultAddressNo;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;

	public AddressBookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickNewAddressButton() {
		newAddressOption.click();
	}
	public void enterFirstName(String firstnameText) {
		firstnameTextBox.sendKeys(firstnameText);
	}
	public void enterLastName(String lastnameText) {
		lastnameTexBox.sendKeys(lastnameText);
	}
	public void enterCompanyName(String companyNameText) {
		companyNameTextBox.sendKeys(companyNameText);
	}
	public void enterAddress1(String addressText1) {
		addressTexBox1.sendKeys(addressText1);
	}
	public void enterAddress2(String addressText2) {
		addressTextBox2.sendKeys(addressText2);
	}
	public void enterCityName(String cityNameText) {
		citinameTextBox.sendKeys(cityNameText);
	}
	public void enterPostCode(String postCodeText) {
		postcodeTextBox.sendKeys(postCodeText);
	}
	public void selectContry(String countryNameText) throws Exception {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView();", countryDropdown);
		Select countrySelect = new Select(countryDropdown);
		countrySelect.selectByVisibleText(countryNameText);
		Thread.sleep(4000);
	}
	public void selectState(int stateNumber) throws Exception {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));
		Select stateSelect = new Select(stateDropdown);
		stateSelect.selectByIndex(stateNumber);
		Thread.sleep(5000);
	}
	public void selectDefaultAddressNO() {
		defaultAddressNo.click();
	}
	public void clickContinueButton() {
		continueButton.click();
	}

	public void newAddressWithAllFields(String firstnameText, String lastnameText, String companyNameText, String addressText1, String addressText2, String cityNameText, String postCodeText, String countryNameText) throws Exception {
		newAddressOption.click();
		firstnameTextBox.sendKeys(firstnameText);
		lastnameTexBox.sendKeys(lastnameText);
		companyNameTextBox.sendKeys(companyNameText);
		addressTexBox1.sendKeys(addressText1);
		addressTextBox2.sendKeys(addressText2);
		citinameTextBox.sendKeys(cityNameText);
		postcodeTextBox.sendKeys(postCodeText);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView();", countryDropdown);
		Select countrySelect = new Select(countryDropdown);
		countrySelect.selectByVisibleText(countryNameText);
		Thread.sleep(4000);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));
		new Select(stateDropdown).selectByIndex(4);
		Thread.sleep(5000);
		
		defaultAddressNo.click();
		continueButton.click();
	}
}
