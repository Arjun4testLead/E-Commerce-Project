package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObjects.AddressBookPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class AddressbookPageTest extends Base{
	
	WebDriver driver;
	
	HomePage homePage;
	LoginPage loginPage;
	AddressBookPage addressBookPage;
	Faker faker;
	
	String url = "https://tutorialsninja.com/demo/";
	String firstnameText, lastnameText, companyNameText, addressText1, addressText2, cityNameText, postCodeText, countryNameText;
	
	@BeforeMethod
	public void setup() throws Exception {
		driver = startBrowserAndGoToURL("firefox", url);
		faker = new Faker();
		firstnameText = faker.name().firstName();
		lastnameText = faker.name().lastName();
		companyNameText = faker.company().name();
		addressText1 = faker.address().streetAddress();
		addressText2 = faker.address().streetAddress();
		cityNameText = faker.address().city();
		postCodeText = faker.address().zipCode();
		countryNameText = faker.address().country();
		
		
		homePage = new HomePage(driver);
		loginPage = homePage.goToLoginPage();
		
		file = new File("./testDatas\\testData.properties");
		fis = new FileInputStream(file);
		pro = new Properties();
		pro.load(fis);
		loginPage.loginToApplication(pro.getProperty("userName1"), pro.getProperty("password1"));
		addressBookPage = loginPage.goToAddressbookPage();
	}
	@Test(priority=1)
	public void addANewAddress() throws Exception {
		addressBookPage.clickNewAddressButton();
		addressBookPage.enterFirstName(firstnameText);
		addressBookPage.enterLastName(lastnameText);
		addressBookPage.enterCompanyName(companyNameText);
		addressBookPage.enterAddress1(addressText1);
		addressBookPage.enterAddress2(addressText2);
		addressBookPage.enterCityName(cityNameText);
		addressBookPage.enterPostCode(postCodeText);
		addressBookPage.selectContry(countryNameText);
		addressBookPage.selectState(4);
		addressBookPage.selectDefaultAddressNO();
		addressBookPage.clickContinueButton();
	}
	
	@Test(priority=2)
	public void addNewAddress() throws Exception {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		addressBookPage.newAddressWithAllFields(firstnameText, lastnameText, companyNameText, addressText1, addressText2, cityNameText, postCodeText, countryNameText);
	}

}
