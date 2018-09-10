package Week1Day3;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EditLead {
	@Test
	public void editLead() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Anita");
		Thread.sleep(3000);
		driver.findElementByXPath("(//button[text()='Find Leads'])").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		System.out.println("Clicked");
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElementByLinkText("Edit").click();
		
//		driver.findElementByClassName("subMenuButton").click();
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("Nissan");
		driver.findElementByClassName("smallSubmit").click();
		String text = driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println(text);
//		String text = driver.getText();
		driver.findElementById("createLeadForm_companyName");
		if (text ==("View Lead | opentaps CRM"))
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
		driver.close();
	
		

	}
}
