package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends ProjectMethods{
	@BeforeTest()
	public void setData() {
		sheetName="createlead";
		author="Anita";
		category="Common";
		testName="CreateLead";
		desc="Create a new lead";
		
	}
	@Test(dataProvider="fetchData")

	public void createLead(String cname, String fname, String lname, String email, String phonenumber) {
		System.out.println(cname);
//		WebElement crmLink = locateElement("linkText", "CRM/SFA");
//		click(crmLink);
		click(locateElement("linkText", "CRM/SFA"));
		WebElement leadLink = locateElement("linkText", "Leads");
		click(leadLink);
//		click(locateElement("linkText", "leadLink"));
		click(locateElement("linkText", "Create Lead"));
		
		//WebElement locateElement = locateElement("xpath", "(//input[@name='companyName'])[2]");
		//type(locateElement, cname);
		type(locateElement("xpath", "//*[@id='createLeadForm_companyName']"),cname);
		type(locateElement("xpath", "//*[@id='createLeadForm_firstName']"),fname);
		type(locateElement("xpath", "//*[@id='createLeadForm_lastName']"),lname);
		type(locateElement("xpath", "//*[@id='createLeadForm_primaryEmail']"),"anita14@gmail.com");
		type(locateElement("xpath", "//*[@id='createLeadForm_primaryPhoneNumber']"),"9500147848");
		click(locateElement("name", "submitButton"));
	}		
	
//		@DataProvider(name="fetchData")
//		public String[][] getexcelData(){
//		ReadExcelData excel = new ReadExcelData();
//		return excel.getData(sheetName);
	}
//@DataProvider(name="fetchData")
//public String[][] getData(){
//	String[][] data = new String[2][4];
//	data[0][0] = "Renault";
//	data[0][1] = "Anita";
//	data[0][2] = "S";
//	data[0][3] = "anita14@gmail.com";
		
//	data[1][0] = "Nissan";
//	data[1][1] = "Anish";
//	data[1][2] = "S";
//	data[1][3] = "anita13@gmail.com";
