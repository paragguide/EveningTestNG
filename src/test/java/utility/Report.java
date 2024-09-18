package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report 
{
	public static ExtentReports report = null;
	public static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;
	
	
	public static void generateReport(String reportname,String testname)
	{
		String path = System.getProperty("user.dir")+"//src//test//java//reports//"+reportname+".html";
		
		report = new ExtentReports();
		spark = new ExtentSparkReporter(path);
		spark.config().setDocumentTitle(reportname);
		spark.config().setTheme(Theme.STANDARD);
		
		report.attachReporter(spark);
		test = report.createTest(testname);
	}

}
