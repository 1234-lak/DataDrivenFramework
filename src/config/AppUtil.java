package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
public static WebDriver driver;
public static Properties conprop;
@BeforeTest
public static void setup() throws Throwable 
{conprop=new Properties();
//load property file
conprop.load(new FileInputStream("E:\\9ClockTestNG\\DDT_Framework\\PropertyFiles\\Environment.properties"));
if (conprop.getProperty("Browser").equalsIgnoreCase("chrome")) {
	driver=new ChromeDriver();
}
else if (conprop.getProperty("Browser").equalsIgnoreCase("firefox")) {
	driver=new FirefoxDriver();
}
else {
	System.out.println("Browser value is not matching");
}
}	

@AfterTest
public static void tearDown()
{
	driver.close();
}
}
 
