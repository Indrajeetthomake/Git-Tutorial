package neostox_Testclass;

import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import neostox_baseclass.neostox_baseclass;
import neostox_loginpage.neostox_PopupPage;
import neostox_loginpage.neostox_loginpage;

public class neostox_Testcase_popuphandling extends neostox_baseclass {

	@Test
	public void topup() throws InterruptedException {

		logger.info("openurl");
		neostox_loginpage lp = new neostox_loginpage();

		lp.text(username);
		logger.info("text filled by phone number");

		lp.click();
		logger.info("signuped");

		Thread.sleep(3000);

		lp.password(password);
		logger.info("password passed in text");

		lp.submit();
		logger.info("clicked on submit");

		neostox_PopupPage pp = new neostox_PopupPage();
		Actions act = new Actions(driver);

		
		pp.ok();
		logger.info("clicked on popup");
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);

		WebElement nametext1 = driver.findElement(By.id("lbl_username"));
		act.moveToElement(nametext1).perform();
		logger.info("moved to ravi");

		Thread.sleep(3000);
		pp.topup();
		logger.info("clicked on topup");

		pp.updateAC();
		logger.info("clicked on update accont");

		pp.topupclose();
		logger.info("clicked on cancel");
		
		
		
	

	}
}