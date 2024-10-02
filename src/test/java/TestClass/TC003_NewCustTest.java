package TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AddNewCustomerPage;
import PageObject.Login;
import TestBase.BaseClass;

public class TC003_NewCustTest extends BaseClass{
	@Test
	public void createNewCustTest() {
			
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
			AddNewCustomerPage objANC= new AddNewCustomerPage(driver);
			objANC.clickNewCustomer();
			objANC.setNewCustomerName(randomeString());
			objANC.setGender("m");
			objANC.setDOB("02", "01", "2001");
			objANC.setAddress("flat No 4,Mh40");
			objANC.setCity("pune");
			objANC.setState("Mh");
			objANC.setPinCode("444567");
			objANC.setPhoneNo(randomeNumber());
			objANC.setEmail(randomeString()+randomeNumber()+"@gmail.com");
			objANC.setPass(randomeAlphaNumber());
			objANC.clickSubmit();
			
			if(objLG.titleAccPage.getText().equals("Welcome To Manager's Page of Guru99 Bank")) {
				Assert.assertTrue(true);
				logger.info("createNewCustTest test passed");
			}
			else {
				Assert.assertTrue(false);
				logger.info("createNewCustTest test failed");
			}
		} 
}
