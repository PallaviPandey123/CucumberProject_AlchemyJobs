package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import setUp.driverSetUp;

public class closeBrowser extends driverSetUp {
	@And ("^Close the browser$")
    public void closeOpenBrowser() throws InterruptedException {
    	driver.close();
    }
}
