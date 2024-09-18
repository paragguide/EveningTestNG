package testcases;

import static utility.Report.report;
import static utility.Report.test;
import static utility.ScreenShot.takeScreenShot;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;

public class ProductSearchTest extends Hook
{
  @Test(dataProvider="getProductData",dependsOnGroups = {"login"})
  public void productsearch(String prodname) throws Exception 
  {
	  test = report.createTest("Product Search-"+prodname);
	  
	  productsearchbox.clear();
	  productsearchbox.sendKeys(prodname);
	  Actions a = new Actions(driver);
	  a.sendKeys(Keys.ENTER).perform();
	  
	  // screenshot
	  takeScreenShot("ProductResult-"+prodname);
		
	  
	 int listofproduct = productlinks.size();
	   if(listofproduct <= 0)
	   {
		   test.log(Status.FAIL, MarkupHelper.createLabel("Product Not Found" ,ExtentColor.RED));
			Assert.fail("Product not found");
	   }
	   else
	   {
		   test.log(Status.PASS, MarkupHelper.createLabel("Total products founud for "+prodname+" : "+listofproduct ,ExtentColor.GREEN));
		   addtokart();
	   }
  }
  
  @DataProvider
  public String[][] getProductData() throws Exception
  {
	  return utility.MakeConnectionPOI.getData("AmazonLogin", "Sheet2");
  }
  
  @Test(dependsOnMethods= {"productsearch"})
  public void addtokart() throws Exception
  {
	Iterator <WebElement> it =  productlinks.iterator();
	
	//while(it.hasNext())
	for(int i=1; i <= 3; i++)
	{
		WebElement link = it.next();
		test.log(Status.PASS, MarkupHelper.createLabel(link.getText() ,ExtentColor.GREEN));
		
		link.click(); // new tab
		Thread.sleep(4000);
		
		Set <String> tabs = driver.getWindowHandles();
		Iterator <String> ii = tabs.iterator();
		String maintab = ii.next();
		String producttab = ii.next();
		
		driver.switchTo().window(producttab);
		//addtokart.click();
		     // or
		Actions a = new Actions(driver);
		a.moveToElement(addtokart).click().build().perform();
		
		test.log(Status.PASS, MarkupHelper.createLabel("Added to Kart" ,ExtentColor.GREEN));
		
		driver.close(); // close current product tab
		
		driver.switchTo().window(maintab);
		
	}
  }
}
