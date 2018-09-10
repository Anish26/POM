package Week1Day2;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/");
		driver.findElementByLinkText("Drop down").click();
		WebElement drop = driver.findElementById("dropdown1");
	    Select sel = new Select(drop);
		sel.selectByIndex(2);
		
		// By Using Visible Text//
		
		WebElement drop1 = driver.findElementById("dropdown2");
		Select sel1 = new Select(drop1);
		//sel1.selectByVisibleText("Selenium");
		sel1.selectByVisibleText("Appium");
		//sel1.selectByVisibleText("UFT/QTP");
		//sel1.selectByVisibleText("Loadrunner");
		
		// By Using Value//
		driver.findElementByLinkText("Drop down").click();
		WebElement drop2 = driver.findElementById("dropdown3");
		Select sel2 = new Select(drop2);
		//sel2.selectByValue("1");
		//sel2.selectByValue("2");
		sel2.selectByValue("3");
		//sel2.selectByValue("4");
		
		
		

}
}
