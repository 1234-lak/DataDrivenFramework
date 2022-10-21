package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonfunctions.EmpPage;
import commonfunctions.LoginPage;
import commonfunctions.LogoutPage;
import utilities.ExcelFileUtil;

public class DriverScriptPOM {
	WebDriver driver;
	String inputpath ="E:\\9ClockTestNG\\DDT_Framework\\TestInput\\Employee.xlsx";
	String outputpath="E:\\9ClockTestNG\\DDT_Framework\\TestOutput\\EmpResults.xlsx";
	@BeforeTest
	public void adminLogin() throws Throwable
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		Thread.sleep(2000);
		//call login
		LoginPage login =PageFactory.initElements(driver, LoginPage.class);
		login.verifyLogin("Admin", "Qedge123!@#");
	}
	@Test
	public void startTest() throws Throwable
	{
		//create object for excelfile util class
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc =xl.rowcount("EmpData");
		Reporter.log("No of rows::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			String FirstName=xl.getCellData("EmpData", i, 0);
			String MiddleName =xl.getCellData("EmpData", i, 1);
			String LastName =xl.getCellData("EmpData", i, 2);
			EmpPage emp= PageFactory.initElements(driver, EmpPage.class);
			boolean res =emp.verifyEmp(FirstName, MiddleName, LastName);
			if(res)
			{
				xl.setCellData("EmpData", i, 3, "Pass", outputpath);
			}
			else
			{
				xl.setCellData("EmpData", i, 3, "Fail", outputpath);
			}
		}
	}
	@AfterTest
	public void tearDown() throws Throwable
	{
		LogoutPage logout =PageFactory.initElements(driver, LogoutPage.class);
		logout.verifyLogout();
		driver.close();
	}
	}

