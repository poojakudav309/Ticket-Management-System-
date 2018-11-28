package test;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SignUp {
	

	 WebDriver driver;
		@Before
		public void openAddTicketPage() throws InterruptedException{
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/ooad/login.jsp");
			Thread.sleep(1000);
			Assert.assertEquals("Login Page", driver.getTitle());
			driver.findElement(By.linkText("registration")).click();
			
			//Thread.sleep(1000);
			Assert.assertEquals("Register", driver.getTitle());
			
		}
		@Test
		public void testRegisterationSuccess() throws InterruptedException{				 
			driver.findElement(By.name("username")).sendKeys("abcd");
			driver.findElement(By.name("first_name")).sendKeys("ab");
			driver.findElement(By.name("last_name")).sendKeys("ab");
			driver.findElement(By.name("email")).sendKeys("ab@g.com");
			driver.findElement(By.name("phone")).sendKeys("1234579");
			driver.findElement(By.name("team")).sendKeys("ab");
			driver.findElement(By.name("role")).sendKeys("ab");
			driver.findElement(By.name("gender")).sendKeys("m");
			driver.findElement(By.name("password")).sendKeys("ab");
			driver.findElement(By.name("retry-password")).sendKeys("ab");
			driver.findElement(By.id("submit")).click();
			Thread.sleep(5000);
			String searchBox = driver.findElement(By.id("result")).getText();
			Thread.sleep(5000);
			Assert.assertEquals("Registration done, please login!", searchBox);
			 	        
		}
		
		@Test
		public void testRegistrationAlternate() throws InterruptedException{
			driver.findElement(By.name("username")).sendKeys("");
			driver.findElement(By.name("first_name")).sendKeys("ab");
			driver.findElement(By.name("last_name")).sendKeys("ab");
			driver.findElement(By.name("email")).sendKeys("");
			driver.findElement(By.name("phone")).sendKeys("1234579");
			driver.findElement(By.name("team")).sendKeys("");
			driver.findElement(By.name("role")).sendKeys("");
			driver.findElement(By.name("gender")).sendKeys("");
			driver.findElement(By.name("password")).sendKeys("");
			driver.findElement(By.name("retry-password")).sendKeys("");
			driver.findElement(By.id("submit")).click();
			Thread.sleep(5000);
			String searchBox = driver.findElement(By.id("msg")).getText();
				Thread.sleep(5000);
				Assert.assertEquals("Error", searchBox);
		}
		
		@After
		public void closePage(){
			driver.quit();
		}


}