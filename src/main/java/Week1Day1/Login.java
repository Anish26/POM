package Week1Day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Launch browser
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		//ClassName objectName = new className();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Load URL
		driver.get("http://leaftaps.com/opentaps/");
		//Enter Usernames
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//Enter Password
		driver.findElementById("password").sendKeys("crmsfa");
		//Click Login Button
		driver.findElementByClassName("decorativeSubmit").click();
		//Click Logout Button
		String text = driver.findElementById("form").getText();
		System.out.println("form");
		if (text.contains("Welcome")) {
			System.out.println("Text is matched");
		} else {
			System.out.println("Text is not matched");
		}

			}
}
