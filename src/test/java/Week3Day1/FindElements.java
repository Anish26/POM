package Week3Day1;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://www.google.co.in/search?q=anita&oq=anita&aqs=chrome.0.69i59l2j69i61j0l3.1436j1j7&sourceid=chrome&ie=UTF-8");
//		Get names in all Links
//		List<WebElement> allLinks = driver.findElementsByPartialLinkText("Anita");
//		System.out.println(allLinks.size());
//		for(WebElement an : allLinks) {
//			System.out.println(an.getText());
		
		driver.get("https://www.google.co.in/search?q=cricket&oq=crik&aqs=chrome.1.69i57j0l5.5968j1j7&sourceid=chrome&ie=UTF-8");
		List<WebElement> allWords = driver.findElementsByPartialLinkText("cricket".toUpperCase());
		System.out.println(allWords.size());
		allWords = driver.findElementsByPartialLinkText("Cricket".toLowerCase());
		System.out.println(allWords.size());
		
		
		
		
		}
	}


