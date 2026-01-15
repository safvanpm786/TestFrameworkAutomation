package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;


public class MyFirstTest extends BaseTest{
	
	@Test
	public static void LoginTest() throws InterruptedException {
	driver.manage().window().maximize();
	driver.findElement(By.linkText("Sign In")).click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	driver.findElement(By.id("login_id")).sendKeys("safvan.pmohamed@gmail.com");
	driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
	driver.findElement(By.id("password")).sendKeys("Podapatty@586");
	driver.findElement(By.id("nextbtn")).click();
	driver.findElement(By.xpath("//img[@id='ztb-profile-image-pre']")).click();
	driver.findElement(By.id("ztb-signout")).click();
	
	}

}
