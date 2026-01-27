package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
		public static WebDriver driver;
		public static Properties prop= new Properties();
		public static Properties loc= new Properties();
		public static FileReader fr;
		public static FileReader fr1;
		
		@BeforeTest
		public void setUp() throws IOException {
			
			if(driver==null) {
				System.out.println("The path is:"+ System.getProperty("user.dir"));
				FileReader fr=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
				FileReader fr1=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");

				
				prop.load(fr);
				loc.load(fr1);
			}
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();//base
				driver = new ChromeDriver();
				driver.get(prop.getProperty("testurl"));
				
				}
			else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();//base
			    driver = new FirefoxDriver();
				driver.get("https://www.zoho.com/");//properties
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				driver.get("https://www.zoho.com/");//properties
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("Safari")) {
				WebDriverManager.safaridriver();
				driver = new SafariDriver();
				driver.get("https://www.zoho.com/");//properties
			}
			}
		@AfterTest
		public void tearDown() {
			driver.quit();
			System.out.println("Teardown Successful");
		}
		
	}


