package Week2Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class CloseMeButtons {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://layout.jquery-dev.com/demos/iframe_local.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		For West pane close button
		driver.switchTo().frame("childIframe");
		driver.findElementByXPath("(//div[@class='ui-layout-west ui-layout-pane ui-layout-pane-west'])[1]");
		driver.findElementByXPath("(//button[text()='Close Me'])[1]").click();
		
		
		
//		For East pane close button
//		
//		driver.findElementByXPath("//button[@onclick='$(this).closest('.ui-layout-pane').trigger('layoutpaneclose')']").click();

		
	}
}
