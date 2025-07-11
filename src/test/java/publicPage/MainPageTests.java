/*
 * Author: Susan Hudson
 */

package publicPage;

import core.Browser;
import core.Driver;
import core.LoggingDriver;
import core.WebCoreDriver;
import pages.LoginPage.LoginPage;
import pages.MainPage.MainPage;
import pages.Sections.MainMenuSection;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class MainPageTests {
    private Driver driver;
    private static MainPage mainPage;
    private static LoginPage loginPage;
    private static MainMenuSection menuSection;


	    @BeforeMethod
	    public void testInit() throws IOException {
	        driver = new LoggingDriver(new WebCoreDriver());
	        driver.start(Browser.CHROME);
	        mainPage = new MainPage(driver);
	        loginPage = new LoginPage(driver);

	    }
	    

	    @AfterMethod
	    public void testCleanup() throws InterruptedException, IOException {
	        driver.quit();
	    }


	    public void checkPageLinks() throws InterruptedException, IOException, URISyntaxException {
	    	mainPage.open();
	    	menuSection.clickHomeLink();
	    	mainPage.checkWelcomeText();			//Check for Welcome message
	    	menuSection.clickRoomsLink();
	    	mainPage.checkRoomsHeader();
	    	menuSection.clickBookingLink();
	    	mainPage.checkAvailability();			
	    	menuSection.clickAmenitiesLink();		//This link appears to be broken - so not sure what it should bring up...
	    	mainPage.checkAmenities();
	    	menuSection.clickLocationLink();
	    	mainPage.checkLocation();			
	    	menuSection.clickContactLink();
	    	mainPage.checkContact();

	    }
	    

	    
	}