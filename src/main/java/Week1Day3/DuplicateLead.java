package Week1Day3;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DuplicateLead {
	@Test
	public void duplicateLead() throws IOException, InterruptedException {

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
	driver.findElementByLinkText("Email").click();
	driver.findElementById("ext-gen282").sendKeys("anita14@gmail.com");
	driver.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(3000);
	driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]");
	driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
	driver.findElementByLinkText("Duplicate Lead").click();
	String title = driver.getTitle();
	if(title.contains(title)) {
		System.out.println("Verification is Success");
		System.out.println("page title is:" + title);
	}
	else {
		System.out.println("verification is failed");
	}
	driver.findElementByXPath("//input[@type='submit']").click();
	driver.close();
//	File src1 = driver.getScreenshotAs(OutputType.FILE);
//	File dec = new File("./snaps/img2.png");
//	FileUtils.copyFile(src1, dec);

}
}

