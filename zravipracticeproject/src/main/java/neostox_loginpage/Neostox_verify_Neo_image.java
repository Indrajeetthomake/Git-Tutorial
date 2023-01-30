package neostox_loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import neostox_baseclass.neostox_baseclass;

public class Neostox_verify_Neo_image extends neostox_baseclass{
	
public Neostox_verify_Neo_image() {
	PageFactory.initElements(driver,this);
}
 @FindBy(id = "neostoxlogo")
 public WebElement image;
 
 public void Image() {
   image.isDisplayed();
 }
}
