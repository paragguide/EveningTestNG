package testcases;

import static utility.Report.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;

public class ForgetTest extends Hook
{
  @Test
  public void forget() 
  {
	  signin.click();
	  help.click();
	  forgetlink.click();
	  
	  uid.sendKeys("9810926239");
	  ctnbtn.click();
	  
	  test.log(Status.PASS, MarkupHelper.createLabel("OTP sent" ,ExtentColor.GREEN));
		
  }
}
