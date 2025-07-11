/*
 * Author: Susan Hudson
 */

package pages.MainPage;

import core.Element;
import core.ElementFindService;

import java.io.IOException;

import org.openqa.selenium.By;

public class MainPageElements {
	   private final ElementFindService elementFindService;

	    public MainPageElements(ElementFindService elementFindService) {
	        this.elementFindService = elementFindService;
	    }


	    public Element welcomeText() throws IOException {
	    	return elementFindService.findElement(By.cssSelector("h1"));
	    	
	    }
	    
	    public Element ourRoomsText() throws IOException {
	    	return elementFindService.findElement(By.id("rooms"));
	    	
	    }

	    public Element availabilitySection() throws IOException {
	    	return elementFindService.findElement(By.id("booking"));
	    	
	    }
	    
	    public Element amenitiesSection() throws IOException {
	    	return elementFindService.findElement(By.id("amenities"));
	    	
	    }
	    
	    public Element locationSection() throws IOException {
	    	return elementFindService.findElement(By.id("location"));
	    	
	    }
	    
	    public Element contactSection() throws IOException {
	    	return elementFindService.findElement(By.id("contact"));
	    	
	    }
	    
}
