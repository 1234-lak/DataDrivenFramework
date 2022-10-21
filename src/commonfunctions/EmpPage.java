package commonfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class EmpPage {
	
		WebDriver driver;
		public EmpPage(WebDriver driver)
		{
			this.driver=driver;
		}
		//find locator vaules
		@FindBy(xpath = "//b[normalize-space()='PIM']")
		WebElement clickpim;
		@FindBy(xpath = "//input[@id='btnAdd']")
		WebElement clickadd;
		@FindBy (xpath = "//input[@id='firstName']")
		WebElement EnterFname;
		@FindBy (xpath = "//input[@id='middleName']")
		WebElement EnterMname;
		@FindBy (xpath = "//input[@id='lastName']")
		WebElement EnterLname;
		@FindBy (xpath = "//input[@id='employeeId']")
		WebElement BeforeEid;
		@FindBy (xpath = "//input[@id='btnSave']")
		WebElement clickSave;
		@FindBy (xpath = "//input[@id='personal_txtEmployeeId']")
		WebElement Afterid;
		public boolean verifyEmp(String Fname,String Mname,String Lname)throws Throwable
		{
			Actions ac=new Actions(driver);
			ac.moveToElement(clickpim).click().perform();
			Thread.sleep(2000);
			ac.moveToElement(clickadd).click().perform();
			Thread.sleep(2000);
			this.EnterFname.sendKeys(Fname);
			this.EnterMname.sendKeys(Mname);
			this.EnterLname.sendKeys(Lname);
			String expectedid=this.BeforeEid.getAttribute("value");
			ac.moveToElement(clickSave).click().perform();
			String actualid=this.Afterid.getAttribute("value");
			if (expectedid.equals(actualid)) {
				Reporter.log("Employee creation success::"+expectedid+"    "+actualid,true);
				return true;
				
			}else {
				Reporter.log("Employee creation not success::"+expectedid+"    "+actualid,true);
			}
			
			return false;
			
		}
		
		
		
}
