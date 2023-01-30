package neostox_baseclass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.print.DocFlavor.STRING;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import neostox_configration.Readconfigration;

public class neostox_baseclass {

	Readconfigration readconfig = new Readconfigration();
	public String BaseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public String chromepath = readconfig.getChromepath();

	public static WebDriver driver;
	public static Logger logger;

	
	@BeforeMethod
	public void initilization() {
		logger=logger.getLogger("30 jully");
		PropertyConfigurator.configure("log4j.properties");
		
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(BaseURL);
	}
	public String getscreenshotas(String Testcasename) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String names="-screenshots-"+timestamp;
		String destination=System.getProperty("user.dir")+"/screenshots/"+Testcasename+""+names+".jpg";
	
         FileUtils.copyFile(source, new File(destination));	
         return destination;
	
	}
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
