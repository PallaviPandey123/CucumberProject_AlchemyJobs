package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setUp.driverSetUp;

public class searchForJobs extends driverSetUp {
		
	    WebDriver driver = settingUp();
	
	    @Given ("^User is on Alchemy Jobs page with URL \"(.*)\"$")
			    public void gotoAlchemyJobs(String url) {		    	
			    	driver.get(url);
			    }
	    
	    @When ("^User clicks Jobs link$")
			    public void navigateToJobs() {
			    	driver.findElement(By.linkText("Jobs")).click();
			    }
	    	    
	    @And ("^User types in keywords to search for jobs$")
	    		public void searchingForJobs() {
	    	    	driver.findElement(By.id("search_keywords")).sendKeys("Engineer");
	    	    }
	    		
	    @And ("^User filters job type to show only \"(.*)\" jobs$")
	    		public void filterJobs(String inputType) {
	    	    	List<WebElement> jobTypes = driver.findElements(By.xpath("//*[@id='post-7']/div/div/form/ul/li"));
	    	    	for(WebElement x : jobTypes) {
	    	    		String type = x.getText();
	    	    		if (type.compareTo(inputType)!=0) {
	    	    			x.click();
	    	    		}
	    	    	}
	    	    }
	    		
	    @And ("^User finds a job to see the details$")
	    		public void findAJob() {
	    			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='job_listings']/li[1]")));
	    			driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]")).click();
	    	    }
	    		
	    @Then ("^User is taken to the Job Details page$")
	    		public void checkJobDetails() {
	    	    	String jobTitle = driver.findElement(By.className("entry-title")).getText();
	    	    	System.out.println("Job Title is "+ jobTitle);
	    	    }
	    		
	    @And ("^User is allowed to apply for the job$")
	    		public void applyForJob() {
	    	    	driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
	    	    }
}
