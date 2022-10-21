package commonfunctions;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
//define locators
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement objUser;
	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement objPass;
	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement objLogin;
	public void verifyLogin(String username,String password)
	{
		objUser.sendKeys(username);
		objPass.sendKeys(password);
		objLogin.click();
	}
}
