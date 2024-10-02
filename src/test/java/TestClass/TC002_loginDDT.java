package TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.Login;

import TestBase.BaseClass;
import Utilities.DataProviders;

public class TC002_loginDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email,String pwd) {
		Login objLG = new Login(driver);
		logger.info("****** LoginTest Starts ******");
		objLG.setUserId(email);
		logger.info("Entered User id");
		objLG.setpassward((pwd));
		logger.info("Entered Password");
		objLG.clickLogin();
		logger.info("Checking for Acc");
		
//		if(objLG.titleAccPage.getText().equals("Welcome To Manager's Page of Guru99 Bank")) {
//			Assert.assertTrue(true);
//			logger.info("login test passed");
//		}
//		else {
//			Assert.assertTrue(false);
//			logger.info("login test failed");
//		}
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("password provided");
			objLG.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
}
