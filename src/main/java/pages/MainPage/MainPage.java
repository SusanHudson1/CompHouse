/*
 * Author: Susan Hudson
 */

package pages.MainPage;

import configuration.ConfigurationService;
import configuration.WebSettings;
import core.Driver;
import pages.NavigatableStdPage;
import configuration.UrlDeterminer;
import java.io.IOException;

import org.testng.Assert;

public class MainPage extends NavigatableStdPage {
    public MainPage(Driver driver) {
        super(driver);
    }

    private MainPageElements elements() {
        return new MainPageElements(elementFindService);
    }


    @Override
    protected void waitForPageLoad() {
    }


	@Override
	protected String getUrl() {
	    return UrlDeterminer.getLoginUrl("login");
	}
	
    
    public MainPage checkWelcomeText() throws InterruptedException, IOException {
    	var expected = "Welcome to Shady Meadows B&B";
    	var message = elements().welcomeText().getText();
    	Assert.assertEquals(message, expected);
        return this;
    }
    
    
    public MainPage checkRoomsHeader() throws InterruptedException, IOException {
    	var expected = "Our Rooms";
    	var message = elements().ourRoomsText().getText();
    	Assert.assertEquals(message, expected);
        return this;
    }
    
    public MainPage checkAvailability() throws InterruptedException, IOException {
    	var expected = "Check Availability & Book Your Stay";
    	var message = elements().availabilitySection().getText();
    	Assert.assertEquals(message, expected);
        return this;
    }
    
    public MainPage checkAmenities() throws InterruptedException, IOException {
//		TODO - Not sure what should be in this section.
        return this;
    }
    
    public MainPage checkLocation() throws InterruptedException, IOException {
    	var expected = "Our Location";
    	var message = elements().locationSection().getText();
    	Assert.assertEquals(message, expected);
        return this;
    }
    
    public MainPage checkContact() throws InterruptedException, IOException {
    	var expected = "Send Us a Message";
    	var message = elements().contactSection().getText();
    	Assert.assertEquals(message, expected);
        return this;
    }
}
