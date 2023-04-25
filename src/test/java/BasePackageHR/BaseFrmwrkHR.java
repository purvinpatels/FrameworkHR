package BasePackageHR;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;


public class BaseFrmwrkHR {

		//browser info   WebDriver driver =new FirefoxDriver();
	    //URL info
	    //Username and password

	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	//Step 1 
	public BaseFrmwrkHR() {
		
		try {
		FileInputStream file=new FileInputStream("D:\\FrameworkHR\\src\\test\\java\\enviornmentvariables\\Config.properties");
		prop.load(file);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException a) {
			a.printStackTrace();
		}
	}
		//Step 2
		
		public static void initiation() {
			String browsername=prop.getProperty("browser");
			if (browsername.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				
				driver=new FirefoxDriver();}
				else if (browsername.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "chrome.exe");
				driver=new ChromeDriver();
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
				driver.get(prop.getProperty("url"));
		}
		
		
		
		
		
		
	}
