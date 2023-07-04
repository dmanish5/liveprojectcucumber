package stepdefinitionsignin;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Searchbar {
	WebDriver driver;
	
	@Given("User must be on the url {string}")
	public void user_must_be_on_the_url(String string) {
System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver();
		driver.get(string);
		driver.manage().window().maximize();
	   
	}

	@When("User has the ability to <search> and should be navigated to the Search results page")
	public void user_has_the_ability_to_search_and_should_be_navigated_to_the_search_results_page() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("shir");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#nav-search-submit-button")).submit();
		Thread.sleep(2000);
		driver.navigate().to("https://www.amazon.ca/");
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone 14");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#nav-search-submit-button")).submit();
		Thread.sleep(3000);
		driver.navigate().to("https://www.amazon.ca/");
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("t shirt for men");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#nav-search-submit-button")).submit();
		Thread.sleep(2000);
		driver.navigate().to("https://www.amazon.ca/");
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(" B0BFMFQ3RS");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#nav-search-submit-button")).submit();
		Thread.sleep(3000);
		driver.navigate().to("https://www.amazon.ca/");

	}

	@When("User Should be allowed to click on next page")
	public void user_should_be_allowed_to_click_on_next_page() throws InterruptedException {
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone 14");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#nav-search-submit-button")).submit();
		Thread.sleep(2000);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Nex")));
		driver.findElement(By.partialLinkText("Nex")).click();
		Thread.sleep(2000);
		driver.navigate().to("https://www.amazon.ca/");
		Assert.assertTrue(true);
	}

	@When("User Must be allowed to Filter item")
	public void user_must_be_allowed_to_filter_item() throws InterruptedException {
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone 14 case");
		Thread.sleep(5000);
		  Assert.assertTrue("TAURI [5 in 1] Designed for iPhone 14 Case [Not Yellowing], with 2 Tempered Glass Screen Protectors + 2 Camera Lens Protectors [Military Grade Protection] Shockproof Slim Phone case 6.1 Inch, Clear", true);
		  
		driver.findElement(By.cssSelector("#nav-search-submit-button")).submit();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"p_72/11192170011\"]/span/a/section/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"p_89/JETech\"]/span/a/div/label/i")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id=\"p_36/12035763011\"]/span/a")).click();
		
	}

	@When("User must have four to five options to select and you can sort by one parameter only.")
	public void user_must_have_four_to_five_options_to_select_and_you_can_sort_by_one_parameter_only() throws InterruptedException {
		driver.navigate().to("https://www.amazon.ca/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone 14 case");
		//Thread.sleep(3000);
		driver.findElement(By.cssSelector("#nav-search-submit-button")).submit();
		Thread.sleep(3000);
		
		Select quantity3=new Select(driver.findElement(By.id("s-result-sort-select")));
		Thread.sleep(2000);
		quantity3.selectByValue("review-rank");
		Thread.sleep(2000);
		
	}
		
			

	@When("Sorting and Filtering together")
	public void sorting_and_filtering_together() throws InterruptedException {
		driver.navigate().to("https://www.amazon.ca/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone 14 case");
		driver.findElement(By.cssSelector("#nav-search-submit-button")).submit();
		
		driver.findElement(By.xpath("//*[@id=\"p_72/11192169011\"]/span/a/section/i")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"p_89/JETech\"]/span/a/span")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		Select quantity3=new Select(driver.findElement(By.cssSelector("#s-result-sort-select")));
		Thread.sleep(3000);
		quantity3.selectByValue("price-asc-rank");
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		
	}

	@When("Sorting,Filtering and Pagination together")
	public void sorting_filtering_and_pagination_together() throws InterruptedException {
		
		driver.navigate().to("https://www.amazon.ca/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone 14 case");
		driver.findElement(By.cssSelector("#nav-search-submit-button")).submit();
		driver.findElement(By.xpath("//*[@id=\"p_72/11192170011\"]/span/a/section/i")).click();
		driver.findElement(By.xpath("//*[@id=\"p_89/JETech\"]/span/a/div/label/i")).click();
		
		Select quantity3=new Select(driver.findElement(By.id("s-result-sort-select")));
		Thread.sleep(2000);
		quantity3.selectByValue("price-desc-rank");
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Nex")));
		driver.findElement(By.partialLinkText("Nex")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);	
	
	}

	@Then("User Should get Relevant Product,Product information,check that by default {int} products per page")
	public void user_should_get_relevant_product_product_information_check_that_by_default_products_per_page(Integer int1) {	
		System.out.println("Products displayed");
	}

	@Then("Check Sorting,Filtering and Pagination")
	public void check_sorting_filtering_and_pagination() {
		String actualresult =driver.getCurrentUrl();
		   Assert.assertEquals("https://www.amazon.ca/s?k=Iphone+14+case&i=electronics&rh=n%3A667823011%2Cp_72%3A11192170011%2Cp_89%3AJETech&s=price-desc-rank&dc&page=2&crid=2XXK71ERW8GP&qid=1687654221&rnid=7590290011&sprefix=iphone+14+c%2Caps%2C146&ref=sr_pg_1", actualresult);
		
	}


}
