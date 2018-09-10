	package Week2Day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MergeLeads {
@Test
	public void mergeLeads() throws IOException, InterruptedException  {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByPartialLinkText("Merge Lea").click();
		driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
		System.out.println(driver.getTitle());
		
		Set<String> allwin = driver.getWindowHandles();
		List<String> allList = new ArrayList<String>();
		allList.addAll(allwin);
		driver.switchTo().window(allList.get(1));
		driver.findElementByXPath("(//input[@type='text'])[2]").sendKeys("Anita");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		String idVal = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[3]").getText();
		System.out.println(idVal);
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[3]").click();
		
		driver.switchTo().window(allList.get(0));
		allwin = driver.getWindowHandles();
		allList = new ArrayList<String>();
		allList.addAll(allwin);
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		allwin = driver.getWindowHandles();
		allList = new ArrayList<String>();
		allList.addAll(allwin);
		Thread.sleep(3000);
		driver.switchTo().window(allList.get(1));
		driver.findElementByXPath("//input[@name='firstName']").sendKeys("Anita");
		driver.findElementByXPath("(//button[@class='x-btn-text'])[1]").click();
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[4]").click();
		driver.switchTo().window(allList.get(0));
		driver.findElementByLinkText("Merge").click();
		driver.switchTo().alert().accept();	
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());

	}

}
