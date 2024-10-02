package TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	public Properties pr;
	@Parameters({"os","browser"})
	@BeforeClass
	public void setUp(@Optional("windows")String os,@Optional("chrome")String br) throws IOException {
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		pr=new Properties();
		pr.load(file);
		switch(br.toLowerCase()) {
		case "chrome" :driver=new ChromeDriver();break;
		case "edge" :driver=new EdgeDriver();break;
		default: System.out.println("Invalid Browser name.."); return; 
		}
	    
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get(pr.getProperty("appUrl"));
	    driver.manage().window().maximize();
	    logger=LogManager.getLogger(this.getClass());
	    
	}
	public String captureScreen(String tname) throws IOException{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot =(TakesScreenshot)driver;
		File sourcefile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetfile=new File(targetFilePath);
		
		sourcefile.renameTo(targetfile);
		return targetFilePath;
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e){
			e.getMessage();
			return false;
		}
	}
	
	public String randomeString(){
		String generatedString =RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber(){
		String generatedNumber =RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomeAlphaNumber(){
		//String generatedAlphaNumber =RandomStringUtils.randomAlphanumeric(10);
		String generatedString =RandomStringUtils.randomAlphabetic(3);
		String generatedNumber =RandomStringUtils.randomNumeric(3);
		return (generatedString+"@"+generatedNumber);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
