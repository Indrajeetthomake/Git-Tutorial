package neostox_loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import neostox_baseclass.neostox_baseclass;

public class neostox_PopupPage extends neostox_baseclass {

	public neostox_PopupPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='OK'])[2]")
	public WebElement ok;

	@FindBy(xpath = "//span[text()='Hi Ravi Thomake']")
	public WebElement nametext;

	@FindBy(xpath = "//span[text()='Top Up']")
	public WebElement topup;

	@FindBy(xpath = "//a[text()='Update A/c']")
	public WebElement updateAC;

	@FindBy(id = "lnk_topupclose")
	public WebElement topupclose;

	public void ok() {
		ok.click();
	}

	public void topup() {
		topup.click();
	}

	public void updateAC() {
		updateAC.click();
	}

	public void topupclose() {
		topupclose.click();
	}	
	
}
