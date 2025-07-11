/*
 * Author: Susan Hudson
 */

package pages;

import pages.MainPage.MainPage;
import pages.Sections.MainMenuSection;

import java.io.IOException;
import java.net.URISyntaxException;

public class NewLoginFacade extends LoginFacade {
	private final MainPage mainPage;
	private final MainMenuSection mainMenuSection;

	
	public NewLoginFacade(MainPage mainPage, MainMenuSection mainMenuSection) throws IOException {
		this.mainPage = mainPage;
		this.mainMenuSection = mainMenuSection;
	}
	
	@Override
	protected void enterUsername(String username) throws InterruptedException, IOException {
//		landingPage.open();
		mainMenuSection.clickAdminLink();
	}
	
	@Override 
	protected void enterPassword(String password) throws InterruptedException {
//		landingPage.open();
	}
	
	@Override
	protected void assertLoginSuccess(String isValid) {
//		landingPage.open();
	}

	
}
