package Week4Day3;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnReport {
	public static void main(String args[]) throws IOException {
		//Creating a flat file
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.html");
		// To maintain the history of the existing run reports
		html.setAppendExisting(true);
		//To write or configure the file
		ExtentReports extent = new ExtentReports();
		//Configuration is attached to a created file
		extent.attachReporter(html);
		//Create a testcase
		ExtentTest test = extent.createTest("TC001_Login", "Login to LeafTaps");
		//Author name
		test.assignAuthor("Anita");
		//Group name
		//test.assignCategory("Smoke");
		//Passing the value (we can give fail,warn,info)
		ExtentTest testData = test.createNode("");
		testData.pass("Entered Username Successfully");
		//Attach the snapshot
		MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img1.png").build();
		testData.pass("Entered crmsfa is Successfully");
		//Warning the value
		testData.warning("Login not clicked Successfully");
		// Perform the report
		extent.flush();
		
		
		
		
		
		
	}

}
