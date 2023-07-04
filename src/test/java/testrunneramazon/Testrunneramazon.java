package testrunneramazon;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Manish Niketa\\eclipse-workspace\\Liveprojectcucumber\\src\\test\\java\\feature",glue= {"stepdefinitionsignin"},
plugin= {"pretty","html:target/HTmlreports"},monochrome=true,dryRun=true) //generate html reports


public class Testrunneramazon {
	
	

}
