/*
 * Author: Susan Hudson
 */

package publicPage;

import core.Browser;
import core.Driver;
import core.LoggingDriver;
import core.WebCoreDriver;
import pages.BookingPage.BookingPage;
import pages.LoginPage.LoginPage;
import pages.MainPage.MainPage;
import pages.Sections.MainMenuSection;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;


public class BookingTests {
    private Driver driver;
    private static MainPage mainPage;
    private static BookingPage bookingPage;
    private static LoginPage loginPage;


	    @BeforeMethod
	    public void testInit() throws IOException {
	        driver = new LoggingDriver(new WebCoreDriver());
	        driver.start(Browser.CHROME);
	        mainPage = new MainPage(driver);
	        bookingPage = new BookingPage(driver);
	        loginPage = new LoginPage(driver);
	    }
	    

	    @AfterMethod
	    public void testCleanup() throws InterruptedException, IOException {
	        driver.quit();
	    }



	    
	    @Test(dataProvider = "getLoginInfoData")
	    public void makeABooking(String todo) throws InterruptedException, IOException, URISyntaxException {
	    	mainPage.open();
	    	// TO DO
	    }
	    
	    @DataProvider
	    public Object[][] getLoginInfoData(){
	        Object[][] data = new Object[1][1];
	        data[0][0] = "NOT SURE WHAT WE NEED YET";				//TO DO

	        return data;
	    }
	    
	}