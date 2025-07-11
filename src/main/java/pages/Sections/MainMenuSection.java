/*
 * Author: Susan Hudson
 */

package pages.Sections;

import core.BrowserService;
import core.Element;
import core.ElementFindService;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;


public class MainMenuSection {
    private final ElementFindService elementFindService;
	
    public MainMenuSection(ElementFindService elementFindService) {
        this.elementFindService = elementFindService;
    }

    private Element homeLink() throws IOException {
        return elementFindService.findElement(By.linkText("Shady Meadows B&B"));
    }
    
    private Element roomsLink() throws IOException {
        return elementFindService.findElement(By.linkText("Rooms"));
    }
    
    private Element bookingLink() throws IOException {
        return elementFindService.findElement(By.linkText("Booking"));
    }

    private Element amenitiesLink() throws IOException {
        return elementFindService.findElement(By.linkText("Amenities"));
    }

    private Element locationLink() throws IOException {
        return elementFindService.findElement(By.linkText("Location"));
    }
    
    private Element contactLink() throws IOException {
        return elementFindService.findElement(By.linkText("Contact"));
    }

    private Element adminLink() throws IOException {
        return elementFindService.findElement(By.linkText("Admin"));
    }
    
    public void clickHomeLink() throws InterruptedException, IOException  {
    	homeLink().click();
    }

    public void clickRoomsLink() throws InterruptedException, IOException  {
        roomsLink().click();
    }

    public void clickBookingLink() throws InterruptedException, IOException  {
        bookingLink().click();
    }

    public void clickAmenitiesLink() throws InterruptedException, IOException  {
        amenitiesLink().click();
    }


    public void clickLocationLink() throws InterruptedException, IOException  {
        locationLink().click();
    }

    public void clickContactLink() throws InterruptedException, IOException  {
        contactLink().click();
    }

    public void clickAdminLink() throws InterruptedException, IOException  {
        adminLink().click();
    }


}
