package stepdefinitionsignin;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Createaccount {
	WebDriver driver;
	

@Given("User should be on the main page of amazon url {string} and mouse hover on Hello,sign in Accounts & Lists")
public void user_should_be_on_the_main_page_of_amazon_url_and_mouse_hover_on(String string) {
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	
	ChromeOptions op=new ChromeOptions();
	op.addArguments("--remote-allow-origins=*");
	driver=new ChromeDriver();
	driver.get(string);
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();

}

@When("Click on Start here customer should navigate to Create account page of amazon")
public void click_on_start_here_customer_should_navigate_to_create_account_page_of_amazon() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-newCust\"]/a")).click();
	Thread.sleep(2000);
    
}

@When("Enter Yourname,Mobilenumberoremail,Password,Passwordagain")
public void enter_yourname_mobilenumberoremail_password_passwordagain() throws InterruptedException {
	driver.findElement(By.id("ap_customer_name")).sendKeys("manish dave");
	Thread.sleep(3000);
	driver.findElement(By.id("ap_email")).sendKeys("dmanish5@yahoo.com");
	Thread.sleep(3000);
	driver.findElement(By.id("ap_password")).sendKeys("Atlantis21!");
	Thread.sleep(3000);
	driver.findElement(By.id("ap_password_check")).sendKeys("Atlantis21!");
	Thread.sleep(3000);	
    
}

@When("Click on continue button")
public void click_on_continue_button() throws InterruptedException {
	driver.findElement(By.id("continue")).click();
    Thread.sleep(3000);
    
}

@Then("If account already exist, one must get message as Are you returning customer else one must get verification OTP on his\\/her email id after entering OTP, one must create an account")
public void if_account_already_exist_one_must_get_message_as_are_you_returning_customer_else_one_must_get_verification_otp_on_his_her_email_id_after_entering_otp_one_must_create_an_account() {
	String actualresult =driver.getCurrentUrl();
	   Assert.assertEquals("https://www.amazon.ca/ap/register", actualresult);
	   System.out.println("Existing customer will generate OTP");
	   driver.close();
		
}
}






