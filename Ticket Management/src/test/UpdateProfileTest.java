package test;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateProfileTest {

	WebDriver driver;
	@Before
	public void openProfilePage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/Ticket_Management/login.jsp");
		Thread.sleep(1000);
		Assert.assertEquals("Login Page", driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("eddard");
		driver.findElement(By.id("password")).sendKeys("eddard");
		driver.findElement(By.id("submit-login")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Profile")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Update Profile")).click();
		Thread.sleep(1000);
		Assert.assertEquals("Update Profile", driver.getTitle());
		
	}
	@Test
	public void testUpdateProfileSuccess() throws InterruptedException{	
		driver.findElement(By.id("last_name")).clear();
 	    driver.findElement(By.id("last_name")).sendKeys("test");
        Thread.sleep(5000);
        driver.findElement(By.id("submit-profile")).click();
        Assert.assertEquals("Profile", driver.getTitle());
        Thread.sleep(5000);
        Assert.assertEquals("test", driver.findElement(By.cssSelector("p")).getText());
	}
	
	@After
	public void closePage(){
		driver.quit();
	}
}
