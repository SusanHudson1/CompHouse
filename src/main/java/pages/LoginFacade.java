/*
 * Author: Susan Hudson
 */

package pages;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class LoginFacade {
	public void verifyLogin(String username, String password, String isValid) throws InterruptedException, IOException, URISyntaxException {
		enterUsername(username);
		enterPassword(password);
		assertLoginSuccess(isValid);
	}
	
	protected abstract void enterUsername(String username) throws InterruptedException, IOException ;
	protected abstract void enterPassword(String password) throws InterruptedException;
	protected abstract void assertLoginSuccess(String isValid);
}
