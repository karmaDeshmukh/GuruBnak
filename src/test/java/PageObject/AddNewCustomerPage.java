package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	WebDriver driver;

	public AddNewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement btnNewCustomer;
	
	@FindBy(xpath="//input[@name='name' and @onblur='validatecustomername();' ]")
	WebElement txtCustomerName;
	
	@FindBy(xpath="//input[@type='radio' and @value='m']")
	WebElement btnMale;
	
	@FindBy(xpath="//input[@type='radio' and @value='f']")
	WebElement btnFemale;
	
	@FindBy(xpath="//input[@type='date' and @id='dob']")
	WebElement txtDoB;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement txtAddress;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement txtCity;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement txtState;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement txtPin;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement txtPhoneNo;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement txtEmailid;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement btnSubmit;
	
	
	
	
	public void clickNewCustomer() {
		btnNewCustomer.click();
	}
	
	public void setNewCustomerName(String nm) {
		txtCustomerName.sendKeys(nm);
	}
	
	public void setGender(String gen) {
		if(gen.equalsIgnoreCase("m")) {
			btnMale.click();
		}else if(gen.equalsIgnoreCase("f")) {
			btnFemale.click();
		}
	}
	
	public void setDOB(String dd,String mm,String yyyy) {
		txtDoB.sendKeys(dd);
		txtDoB.sendKeys(mm);
		txtDoB.sendKeys(yyyy);
	}
	
	public void setAddress(String adr) {
		txtAddress.sendKeys(adr);
	}
	
	public void setCity(String cty) {
		txtCity.sendKeys(cty);
	}
	
	public void setState(String sts) {
		txtState.sendKeys(sts);
	}
	
	public void setPinCode(String pc) {
		txtPin.sendKeys(pc);
	}
	
	public void setPhoneNo(String num) {
		txtPhoneNo.sendKeys(num);
	}
	
	public void setEmail(String eid) {
		txtEmailid.sendKeys(eid);
	}
	
	public void setPass(String ps) {
		txtPassword.sendKeys(ps);
	}
	
	public void clickSubmit() {
		btnSubmit.click();;
	}
	
	

	
}
