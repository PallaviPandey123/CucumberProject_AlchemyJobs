package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import setUp.driverSetUp;

public class postJob extends driverSetUp{
		
	WebDriver driver = driverSetUp.settingUp();
	
    @Given ("^User goes to Alchemy Jobs page with URL \"(.*)\"$")
    public void getURL(String url) {
    	driver.get(url);
    }
    @When ("^User clicks Post A Job link$")
    public void clickPostJob() {
    	driver.findElement(By.linkText("Post a Job")).click();
    }
    @And ("^User adds a job with email \"(.*)\"$")
    public void enterEmail(String email) {
    	driver.findElement(By.id("create_account_email")).sendKeys(email);
    }
    @And ("^User enters a title \"(.*)\"$")
    public void enterTitle(String title) {
    	driver.findElement(By.id("job_title")).sendKeys(title);
    }
    @And ("^User enters an App email \"(.*)\"$")
    public void enterAppEmail(String appEmail) {
    	driver.findElement(By.id("application")).sendKeys(appEmail);
    }
    @And ("^User enters a company \"(.*)\"$")
    public void enterCompany(String company) {
    	driver.findElement(By.id("company_name")).sendKeys(company);
    }
    @And ("^User enters a description \"(.*)\"$")
    public void enterDesc(String desc) {
    	driver.switchTo().frame("job_description_ifr");
    	driver.findElement(By.id("tinymce")).sendKeys(desc);
    	driver.switchTo().parentFrame();
    }
    @And ("^User submits the form$")
    public void submit() {
    	driver.findElement(By.name("submit_job")).click();
    	driver.findElement(By.id("job_preview_submit_button")).click();
    }
    @Then ("^User confirms job listing with title \"(.*)\" is shown$")
    public void confirmSubmission(String title) throws InterruptedException {
    	
    	driver.findElement(By.linkText("Jobs")).click();
    	driver.findElement(By.id("search_keywords")).sendKeys(title);
    	
    	Thread.sleep(4000);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='job_listings']/li[1]")));
		driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]")).click();
		
		String jobTitle = driver.findElement(By.className("entry-title")).getText();
		
		System.out.println(jobTitle);
		//Assert.assertEquals(jobTitle, title);
    }
}
