package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class CreateLeads_se extends SeMethods {
		@Test
		
	   public void create()
	   {
		startApp("chrome","http://leaftaps.com/opentaps");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesmanager");
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");
		WebElement eleclick = locateElement("class", "decorativeSubmit");
		click(eleclick);
		WebElement crm = locateElement("linktext", "CRM/SFA");
		click(crm);
		WebElement leads = locateElement("linktext", "Leads");
		click(leads);
		WebElement create = locateElement("partiallinktext", "Create");
		click(create);
		WebElement eleCompName = locateElement("id", "createLeadForm_companyName");
		type(eleCompName, "Testleaf");
		WebElement eleFirstName = locateElement("id", "createLeadForm_firstName");
		type(eleFirstName, "Anita");
		WebElement eleLastName = locateElement("id", "createLeadForm_lastName");
		type(eleLastName, "S");
		
		WebElement ds = locateElement("id", "createLeadForm_dataSourceId");
		ds.click();
		selectDropDownUsingIndex(ds, 3);
		WebElement ds1 = locateElement("id", "createLeadForm_marketingCampaignId");
		ds1.click();
		selectDropDownUsingText(ds1,"CATRQ_CAMPAIGNS" );
		WebElement eleFirstNameLocal = locateElement("id","createLeadForm_firstNameLocal");
		type(eleFirstNameLocal, "Satish");
		
		WebElement ds2 = locateElement("id", "createLeadForm_currencyUomId");
		ds2.click();
		selectDropDownUsingText(ds2, "PLZ - Poland");
		WebElement eleclick1 = locateElement("name", "submitButton");
		click(eleclick1);
		
		
		
		
		
	   }	
		
	
		

	}


