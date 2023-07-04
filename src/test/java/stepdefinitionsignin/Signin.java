package stepdefinitionsignin;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Signin  {
	WebDriver driver;
	
	
	@Given("User must be an existing customer and on the Sign in page by clicking url {string}")
	public void user_must_be_an_existing_customer_and_on_the_sign_in_page_by_clicking_url1(String string) throws InterruptedException, SessionNotCreatedException{
System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver();
		driver.get(string);
		
		
	}

	
	@When("Enter valid email")
	public void enter_valid_email() throws InterruptedException {
		driver.findElement(By.id("ap_email")).sendKeys("dmanish5@yahoo.com");
		Thread.sleep(5000);
	    
	}

	@When("Click on continue button should navigate to the Password field")
	public void click_on_continue_button_should_navigate_to_the_password_field() throws InterruptedException {
		 driver.findElement(By.id("continue")).click();
		    Thread.sleep(3000);
	}
	

	
	  @When("Enter valid password") 
	  public void enter_valid_password() throws InterruptedException { 
			
		  try {
			  
		  driver.findElement(By.cssSelector("#ap_password")).sendKeys("Atlantis21!");
		  Thread.sleep(3000);
		  }
		  catch(InterruptedException e){
			  e.printStackTrace();
		  }
			
		  }
	  

	@When("Clicking on Keep me signed in checkbox")
	public void clicking_on_keep_me_signed_in_checkbox() throws InterruptedException {
		driver.findElement(By.cssSelector("#authportal-main-section > div:nth-child(2) > div > div > div > form > div > div:nth-child(7) > div > div > label > div > label > input[type=checkbox]")).click();
	    Thread.sleep(3000);
	}

	@Then("Click on Sign in button the customer should be able to sign in without any further prompts on the particular device")
	public void click_on_sign_in_button_the_customer_should_be_able_to_sign_in_without_any_further_prompts_on_the_particular_device() throws InterruptedException {
		driver.findElement(By.id("auth-signin-button")).click();
	    Thread.sleep(3000);
	    driver.quit();
	    String actualresult =driver.getCurrentUrl();
		   Assert.assertEquals("https://www.amazon.ca/?ref_=nav_signin&captcha_verified=1", actualresult);
		  
	    
	}
	
	//Test2
	
	@Given("User must be a customer and on the Sign in page by clicking url2 {string}")
	public void user_must_be_a_customer_and_on_the_sign_in_page_by_clicking_url2(String string)
{
	  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	  
	  ChromeOptions op=new ChromeOptions();
	  op.addArguments("--remote-allow-origins=*"); driver=new ChromeDriver();
	  driver.get(string); 
	  }
	  
	  

	  @When("Enter blank email and click on continue button")
	  public void enter_blank_and_click_on_continue_button() throws InterruptedException {
		  driver.findElement(By.id("continue")).click();
		  
		     
	  }
	  
	  @When("Enter invalid email and click on continue button")
	  public void enter_invalid_email_and_click_on_continue_button() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.findElement(By.id("ap_email")).sendKeys("dmanish5@"); 
		    Thread.sleep(3000);
		  driver.findElement(By.id("continue")).click();
		  Thread.sleep(2000);
		 
		 
	  }
	  
	  @Then("Appropriate error message must be displayed")
	  public void appropriate_error_message_must_be_displayed() {
	  System.out.println("Display error message"); 
	  String actualresult =driver.getCurrentUrl();
	   Assert.assertEquals("https://www.amazon.ca/ap/signin", actualresult);
	 
	   } 
	 
	
//Test 3

  @Given("User must be  an existing customer and on the Sign in page by clicking url3{string}"
  ) public void user_must_be_an_existing_customer_and_on_the_sign_in_page_by_clicking_url3(
  String string) {
  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
  
  ChromeOptions op=new ChromeOptions();
  op.addArguments("--remote-allow-origins=*"); driver=new ChromeDriver();
  driver.get(string);  }
  
  
  @When("Enter valid email and click on continue button should navigate to the Password field1")
  public void enter_valid_email_and_click_on_continue_button_should_navigate_to_the_password_field1() throws InterruptedException {
  driver.findElement(By.id("ap_email")).sendKeys("dmanish5@gmail.com"); 
  Thread.sleep(2000);
  driver.findElement(By.id("continue")).click();
  
   }
  
  @When("Enter invalid password and click on signin button1")
  public void enter_invalid_password_and_click_on_signin_button1() throws InterruptedException {
	
	  driver.findElement(By.cssSelector("#ap_password")).sendKeys("manish");
	  Thread.sleep(2000);
	  driver.findElement(By.id("auth-signin-button")).click();
	  
	  driver.navigate().back();
	  
	  driver.findElement(By.id("ap_email")).sendKeys("dmanish5@gmail.com"); 
	  Thread.sleep(2000);
	  driver.findElement(By.id("continue")).click();
	  
	  driver.findElement(By.id("auth-signin-button")).click();
	  Thread.sleep(2000);
    
	  
	  
	  
  }
  
	
  @Then("Error message must be displayed")
  public void Error_message_must_be_displayed() throws
  InterruptedException {
 
  System.out.println("Display error message"); 
  
  String actualresult =driver.getCurrentUrl();
  Assert.assertEquals("https://www.amazon.ca/ap/signin", actualresult);
  driver.close();
  
  }
}
  
  
  




 
		
	
