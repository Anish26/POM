package Week1Day2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropDown {
	public static void main(String[] args) throws IOException {
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
		WebElement src = driver.findElementById("createLeadForm_dataSourceId");
		Select sel = new Select(src);
		sel.selectByVisibleText("Direct Mail");
		sel.selectByValue("LEAD_TRADESHOW");
		sel.selectByIndex(5);	
		List<WebElement> allOptions = sel.getOptions();
		System.out.println(allOptions.get(1).getText());
		int count = allOptions.size();
		System.out.println(count);
		/*for (int i = 0; i <count; i++) {
		System.out.println(allOptions.get(i).getText());	
		}*/
		for (WebElement eachOption : allOptions) {
		System.out.println(eachOption.getText());
		//Take Snapshot
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dec = new File("./snaps/img1.png");
		FileUtils.copyFile(src1, dec);
		
		
		}
	
	}
	}