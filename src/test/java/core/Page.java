package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import static utility.ScreenShot.*;
import static utility.Report.*;

import java.time.Duration;
public class Page 
{
	public static WebDriver driver = null;
	
  @Parameters({"browser","url","reportname","testname","key"})
  @BeforeTest
  public void beforeTest(String browser,String url,String reportname,String testname,String key) throws Exception 
  {
	  if(!Boolean.parseBoolean(key))
	  {
		  throw new SkipException("skip test "+testname);
	  }
	  else
	  {
		  // report init
		  generateReport(reportname,testname);
		  
		  // browser init..
		  
		  if(browser.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.err.println("error  in inpugt..");
			}
			driver.get(url);
			
			PageFactory.initElements(driver, this); // compulsory to init driver in PageFactory to read external xpath
			
			// add comment in report..
			test.log(Status.PASS, MarkupHelper.createLabel("Browser "+browser+" url "+url+" opens.." ,ExtentColor.GREEN));
			
			// screen shot..
			takeScreenShot("openBrowser");
			
			// implicit wait.. common timeout for all element
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.manage().window().maximize(); // full screen
		  
	  }
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();  // close browser session
	  
	  report.flush(); // close report
  }

}
