package stepdefinitionsignin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Payments {
	WebDriver driver;
	
	@Given("User must be an existing customer with email and password and signed in url {string} and navigate to Your Payments page")
	public void user_must_be_an_existing_customer_with_email_and_password_and_signed_in_url_and_navigate_to_your_payments_page(String string) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		  
		  ChromeOptions op=new ChromeOptions();
		  op.addArguments("--remote-allow-origins=*"); driver=new ChromeDriver();
		  driver.get(string); driver.manage().window().maximize();
		  
		  Actions action=new Actions(driver);
		  action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build
		  ().perform(); 
		  driver.findElement(By.id("nav-link-accountList")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("ap_email")).sendKeys("dmanish5@yahoo.com");
		  Thread.sleep(2000); 
		  driver.findElement(By.id("continue")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Atlantis21!"); 
		  Thread.sleep(2000);
		  driver.findElement(By.id("auth-signin-button")).click(); 
		  Thread.sleep(2000);
		  action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build
		  ().perform(); 
		  driver.findElement(By.cssSelector("#nav-al-your-account > a:nth-child(2) > span")).click(); 
		  }
		  
	

			
			  @When("Click on Your Payments option should navigate to payments option page to add payments"
			  ) public void
			  click_on_your_payments_option_should_navigate_to_payments_option_page_to_add_payments
			  () throws InterruptedException { Thread.sleep(2000); driver.findElement(By.
			  cssSelector("#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(2) > a > div > div > div > div.a-column.a-span9.a-span-last > div > span"
			  )).click(); Thread.sleep(3000);
			  driver.findElement(By.id("pp-tD1oyn-9")).click();
			  Thread.sleep(2000); }
			 
	@When("Click on add a credit or debit card button")
	public void click_on_add_a_credit_or_debit_card_button() throws InterruptedException {
		driver.findElement(By.id("pp-4TaW3i-35-announce")).click(); 
		Thread.sleep(3000);
	}

	@When("Add Card number and Name on card,select expiry date and click on add you card")
	public void add_card_number_and_name_on_card_select_expiry_date_and_click_on_add_you_card() throws InterruptedException {
		
		 Alert a=driver.switchTo().alert(); 
		
		 
		driver.findElement(By.cssSelector("#pp-QPI1St-16")).sendKeys("5555555555554444");
		 a.accept();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#pp-QPI1St-18")).sendKeys("Manish"); 
		Thread.sleep(3000);
		
		Select month =new Select (driver.findElement(By.id("pp-FrFd53-19")));
		month.selectByValue("5");
		Thread.sleep(3000);
		Select year =new Select (driver.findElement(By.id("pp-FrFd53-21")));
		year.selectByValue("2024");
		
		driver.findElement(By.id("pp-QPI1St-26")).click(); 
		
	}

	@Then("Payment added")
	public void payment_added() {
	  
	}

}
