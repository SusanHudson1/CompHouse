/*
 * Author: Susan Hudson
 */

package pages.LoginPage;

import configuration.ConfigurationService;
import configuration.UrlDeterminer;
import configuration.UrlSettings;
import configuration.WebSettings;
import core.BrowserService;
import core.Driver;
import pages.LoggingSingletonDriver;
import pages.NavigatableStdPage;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import pages.Sections.BreadcrumbSection;
import org.testng.Assert;



public class LoginPage extends NavigatableStdPage {
	private final BrowserService browserService;

    public LoginPage(Driver driver) {
        super(driver);
        browserService = driver;
    }

    private LoginPageElements elements() {
        return new LoginPageElements(elementFindService);
    }



    @Override
    protected String getUrl() {
        return UrlDeterminer.getLoginUrl("login");
    }

    @Override
    protected void waitForPageLoad() throws IOException {
        elements().loginButton().waitToExist();
    }

    public LoginPage login(String username, String password, String isValid) throws InterruptedException, IOException {
        elements().usernameTextbox().typeText(username);
        elements().passwordTextbox().typeText(password);
        elements().loginButton().click();
        browserService.waitForAjax();
	    if(isValid.equals("N")) {					//If we used an invalid email address/password combination
	    	elements().failMessage().waitToExist();
	    	var message = elements().failMessage().getText();
	    	var expected = "Invalid credentials";
	    	Assert.assertEquals(message, expected);
        }
        return this;
    }
    


}
