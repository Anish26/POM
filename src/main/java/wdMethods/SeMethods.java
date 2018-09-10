package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SeMethods extends Report implements WdMethods{
	public RemoteWebDriver driver=null;
	public int count=1;
	@Override
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			reportStep("The Browser "+browser+" Launched Successfully","Pass");
		} catch (WebDriverException e) {
			reportStep("The unknown error found","Fail");
		}
	finally {
			takeSnap();
		}

	}
	public WebElement locateElement(String locator, String locValue) {
		WebElement element = null;

		try {
			switch(locator) {
			case "id"	 : return driver.findElementById(locValue);
			case "class" : return driver.findElementByClassName(locValue);
			case "xpath" : return driver.findElementByXPath(locValue);
			case "linkText" : return driver.findElementByLinkText(locValue);
			case "name" :return driver.findElementByName(locValue);
			case "tagname" : return driver.findElementByTagName(locValue);
			case "partialtext": return driver.findElementByPartialLinkText(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("The element is not found","Fail");
			e.printStackTrace();
		}
		catch (WebDriverException e) {
			reportStep("Driver is not found", "Fail");
		}
		return element;
	}
	@Override
	public WebElement locateElement(String locValue) {

		return null;
	}
	
	public void type(WebElement ele, String data) throws NoSuchElementException {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data "+data+" is Entered Successfully","Pass");
		} catch (WebDriverException e) {
			reportStep("Driver is not found", "Fail");
			e.printStackTrace();
		}
		finally {
				takeSnap();
		}
	} 	
	
	public void clickWithNoSnap(WebElement ele) {


		ele.click();
		System.out.println("The Element "+ele+" Clicked Successfully");

	}


	@Override
	public void click(WebElement ele) {

		try {
			ele.click();
			reportStep("The Element "+ele+" Clicked Successfully","Pass");
			takeSnap();
		} catch (NoSuchElementException e) {
			reportStep("Element is not found","Fail");
			e.printStackTrace();
		}
		catch (WebDriverException e) {
			reportStep("Driver is not found", "Fail");
		}
		finally {
			takeSnap();
		}
	}
	

	@Override
	public String getText(WebElement ele) {
		String data;
		try {
			data = ele.getText();
		} catch (NoSuchFrameException e) {
			reportStep("Element is not found", "Fail");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}
		return data;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select src = new Select(ele);
			src.selectByVisibleText(value);
			reportStep("The dropdown is selected with"+value,"Pass");
		} catch (WebDriverException e) {
			reportStep("The dropdown is not selected with"+value,"Fail");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
			}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select src = new Select(ele);
			src.selectByIndex(index);
			reportStep("The dropdown is selected with "+index,"Pass");
		} catch (WebDriverException e) {
			reportStep("The dropdown is not selected with"+index,"Fail");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
	}

	@Override
	public boolean verifyTitle(String expectedTitle) {
		try {
			String text=driver.getTitle();
			if(text.equals(expectedTitle)) {
				reportStep("The expected title matches the actual "+expectedTitle,"Pass");
			}
				else {
					reportStep("The expected title doesn't matches the actual"+expectedTitle,"Fail");
			}
		} catch (NoSuchElementException e) {
			reportStep("Element is not found", "Fail");
			throw new RuntimeException();
		}
		finally {
			takeSnap();
		}
		return false;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
				try {
					if(getText(ele).equals(expectedText)){
						reportStep("The expected text matches the actual"+expectedText,"Pass");
						}
					else {
						reportStep("The expected text doesn't matches the actual"+expectedText,"Fail");
					}
				} catch (NoSuchElementException e) {
					reportStep("Element is not found","Fail");
					throw new RuntimeException();
				}
				finally {
					takeSnap();
					}
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).contains(expectedText)) {
				reportStep("The expected text contains the actual"+expectedText,"Pass");
				}
			else {
				reportStep("The expected text doesn't contains the actual"+expectedText,"Pass");
			}
		} catch (NoSuchElementException e) {
			reportStep("Element is not found","Fail");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {	
		try {
		String att = ele.getAttribute(attribute);
				if(att.contains(value)) {
			reportStep("The expceted attribute value contains the actual "+value,"Pass");
				}else {
				reportStep("The expected attribute value doesn't contain the actual"+value,"Fail");
			}
				}
			catch(NoSuchElementException e){
				reportStep("Element is not found","Fail");
				throw new RuntimeException();
			}
			finally {
				takeSnap();
			}

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			String arb = ele.getAttribute(attribute);
			if(arb.contains(value)) {
				reportStep("The expceted attribute value contains the actual "+value,"Pass");
			}else {
				reportStep("The expected attribite value doesn't contains the actual"+value,"Fail");
			}
		} catch (NoSuchElementException e) {
			reportStep("Element is not found","Fail");
			throw new RuntimeException();
		}
		finally {
			takeSnap();
		}
	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			if (ele.isSelected()) {
				reportStep("The element is Selected Successfully","Pass");
			}else {
					reportStep("The element is not Selected Successfully","Fail");
				}
		} catch (NoSuchElementException e) {
			reportStep("Element is not found","Fail");
			throw new RuntimeException();
			}
		finally {
			takeSnap();
		}
		}

	

	@Override
	public void verifyDisplayed(WebElement ele) {
		
		try {
			if(ele.isDisplayed()) {
				reportStep("The element is verified Successfully","Pass");
			}else {
				reportStep("The element is not verified Successfully","Fail");
			}
		} catch (NoSuchElementException e) {
			reportStep("Element is not found","Fail");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
		

	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> allwin = driver.getWindowHandles();
			List<String> allList = new ArrayList<String>();
			allList.addAll(allwin);
			driver.switchTo().window(allList.get(index));
		} catch (NoSuchWindowException e) {
			reportStep("The driver could not moving to the given Window","Fail");
			throw new RuntimeException();
		}
		finally {
			takeSnap();
		}

	}

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			reportStep("Frame is switched Successfully","Pass");
		} catch (NoSuchFrameException e) {
			reportStep("Frame is not present","Fail");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}

	}

	@Override
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			reportStep("The alert is accepted Successfully","Pass");
		} catch (NoAlertPresentException e) {
			reportStep("Alert is not present","Fail");
			e.printStackTrace();
		}
		catch(UnhandledAlertException e) {
			reportStep("Alert is not handled","Fail");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}

	}

	@Override
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			reportStep("The alet is dismissed","Pass");
			} catch (NoAlertPresentException e) {
			reportStep("There is no alert Present","Fail");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
		

	}

	@Override
	public String getAlertText() {
		try {
			String text = driver.switchTo().alert().getText();
			return text;
			} 
		catch (NoAlertPresentException e) {
			reportStep("Alert is not present","Fail");
			return null;
			}
		
		
	}


	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img"+count+".png");
		try {
			FileUtils.copyFile(src, des);
			reportStep("The Screenshot was taken successfully","Pass");
		} catch (IOException e) {
			reportStep("IOException","Fail");
		}
		count++;
	}

	@Override
	public void closeBrowser() {
		try {
			driver.close();
			reportStep("The Browser is closed Successfully","Pass");
		} catch (WebDriverException e) {
			reportStep("Driver is not found", "Fail");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
	}

	@Override
	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The all Browser is closed Successfully","Pass");
		} catch (WebDriverException e) {
			reportStep("Driver is not found", "Fail");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}

	}

}
