package test;
import java.util.List;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class postCommentTest {

	 WebDriver driver;
	 @Before
		public void openCommentsPage() throws InterruptedException{
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/Ticket_Management/login.jsp");
			Thread.sleep(1000);
			Assert.assertEquals("Login Page", driver.getTitle());
			driver.findElement(By.id("username")).sendKeys("eddard");
			driver.findElement(By.id("password")).sendKeys("eddard");
			driver.findElement(By.id("submit-login")).click();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Dashbord")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("57")).click();
			Thread.sleep(1000);
			Assert.assertEquals("Comments", driver.getTitle());
			Thread.sleep(5000);
		}
		@Test
		public void testaddTicketSuccess() throws InterruptedException{				 
			driver.findElement(By.id("post1")).sendKeys("Kindly update my email id jon@gmail.com");
			Thread.sleep(5000);
			
			driver.findElement(By.id("btn1")).click();
			   Thread.sleep(5000);
			   Assert.assertEquals("Comments", driver.getTitle());
			   Thread.sleep(1000);
			   List<WebElement>  listele = driver.findElements(By.id("p1"));
			   int count=0;
			   String post="";
			   for(WebElement e :listele) 
			   	{        
				  System.out.println(e.getText());
			        if(count==listele.size()-1){
			        	 post=e.getText();
			        }
			        count++;
			    }
			  	Assert.assertEquals("Comments", driver.getTitle());
			Thread.sleep(5000);
			Assert.assertEquals("Kindly update my email id jon@gmail.com", post);
			 	        
		}
		
		
		
		@After
		public void closePage(){
			driver.quit();
		}
}
