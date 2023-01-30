package neostox_loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import neostox_baseclass.neostox_baseclass;

public class neostox_loginpage extends neostox_baseclass
{
	
	public neostox_loginpage (){
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath = "//input[@type=\"number\"][1]") 
	public WebElement input; 

	@FindBy(id = "lnk_signup1")
	public WebElement signup;
	
	@FindBy(className ="form-control")
	public WebElement pass;
	
	@FindBy(xpath="//a[text()='Submit']")
	public WebElement submit;
	
	public void text(String phone) {
		input.sendKeys(phone);
	}
	public void click() {
		signup.click();
	}
	
	public void password(String password) {
		pass.sendKeys(password);
	}
	public void submit() {
		submit.click();
	}
}
