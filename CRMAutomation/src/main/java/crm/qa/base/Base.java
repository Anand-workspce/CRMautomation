package crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Base {
	public static Properties prop;
	public static WebDriver driver;

	public Base() {

		try {
			prop= new Properties();
			 String path = System.getProperty("user.dir") +"\\src\\main\\java\\crm\\qa\\config\\config.properties";
			FileInputStream	file = new FileInputStream(path);
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



	}
	
	public void initialization() {
		String browserName=prop.getProperty("browser");
		String path=System.getProperty("user.dir");
		System.out.println(path);
		String osName=System.getProperty("os.name");
		
		if(osName.equals("Windows 10")) {
			System.setProperty("webdriver.chrome.driver", "D:\\CRMautomation\\CRMAutomation\\drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.get(prop.getProperty("url"));
		}else {
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



	}
}
