package neostox_Testclass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import neostox_baseclass.neostox_baseclass;
import neostox_loginpage.neostox_PopupPage;
import neostox_loginpage.neostox_loginpage;
import neostox_utilitycalss.XLUtis;

public class LOgin_data_driven_testcase extends neostox_baseclass {

	@Test(dataProvider = "logindata")
	public void LoginData(String user, String Pwd, String Expected) throws InterruptedException {

		logger.info("openurl");
		neostox_loginpage lp = new neostox_loginpage();

		lp.text(user);
		logger.info("text filled by phone number");

		lp.click();
		logger.info("signuped");

		Thread.sleep(3000);

		lp.password(Pwd);
		logger.info("password passed in text");

		lp.submit();
		logger.info("clicked on submit");

		neostox_PopupPage pp = new neostox_PopupPage();
		Actions act = new Actions(driver);

		pp.ok();
		logger.info("clicked on popup");
		
		Thread.sleep(3000);

		WebElement nametext1 = driver.findElement(By.id("lbl_username"));
		act.moveToElement(nametext1).perform();
		logger.info("moved to ravi");


		String Actual_Result = driver.getTitle();
		String Expected_Result = "NIFTY 50 ​ ​ 17911.60 ​ ​ ​ ▼ 206.70";

		if (Expected.equals("valid")) {

			if (Actual_Result.equals(Expected_Result)) {

				WebElement logout = driver.findElement(By.xpath("//span[text()='Logout']"));
				logout.click();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		} 
		else if (Expected.equals("invalid")) {

			if (Expected_Result.equals(Actual_Result)) {
				WebElement logout = driver.findElement(By.xpath("//span[text()='Logout']"));
				logout.click();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}

		}

	}

	@DataProvider(name = "logindata")
	public String[][] getdata() throws IOException {

		String path = "C:\\Users\\om sai\\eclipse-workspace\\zravipracticeproject\\src\\main\\java\\neostox_Test_data\\Neostox.xlsx";

		int rownum = XLUtis.getRowCount(path, "Ravi");
		int colcount = XLUtis.getCellCount(path, "Ravi", 1);
		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < colcount; j++) { // 10 11 21

				logindata[i - 1][j] = XLUtis.getCellData(path, "Ravi", i, j);
			}
		}
		return logindata;

	}
}
