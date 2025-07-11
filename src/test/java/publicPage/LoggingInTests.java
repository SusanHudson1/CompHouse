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


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class LoggingInTests {
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



	    
	    @Test(dataProvider = "getLoginInfoData")
	    public void navigateToLoginPage(String username, String password, String isValid) throws InterruptedException, IOException, URISyntaxException {
	    	mainPage.open();
	    	menuSection.clickAdminLink();
	    	loginPage.login(username, password, isValid);
	    }
	    
	    
	    @DataProvider
	    public Object[][] getLoginInfoData(){
	        Object[][] data = new Object[2][3];
	        data[0][0] = "Fred";		//Username
	        data[0][1] = "Wrong";		//Password
	        data[0][2] = "N";			//Is it valid?

	        data[1][0] = "Admin";
	        data[1][1] = "WrongPW";
	        data[1][2] = "N";

	        return data;
	    }
	    
	}