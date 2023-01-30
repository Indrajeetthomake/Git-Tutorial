package neostox_Testclass;

import org.testng.annotations.Test;

import neostox_baseclass.neostox_baseclass;
import neostox_loginpage.Neostox_verify_Neo_image;
import neostox_loginpage.neostox_PopupPage;
import neostox_loginpage.neostox_loginpage;

public class Neostox_verify_Neo_image_testcase extends neostox_baseclass {
	@Test
	public void Neostox_verify_Neo_image_testcase() throws InterruptedException {
		
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
		
		pp.ok();
		
		Neostox_verify_Neo_image nv=new Neostox_verify_Neo_image();
		nv.Image();
	}

}
