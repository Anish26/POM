package Week3Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Indeed_HomeWork {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		Get URL
		driver.get("https://www.indeed.co.in/Fresher-jobs");
//		Print first url
		
		WebElement del = driver.findElementByLinkText("Delivery boy / Biker / Riders");
		Actions builder = new Actions(driver);
		builder.sendKeys(del,Keys.CONTROL).click(del).perform();
		Set<String> allwin = driver.getWindowHandles();
		List<String> allList = new ArrayList<String>();
		allList.addAll(allwin);
		driver.switchTo().window(allList.get(1));
//		builder.sendKeys(Keys.CONTROL).click(del).perform();
		System.out.println(driver.getTitle());
		driver.close();
//		Switch to main page
//		driver.switchTo().frame(0);
		
		
	}

}
