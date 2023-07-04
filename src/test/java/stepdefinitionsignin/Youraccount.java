package stepdefinitionsignin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Youraccount {
	WebDriver driver;
	
	@Given("User must be an existing customer and signed in url {string}")
	public void user_must_be_an_existing_customer_and_signed_in_url(String string) {
System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver();
		driver.get(string);
		
	}
	
	@When("Verify hello message {string}")
	public boolean verify_hello_message(String string) {
	    boolean b=driver.findElement(By.id("nav-link-accountList")).isDisplayed();
	    return b;
	}

	@When("Customer can mouse hover or click {string} with <email> and <password>")
	public void customer_can_mouse_hover_or_click_with_email_and_password(String string) throws InterruptedException {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.id("nav-link-accountList")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ap_email")).sendKeys("dmanish5@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("continue")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Bloor@2258");
	    Thread.sleep(3000);
	    driver.findElement(By.id("auth-signin-button")).click();
	    Thread.sleep(3000);
	}
	
	

	@Then("Customer must be able to see the options from the sublist")
	public void customer_must_be_able_to_see_the_options_from_the_sublist() {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
	    System.out.println("Customer can see the sub options");
	    driver.close();
	}


}
