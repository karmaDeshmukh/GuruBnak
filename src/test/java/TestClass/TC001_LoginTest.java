package TestClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.Login;
import TestBase.BaseClass;

public class TC001_LoginTest extends BaseClass{
	
	@Test
	public void loginTest() {
		
		Login objLG = new Login(driver);
		logger.info("****** LoginTest Starts ******");
		objLG.setUserId(pr.getProperty("UserId"));
		logger.info("Entered User id");
		objLG.setpassward(pr.getProperty("Password"));
		logger.info("Entered Password");
		objLG.clickLogin();
		logger.info("Checking for Acc");
		
		if(objLG.titleAccPage.getText().equals("Welcome To Manager's Page of Guru99 Bank")) {
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else {
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
		
		
		
		
	}
	
}
