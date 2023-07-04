package stepdefinitionsignin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class YourOrders {
	
	WebDriver driver;
	
	@Given("User must be an existing customer with <email> and <password> and signed in url {string} and navigate to Your Orders page")
	public void user_must_be_an_existing_customer_with_email_and_password_and_signed_in_url_and_navigate_to_your_orders_page(String string) throws InterruptedException {
System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver();
		driver.get(string);
		driver.manage().window().maximize();
		
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
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.cssSelector("#nav-al-your-account > a:nth-child(2) > span")).click();
	}
	
	@When("Clickin on Your Order Option should navigate to your order history page")
	public void clickin_on_your_order_option_should_navigate_to_your_order_history_page() throws InterruptedException {
		 Thread.sleep(2000);
		driver.findElement(By.cssSelector("#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(1) > a > div")).click();
	}

	
	
	  @When("Customer should be able to view past history like three months, this year or any archived order"
	  ) public void
	  customer_should_be_able_to_view_past_history_like_three_months_this_year_or_any_archived_order
	  () throws InterruptedException { Thread.sleep(2000); Select obj=new
	  Select(driver.findElement(By.id("time-filter"))) ;
	  obj.selectByValue("months-3"); driver.navigate().refresh();
	  Thread.sleep(3000);
	  
	  Select obj1=new Select(driver.findElement(By.id("time-filter"))) ;
	  obj.selectByValue("year-2023"); driver.navigate().refresh();
	  Thread.sleep(3000); Select obj2=new
	  Select(driver.findElement(By.id("time-filter"))) ;
	  obj.selectByValue("archived");
	  
	  
	  }
	 
	  @When("Clicking on Buy again should show reccomendations of purchase history")
	  public void clicking_on_buy_again_should_show_reccomendations_of_purchase_history()throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().to("https://www.amazon.ca/gp/buyagain?ref_=ppx_yo2ov_dt_b_tb_buy_again");
		System.out.println("Show Purchase history");
		
	}

	  @When("Clicking on Not Shipped Yet option should show pending order or display appriopriate message")
	  public void clicking_on_not_shipped_yet_option_should_show_pending_order_or_display_appriopriate_message() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().to("https://www.amazon.ca/gp/your-account/order-history/ref=ppx_yo_dt_b_oo_view_all_bap_c?ie=UTF8&orderFilter=open");
		System.out.println("Shows the pending orders or show appropriate message");
		
	}
		
		

	  @When("Clicking on Cancelled order Option should show order cancelled in six months.")
	  public void clicking_on_cancelled_order_option_should_show_order_cancelled_in_six_months()  throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().to("https://www.amazon.ca/gp/your-account/order-history/ref=ppx_yo_dt_b_cancelled_orders?ie=UTF8&orderFilter=cancelled");
	}

	  @Then("Customer is happy")
	  public void customer_is_happy(){
		System.out.println("Customer is able to navigate can see all the options");
	  
	}


}
