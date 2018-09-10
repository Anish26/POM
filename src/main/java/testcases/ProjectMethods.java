package testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Week4Day2.ReadExcelData;
import wdMethods.SeMethods;

public class ProjectMethods extends SeMethods {
	
	public static String sheetName,author,category,testName,desc;
	
	@BeforeSuite
	public void beforeSuite() {
		startResult();
	}
	@BeforeClass
	public void beforeClass() {
		startTestCase(testName,desc);
	}
	@Parameters({"url", "uname", "pwd"})
	@BeforeMethod()
		public void login(String URL, String username, String password) {
		beforeMethod(author,category);
		startApp("chrome", URL);
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, username);
		WebElement elePassword = locateElement("id","password");
		type(elePassword, password);
		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		
	}
	@AfterMethod()
	public void close() {
		closeAllBrowsers();
}
	@DataProvider(name="fetchData")
	public String[][] getexcelData() throws IOException{
	ReadExcelData excel = new ReadExcelData();	
	return excel.getData(sheetName);
	}
	@AfterSuite
	public void endTestResult() {
		//extent.flush();
		endResult();
		
	}
}