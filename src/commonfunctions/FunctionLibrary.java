package commonfunctions;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLibrary extends AppUtil{
	public static boolean verifyLogin(String Username,String password)throws Throwable
	{
		driver.get(conprop.getProperty("Url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath(conprop.getProperty("objuser"))).sendKeys(Username);
		driver.findElement(By.xpath(conprop.getProperty("objpass"))).sendKeys(password);
		driver.findElement(By.xpath(conprop.getProperty("objlogin"))).click();
		String expected="dashboard";
		String actual =driver.getCurrentUrl();
		if(actual.contains(expected))
		{
			Reporter.log("Login success::"+expected+"    "+actual,true);
			return true;
		}
		else
		{
			String erromessage =driver.findElement(By.xpath(conprop.getProperty("objerrormessage"))).getText();
			Reporter.log(erromessage+"    "+expected+"      "+actual,true);
			return false;
	}
	 
	
	
	
	
	
	
	
	
}
}
