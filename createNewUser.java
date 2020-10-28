package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import setUp.driverSetUp;

public class createNewUser extends driverSetUp{

		WebDriver driver = settingUp();
	    
	    @Given ("^User is on login page with url \"(.*)\"$")
	    public void gotoLoginPage(String url) {
	    	driver.get(url);
	    }
	    @When ("^User logs in with \"(.*)\" and \"(.*)\"$")
	    public void login(String userName, String password) {
	    	driver.findElement(By.id("user_login")).sendKeys(userName);
	    	driver.findElement(By.id("user_pass")).sendKeys(password);
	    	driver.findElement(By.id("wp-submit")).click();;
	    }
	    @Then ("^User is successfully logged in$")
	    public void verifySuccessfulLogin() {
	    	String userName = driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a/span")).getText();
	    	Assert.assertEquals(userName, "root");
	    }
	    @When ("^User clicks Users option from the left hand menu$")
	    public void gotoUsersOption() {
	    	driver.findElement(By.xpath("//*[@id=\"menu-users\"]/a/div[3]")).click();
	    }
	    @And ("^User clicks Add New User button$")
	    public void clickAddNewUser() {
	    	driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a")).click();
	    }
	    @And ("^User creates new User \"(.*)\", \"(.*)\", \"(.*)\"$")
	    public void addNewUser(String userName, String email, String password) {
	    	driver.findElement(By.id("user_login")).sendKeys(userName);
	    	driver.findElement(By.id("email")).sendKeys(email);
	    	driver.findElement(By.xpath("//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button")).click();
	    	driver.findElement(By.id("pass1")).sendKeys(password);
	    	if (driver.findElement(By.className("pw-checkbox")).isDisplayed()) {
	    		driver.findElement(By.className("pw-checkbox")).click();
	    	}
	    	driver.findElement(By.id("createusersub")).click();
	    }
	    @Then ("^Verify if user \"(.*)\" with email \"(.*)\" was added$")
	    public void verifyNewUserAdded(String userName, String email) {
	    	driver.findElement(By.id("user-search-input")).sendKeys(email);
	    	driver.findElement(By.id("search-submit")).click();
	    	String user = driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form/table/tbody/tr/td[1]/strong/a")).getText();
	    	Assert.assertEquals(userName, user);
	    }
}
