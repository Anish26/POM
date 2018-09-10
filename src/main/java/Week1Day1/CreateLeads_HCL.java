package Week1Day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLeads_HCL {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("HCL");
		driver.findElementById("createLeadForm_firstName").sendKeys("Anita");
		driver.findElementById("createLeadForm_lastName").sendKeys("S");
		driver.findElementById("createLeadForm_firstNameLocal").sendKeys("Satish");
		driver.findElementById("createLeadForm_lastNameLocal").sendKeys("Raj");
		driver.findElementById("createLeadForm_personalTitle").sendKeys("Ms");
		driver.findElementById("createLeadForm_generalProfTitle").sendKeys("TL");
		driver.findElementById("createLeadForm_departmentName").sendKeys("Testing");
		driver.findElementById("createLeadForm_annualRevenue").sendKeys("750000");
		driver.findElementById("createLeadForm_numberEmployees").sendKeys("300");
		driver.findElementById("createLeadForm_sicCode").sendKeys("25");
		driver.findElementById("createLeadForm_tickerSymbol").sendKeys("R");
		driver.findElementById("createLeadForm_description").sendKeys("XXX");
		driver.findElementById("createLeadForm_importantNote").sendKeys("YYY");
		driver.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("+91");
		driver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("044");
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("9500147848");
		driver.findElementById("createLeadForm_primaryPhoneExtension").sendKeys("111");
		driver.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("Satish");
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("satish14@gmail.com");
		driver.findElementById("createLeadForm_primaryWebUrl").sendKeys("http://leaftaps.com/crmsfa/control/createLeadForm");
		driver.findElementById("createLeadForm_generalToName").sendKeys("Anish");
		driver.findElementById("createLeadForm_generalAttnName").sendKeys("satish");
		driver.findElementById("createLeadForm_generalAddress1").sendKeys("95/C1,Vignesh Bhavan");
		driver.findElementById("createLeadForm_generalAddress2").sendKeys("South Street,Vannarpettai");
		driver.findElementById("createLeadForm_generalCity").sendKeys("Tirunelveli");
		driver.findElementById("createLeadForm_generalStateProvinceGeoId").sendKeys("Indiana");
		driver.findElementById("createLeadForm_generalPostalCode").sendKeys("600041");
		driver.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("600");
		driver.findElementByClassName("smallSubmit").click();
	
	
	
	
	
	
	
	
	}	
}
