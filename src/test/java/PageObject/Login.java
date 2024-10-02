package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {

	WebDriver driver;
	 
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	 @FindBy(xpath="//input[@name='uid' and @type='text']")
	 WebElement txtUserId;
	 
	 @FindBy(xpath="//input[@name='password' and @type='password']")
	 WebElement txtPassword;
	 
	 @FindBy(xpath="//input[@name='btnLogin' and @type='submit']")
	 WebElement btnLogin;
	 
	 @FindBy(xpath="//marquee[@class='heading3' and @behavior='alternate']")
	public  WebElement titleAccPage;
	 
	 @FindBy(xpath="//a[text()='Log out']")
	 WebElement btnlogout;
	 
	 public void setUserId(String userid) {
		 txtUserId.sendKeys(userid);
	 }
	 
	 public void setpassward(String pass) {
		 txtPassword.sendKeys(pass);
	 }
	 
	 public void clickLogin() {
		 btnLogin.click();
	 }
	 
	 public void CheckingLogin() {
		 if(titleAccPage.getText().equals("Welcome To Manager's Page of Guru99 Bank")) {
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
	 }
	 public void clickLogout() {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.PAGE_DOWN).perform();
			btnlogout.click();
		}
	 
}
