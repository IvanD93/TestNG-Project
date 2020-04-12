package Domaci;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;


public class CheckTitle {
	
	static WebDriver driver;
	
	
	
	@Test
	public void CheckTitle() {
		driver.get("https://www.guru99.com/");
		String title = driver.getTitle();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(title, "Guru99");
	}	
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marijana\\Vezbe-QA\\TestNGProjekat\\src\\Domaci\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
}
