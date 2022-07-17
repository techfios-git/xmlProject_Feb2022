package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"username", "password", "fullName", "companyName", "email", "phone", "address", "city", "country", "state",  "zip"})
	public void userShouldBeAbleToCreateNewCustomer(String userName, String password, String fullName, String companyName, String email, String phoneNum, String address, String city, String country, String state, String zip) throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage("Dashboard"); 
		dashboardPage.clickCustomerMenuElement();
		dashboardPage.clickAddCustomerMenuElement();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddContactPage("Add Contact");
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhoneNum(phoneNum);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.selectCountry(country);
		addCustomerPage.insertZip(zip);
		addCustomerPage.clickSaveButton();
		
		dashboardPage.clickListCustomerMenuElement();
		addCustomerPage.validateInsertedCustomerAndDelete();
		
		
		
	}

}
