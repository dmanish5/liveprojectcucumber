
  package stepdefinitionsignin;
  
  import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By; import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import
  org.openqa.selenium.chrome.ChromeDriver; import
  org.openqa.selenium.chrome.ChromeOptions; import
  org.openqa.selenium.interactions.Actions; import
  org.openqa.selenium.support.ui.Select;
  
  import io.cucumber.java.en.Given; import io.cucumber.java.en.Then; import
  io.cucumber.java.en.When;
  
  public class YourAddresses {
  
  WebDriver driver;
  
  @Given("User must be an existing customer with <email> and <password> and signed in url {string} and navigate to Your Addresses page"
  ) public void
  user_must_be_an_existing_customer_with_email_and_password_and_signed_in_url_and_navigate_to_your_addresses_page
  (String string) throws InterruptedException {
  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
  
  ChromeOptions op=new ChromeOptions();
  op.addArguments("--remote-allow-origins=*"); driver=new ChromeDriver();
  driver.get(string); driver.manage().window().maximize();
  
  Actions action=new Actions(driver);
  action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build
  ().perform(); 
  driver.findElement(By.id("nav-link-accountList")).click();
  Thread.sleep(2000);
  driver.findElement(By.id("ap_email")).sendKeys("dmanish5@gmail.com");
  Thread.sleep(2000); driver.findElement(By.id("continue")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(
  "Bloor@2258"); Thread.sleep(2000);
  driver.findElement(By.id("auth-signin-button")).click(); Thread.sleep(2000);
  action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build
  ().perform(); driver.findElement(By.
  cssSelector("#nav-al-your-account > a:nth-child(2) > span")).click(); }
  
  
  @When("Click on Your Addresses option should navigate to add address option page"
  ) public void
  clickin_on_your_addresses_option_should_navigate_to_add_address_option_page()
  throws InterruptedException { 
	  Thread.sleep(2000); 
  driver.findElement(By.cssSelector("#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(1) > a > div > div > div")).click(); 
  }
  
  @When("Click on Add Address should should navigate to address window") public
  void click_on_add_address_should_should_navigate_to_address_window() throws
  InterruptedException { Thread.sleep(2000);
  driver.findElement(By.cssSelector("#ya-myab-address-add-link > div")).click()
  ; }
  
  @When("Enter Address details")
  public void Enter_Address_details ()
  throws InterruptedException{
	  
	  Select country= new Select (driver.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId")));
	  Thread.sleep(2000);
		country.selectByValue("CA");

	
  driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys
  ("manish"); 
  Thread.sleep(3000);
  driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("6475967899"); 
  Thread.sleep(3000);
  driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("6 rosebank dr"); 
  Thread.sleep(3000);
  driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("unit 8h"); 
  Thread.sleep(3000);
  driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("scarborough"); 
  Thread.sleep(3000);
  
 Select province=new Select(driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")));
 province.selectByValue("Ontario");
  
  driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("m1B0A1"); 
  Thread.sleep(3000);
  
  }
  
  
  @When("Customer has option to make address as default by clicking it") 
  public void customer_has_option_to_make_address_as_default_by_clicking_it() throws InterruptedException { 
	  driver.findElement(By.id("address-ui-widgets-use-as-my-default")).click();
	  Thread.sleep(2000);
	  
  }
  
  @When("Click on Add address button should save the address in the account")
  public void click_on_add_address_button_should_save_the_address_in_the_account() throws InterruptedException { 
	  driver.findElement(By.id("address-ui-widgets-form-submit-button")).click();
	  Thread.sleep(2000);
  
  }
  
  @Then("the customer gets the suggestion of right address format but still customer should have choice to select")
  public void the_customer_gets_the_suggestion_of_right_address_format_but_still_customer_should_have_choice_to_select() {
	  String actualresult =driver.getCurrentUrl();
	   Assert.assertNotSame("https://www.amazon.ca/a/addresses/add?ref=ya_address_book_add_post", actualresult);
	   System.out.println("Address added");
		
  }

  }
 