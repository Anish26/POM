package Week2Day2;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandles {
	public static void main(String[] args)  {

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://legacy.crystalcruises.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByLinkText("GUEST CHECK-IN").click();
		System.out.println(driver.getTitle());
		
		Set<String> allwin = driver.getWindowHandles();
		List<String> allList = new ArrayList<String>();
		allList.addAll(allwin);
		driver.switchTo().window(allList.get(1));
		
		System.out.println(driver.getTitle());
		
		driver.findElementByPartialLinkText("View Offer»").click();
		allwin = driver.getWindowHandles();
		allList = new ArrayList<String>();
		allList.addAll(allwin);
		driver.switchTo().window(allList.get(2));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		

		
		
		
		
}
}
