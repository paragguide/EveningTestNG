package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.Page;

public class ScreenShot extends Page
{
	
	public static void takeScreenShot(String srcname) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File tmplocation = ts.getScreenshotAs(OutputType.FILE); //take screenshot and store in tmp location
	
		String path = System.getProperty("user.dir")+"//src//test//java//screenshot//"+srcname+".jpg";
	
		FileUtils.copyFile(tmplocation, new File(path)); // copy file to specific location path
	}

}
