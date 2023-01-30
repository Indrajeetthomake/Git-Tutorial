package neostox_Testclass;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import neostox_baseclass.neostox_baseclass;
import neostox_loginpage.neostox_loginpage;

public class neostox_Login_Testcase extends neostox_baseclass {
	@Test
	public void testcase() throws InterruptedException, IOException {

		logger.info("open neo URL");
		neostox_loginpage nl = new neostox_loginpage();

		nl.text(username);
		logger.info("enter user phonenumber");

		nl.click();
		logger.info("clicked on signup");

		Thread.sleep(3000);
		nl.password(password);
		logger.info("enter the password");

		nl.submit();
		logger.info("clicked on submit ");

		if (driver.getTitle().equals("Enter Access Pin - Neostox")) {
			Assert.assertTrue(true);
			logger.info("login sucess");
		}
	     else {
			getscreenshotas("Logintestcase");
			Assert.assertTrue(false);
			logger.info("login failed");
		}

	}

}
