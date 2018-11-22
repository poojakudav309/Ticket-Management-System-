package test;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AddTicketTest {
	

		 WebDriver driver;
			@Before
			public void openAddTicketPage() throws InterruptedException{
				System.setProperty("webdriver.chrome.driver","chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("http://localhost:8080/ooad/login.jsp");
				Thread.sleep(1000);
				Assert.assertEquals("Login Page", driver.getTitle());
				driver.findElement(By.id("username")).sendKeys("asa");
				driver.findElement(By.id("password")).sendKeys("asas");
				driver.findElement(By.id("submit-login")).click();
				Thread.sleep(1000);
				driver.findElement(By.linkText("Raise Ticket")).click();
				Thread.sleep(1000);
				Assert.assertEquals("add ticket", driver.getTitle());
				
			}
			@Test
			public void testaddTicketSuccess() throws InterruptedException{				 
				 	    driver.findElement(By.id("to")).sendKeys("2");
				 	    driver.findElement(By.id("description")).sendKeys("testing ticket");
				 	    driver.findElement(By.id("type")).sendKeys("t12");
			 	        driver.findElement(By.id("priority")).sendKeys("1");
			 	        Thread.sleep(5000);
			 	        driver.findElement(By.id("submit-ticket")).click();
			 	        Assert.assertEquals("add ticket", driver.getTitle());
				        String searchBox = driver.findElement(By.id("final_result")).getText();
						Thread.sleep(5000);
						Assert.assertEquals("Successful", searchBox);
				 	        
			}
			
			@Test
			public void testaddTicketAlternate() throws InterruptedException{
				    driver.findElement(By.id("to")).sendKeys("2");		 
		 	        driver.findElement(By.id("description")).sendKeys("");	 
		 	        driver.findElement(By.id("type")).sendKeys("");	 	        
		 	        driver.findElement(By.id("priority")).sendKeys("");	 	       
		 	        Thread.sleep(5000); 	        
		 	        driver.findElement(By.id("submit-ticket")).click();
		 	        Assert.assertEquals("add ticket", driver.getTitle());
		 	        String searchBox = driver.findElement(By.id("final_result")).getText();
					Thread.sleep(5000);
					Assert.assertEquals("Error", searchBox);
			}
			
			@After
			public void closePage(){
				driver.quit();
			}


}
