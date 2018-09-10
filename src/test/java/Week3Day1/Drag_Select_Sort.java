package Week3Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_Select_Sort {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/draggable/");
//		Switch to frame
//		driver.switchTo().frame(0);
		
//		Draggable
//		WebElement drag = driver.findElementById("draggable");
//		Actions builder = new Actions(driver);
//		builder.dragAndDropBy(drag, 10, 20).perform();
		
//		Selectable
		driver.get("http://jqueryui.com/selectable/");
//		Switch to frame
//		driver.switchTo().frame(0);
//		WebElement it1 = driver.findElementByXPath("//li[text()='Item 1']");		
//		WebElement it3 = driver.findElementByXPath("//li[text()='Item 3']");		
//		WebElement it5 = driver.findElementByXPath("//li[text()='Item 5']");		
//		WebElement it7 = driver.findElementByXPath("//li[text()='Item 7']");
//		Actions builder = new Actions(driver);
//		builder.sendKeys(Keys.CONTROL).click(it1).click(it3).click(it5).click(it7).perform();
		
//		Sortable
		driver.get("http://jqueryui.com/sortable/");
		driver.switchTo().frame(0);
		WebElement sort1 = driver.findElementByXPath("(//li[@class='ui-state-default ui-sortable-handle'])[1]");
		WebElement sort4 = driver.findElementByXPath("(//li[@class='ui-state-default ui-sortable-handle'])[4]");
		int y =sort4.getLocation().getY();
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(sort1, 0, y).release().perform();
		
		
		
		

		
	}

}
