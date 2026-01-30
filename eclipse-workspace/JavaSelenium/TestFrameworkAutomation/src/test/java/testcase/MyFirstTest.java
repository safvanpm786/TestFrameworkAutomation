package testcase;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;


public class MyFirstTest extends BaseTest{
	
	@Test(dataProvider="testdata")
	public static void LoginTest(String username,String password) throws InterruptedException {
	driver.manage().window().maximize();
	driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();

	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
	driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
	driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys(password);
	driver.findElement(By.id(loc.getProperty("login_nextbutton"))).click();
	driver.findElement(By.xpath(loc.getProperty("click_logout"))).click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("signout_link")))).click();

	
	
	}


@DataProvider(name="testdata")
public Object[][] tdata(){
	return new Object[][] {
		
		{"safvan.pmohamed@gmail.com","Podapatty@586"},
		{"safvan.pmohamed@gmail.com","Podapatty@586"},
		{"safvan.pmohamed@gmail.com","Podapatty@586"}
	};
}
}
