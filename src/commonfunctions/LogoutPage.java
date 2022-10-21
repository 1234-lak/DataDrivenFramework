package commonfunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	
		@FindBy(xpath = "//a[@id='welcome']")
		WebElement welcome;
		@FindBy(xpath = "//a[contains(text(),'Logout')]")
		WebElement logout;
		public void verifyLogout()throws Throwable
		{
			welcome.click();
			Thread.sleep(2000);
			logout.click();
	}
}
