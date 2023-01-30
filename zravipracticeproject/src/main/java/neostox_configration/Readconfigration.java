package neostox_configration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfigration {
	

		Properties pro;

		public Readconfigration() {

			File src = new File(
					"C:\\Users\\om sai\\eclipse-workspace\\zravipracticeproject\\src\\main\\java\\neostox_configration\\confi.properties");

			FileInputStream fis;

			try {
				fis = new FileInputStream(src);
				pro = new Properties();
				try {
					pro.load(fis);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {

				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		public String getApplicationURL() {		
			String url =pro.getProperty("baseURL");
			return url;
		}
		
		public String getUsername() {		
			String username =pro.getProperty("username");
			return username;
		}
		public String getPassword() {		
			String password =pro.getProperty("password");
			return password;
		}
		public String getChromepath() {		
			String chromepath =pro.getProperty("chromepath");
			return chromepath;
		}
		public String getedgepath() {		
			String edgepath =pro.getProperty("edgepath");
			return edgepath;
	}
}


