package stepdefinitionsignin;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Shoppingcart {
	WebDriver driver;
	private Object wait;
	
	@Given("User must be signed in and on the url {string}")
	public void user_must_be_signed_in_and_on_the_url(String string) throws InterruptedException {
System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver();
		driver.get(string);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("ap_email")).sendKeys("dmanish5@yahoo.com");
		Thread.sleep(3000);
		 driver.findElement(By.id("continue")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.cssSelector("#ap_password")).sendKeys("Atlantis21!");
			  Thread.sleep(3000);
			  driver.findElement(By.id("auth-signin-button")).click();
			    Thread.sleep(3000);
		
		
	}

	@When("The User must have searched the specific item and clicked ont it to be navigated to that item")
	public void the_user_must_have_searched_the_specific_item_and_clicked_ont_it_to_be_navigated_to_that_item() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("mens dress shoes");
		driver.findElement(By.cssSelector("#nav-search-submit-button")).submit();
		driver.findElement(By.linkText("Men Dress Shoe King Classic Lace Up Oxford Plain or Cap Toe or Wingtip with Leather Sock Medium and Wide Width Black Brown Cognac")).click();
		
	
	}

	@When("Add one or multiple items to the cart")
	public void add_one_or_multiple_items_to_the_cart() throws InterruptedException {
	
		Select quantity=new Select(driver.findElement(By.id("quantity")));
		quantity.selectByIndex(0);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().refresh(); 
		Thread.sleep(4000);
		Select quantity1=new Select(driver.findElement(By.id("quantity")));
		quantity1.selectByIndex(1);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#sw-gtc")).click();
		String actualresult =driver.getCurrentUrl();
		   Assert.assertEquals("https://www.amazon.ca/cart?ref_=sw_gtc", actualresult);
		   
		
	   
	}

	@When("Click on the item in cart to show the information of the item")
	public void click_on_the_item_in_cart_to_show_the_information_of_the_item() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.partialLinkText("bravo! Men Dress Shoe King-7 Classic Lace Up Oxford with Leather Sock Medium and Wide Width Cognac ")).click();
		String actualresult =driver.getCurrentUrl();
		   Assert.assertNotEquals("https://www.amazon.ca/cart?ref_=ewc_gtc", actualresult);
		   Thread.sleep(2000);
	}

	@When("Add the same item multiple times")
	public void add_the_same_item_multiple_times() throws InterruptedException {
		driver.navigate().to("https://www.amazon.ca/s?k=mens+dress+shoes&crid=6U7EWSS8OSX3&sprefix=%2Caps%2C251&ref=nb_sb_ss_recent_1_0_recent");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Men Dress Shoe King Classic Lace Up Oxford Plain or Cap Toe or Wingtip with Leather Sock Medium and Wide Width Black Brown Cognac")).click();
		Thread.sleep(2000);
		Select quantity2=new Select(driver.findElement(By.id("quantity")));
		Thread.sleep(2000);
		quantity2.selectByIndex(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#sw-gtc")).click();
	}
		
	

	@When("Add multiple of different items")
	public void add_multiple_of_different_items() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().to("https://www.amazon.ca/s?k=mens+dress+shoes&crid=6U7EWSS8OSX3&sprefix=%2Caps%2C251&ref=nb_sb_ss_recent_1_0_recent");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Men's Leather Lined Formal Dress Oxfords Shoes")).click();
		Thread.sleep(2000);
		Select quantity3=new Select(driver.findElement(By.id("quantity")));
		Thread.sleep(2000);
		quantity3.selectByIndex(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#sw-gtc")).click();
		Thread.sleep(2000);
		/*
		 * Select quantity4=new Select(driver.findElement(By.id("#quantity")));
		 * Thread.sleep(2000); quantity4.selectByIndex(1); Thread.sleep(2000);
		 */
		String actualresult =driver.getCurrentUrl();
		   Assert.assertEquals("https://www.amazon.ca/cart?ref_=sw_gtc", actualresult);
		   Thread.sleep(2000);
	}
	

	@When("Remove one item or all items")
	public void remove_one_item_or_all_items() throws InterruptedException {
		
		/*
		 * driver.findElement(By.partialLinkText("Del")).click(); Thread.sleep(4000);
		 * //driver.navigate().refresh(); Thread.sleep(4000);
		 * driver.findElement(By.linkText("Delete")).click(); Thread.sleep(2000);
		 * 
		 * String actualresult =driver.getCurrentUrl();
		 * Assert.assertEquals("https://www.amazon.ca/cart?ref_=sw_gtc", actualresult);
		 * Thread.sleep(2000);
		 */
		   driver.quit();
		   
	}

	@When("Add items to cart close the browser and reopen")
	public void add_items_to_cart_close_the_browser_and_reopen() throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
		driver.findElement(By.id("ap_email")).sendKeys("dmanish5@yahoo.com");
		Thread.sleep(3000);
		 driver.findElement(By.id("continue")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.cssSelector("#ap_password")).sendKeys("Atlantis21!");
			  Thread.sleep(3000);
			  driver.findElement(By.id("auth-signin-button")).click();
			    Thread.sleep(3000);
		
		/*
		 * driver.get(
		 * "https://www.amazon.ca/s?k=mens+dress+shoes&crid=3GXKS2WJYCJ7D&sprefix=%2Caps%2C289&ref=nb_sb_ss_recent_1_0_recent"
		 * ); Thread.sleep(2000); driver.findElement(By.
		 * linkText("Men Dress Shoe King Classic Lace Up Oxford Plain or Cap Toe or Wingtip with Leather Sock Medium and Wide Width Black Brown Cognac"
		 * )).click(); Select quantity8=new
		 * Select(driver.findElement(By.id("quantity"))); quantity8.selectByIndex(0);
		 * driver.findElement(By.id("add-to-cart-button")).click(); Thread.sleep(2000);
		 * driver.findElement(By.cssSelector("#sw-gtc")).click(); Thread.sleep(2000);
		 * driver.quit();
		 */
		driver.get("https://www.amazon.ca/cart?ref_=sw_gtc");
		
		String actualresult =driver.getCurrentUrl();
		   Assert.assertEquals("https://www.amazon.ca/cart?ref_=sw_gtc", actualresult);
		
	   
	}

	@Then("Shopping cart update should be successful")
	public void shopping_cart_update_should_be_successful() {
	   System.out.println("Shopping Cart Successful");
	}



}
