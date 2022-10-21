package driverfactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonfunctions.FunctionLibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtil {
String inputpath="E:\\9ClockTestNG\\DDT_Framework\\TestInput\\TestInput.xlsx";
String outputpath="E:\\9ClockTestNG\\DDT_Framework\\TestOutput\\Datadrivenresults.xlsx";
@Test
public void startTest()throws Throwable
{
	//create object for excel file util class
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	//count no of rows in sheet
	int rc =xl.rowcount("Login");
	//count no of cells in row
	int cc =xl.cellCount("Login");
	Reporter.log(rc+"     "+cc,true);
	for(int i=1;i<=rc;i++)
	{
		//read username and password cells
		String user =xl.getCellData("Login", i, 0);
		String pass =xl.getCellData("Login", i, 1);
		//call login method
		boolean res =FunctionLibrary.verifyLogin(user, pass);
		if(res)
		{
			//if res is true write login success into results cell
			xl.setCellData("Login", i, 2, "Login success", outputpath);
			xl.setCellData("Login", i, 3, "Pass", outputpath);
		}
		else{
			//take screen shot and store
			File screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen, new File("./Screenshot/Iteration/"+i+" "+"Loginpage.png"));
			//if res is flase write login fail into results cell
			xl.setCellData("Login", i, 2, "Login Fail", outputpath);
			xl.setCellData("Login", i, 3, "Fail", outputpath);
		}
}
}
}
