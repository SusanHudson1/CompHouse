/*
 * Author: Susan Hudson
 */

package pages.BookingPage;

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
import java.util.Random;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class BookingPage extends NavigatableStdPage {
	private final BrowserService browserService;

    public BookingPage(Driver driver) {
        super(driver);
        browserService = driver;
    }

    private BookingPageElements elements() {
        return new BookingPageElements(elementFindService);
    }


    @Override
    protected String getUrl() {
        return UrlDeterminer.getLoginUrl("login");
    }

    @Override
    protected void waitForPageLoad() throws IOException {
        elements().makeWithdrawalButton().waitToExist();
    }

    public BookingPage makeWithdrawal(String bankName, String accountNumber, String sortCode, String password) throws InterruptedException, IOException  {
    	String message;
    	String expected;
    	browserService.waitForAjax();
    	try {								// See whether account has already been upgraded or not
    		elements().withdrawalAmountTextBox().waitToExist();
			Random rnd = new Random();   
	    	String available = elements().availableFunds().getAttribute("value");
	    	if(available.contains("."))available = available.replace(".", "");
	    	
	    	int amountAvailable = Integer.parseInt(available);
	    	if (amountAvailable > 499) {
		    	int randomNumber = 1000;							
		    	int withdrawal = rnd.nextInt(randomNumber+1)+500;
		    	if(withdrawal > amountAvailable) { 			//Don't exceed the maximum available
		    		withdrawal = amountAvailable;
		    	}
			    String withx = String.valueOf(withdrawal);
			    withx = withx.substring(0, withx.length() - 2) + "." + withx.substring(withx.length() - 2);
		    	System.out.println("Requesting to withdraw: "+withx);	
		    	elements().withdrawalAmountTextBox().typeText(withx);
		    	elements().bankAccountNameTextBox().typeText(bankName);
		    	elements().bankAccountNumberTextBox().typeText(accountNumber);
		    	elements().sortcodeTextBox().typeText(sortCode);
		    	elements().passwordTextBox().typeText(password);
		    	elements().makeWithdrawalButton().click();
		    	browserService.waitForAjax();
		    	elements().makeWithdrawalButton().waitToNotExist();
    	    	Thread.sleep(1800);
		    	browserService.waitForAjax();
		    	elements().successfulWithdrawalMessage().waitToExist();
		    	message = elements().successfulWithdrawalMessage().getText();
		    	expected = "Your withdrawal request has been received and accepted. Your funds will be transferred to the account details that you provided within 7 working days.";
		    	Assert.assertEquals(message, expected);
	    	}
	    	else {
				System.out.println("Insufficient funds available to make a withdrawal");
	    	}
    	}
	    catch (Exception e) {	
		   	System.out.println("Account has an outstanding withdrawal");

	    }
	    return this;
    }
    



}
