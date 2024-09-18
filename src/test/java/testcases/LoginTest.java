package testcases;

import static utility.Report.report;
import static utility.Report.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;

public class LoginTest extends Hook
{
  @Test(priority=1,groups="login")
  public void validateUserid() 
  {
	  test = report.createTest("user validation");
	  signin.click();
	  
	  uid.sendKeys("paragguide@yahoo.co.in");
	  
	  ctnbtn.click();
	  
	  try {
		String error1 =  err1.getText();
		test.log(Status.FAIL, MarkupHelper.createLabel("uid is valid but error message coming" ,ExtentColor.RED));
		Assert.fail("uid is valid but error message coming");
	  }
	  catch(Exception e)
	  {
		  test.log(Status.PASS, MarkupHelper.createLabel("uid is valid" ,ExtentColor.GREEN));
			
	  }
  }
  
  @Test(priority = 2,dependsOnMethods= {"validateUserid"},groups="login")
  public void validatePassword()
  {
	  pwd.sendKeys("RMinfotech12#&&");
	  submit.click();
	     try {
	  err2.getText();
	  test.log(Status.FAIL, MarkupHelper.createLabel("pwdd is valid but error message coming" ,ExtentColor.RED));
		Assert.fail("pwdd is valid but error message coming");
	     }
	     catch(Exception e)
	     {
	    	 test.log(Status.PASS, MarkupHelper.createLabel("pwdd is valid" ,ExtentColor.GREEN));
				 
	     }
  }
}
