package test;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class AddTicketTest {
	

		 WebDriver driver;
			@Before
			public void openAddTicketPage() throws InterruptedException{
				System.setProperty("webdriver.chrome.driver","chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("http://localhost:8080/Ticket_Management/login.jsp");
				Thread.sleep(1000);
				Assert.assertEquals("Login Page", driver.getTitle());
				driver.findElement(By.id("username")).sendKeys("robb");
				driver.findElement(By.id("password")).sendKeys("robb");
				driver.findElement(By.id("submit-login")).click();
				Thread.sleep(1000);
				driver.findElement(By.linkText("Raise Ticket")).click();
				Thread.sleep(1000);
				Assert.assertEquals("add ticket", driver.getTitle());
				
			}
			@Test
			public void testaddTicketSuccess() throws InterruptedException{				 
				 	    //driver.findElement(By.id("to")).sendKeys("2");
				 	    driver.findElement(By.id("description")).sendKeys("testing ticket");
						Select dropdown1 = new Select(driver.findElement(By.id("category1")));
						dropdown1.selectByValue("it");
						Select dropdown2 = new Select(driver.findElement(By.id("category2")));
						dropdown2.selectByValue("software");
						Select dropdown3 = new Select(driver.findElement(By.id("category3")));
						dropdown3.selectByValue("packages");
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
				driver.findElement(By.id("description")).sendKeys("");
				Select dropdown1 = new Select(driver.findElement(By.id("category1")));
				dropdown1.selectByValue("it");
				Select dropdown2 = new Select(driver.findElement(By.id("category2")));
				dropdown2.selectByValue("software");
//				Select dropdown3 = new Select(driver.findElement(By.id("category2")));
//				dropdown3.selectByValue("software");
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
