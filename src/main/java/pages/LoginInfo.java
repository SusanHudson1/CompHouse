/*
 * Author: Susan Hudson
 */

package pages;

import configuration.ConfigurationService;
import configuration.LoginInfoDefaults;

import java.io.IOException;

public class LoginInfo {
		private String username;
		private String password;
		private String isValid;
		

	  	public LoginInfo() {
	  		var loginInfoDefaults = ConfigurationService.get(LoginInfoDefaults.class);
	  		this.username = loginInfoDefaults.getUsername();
	  		this.password = loginInfoDefaults.getPassword();
	  		this.isValid = loginInfoDefaults.getIsValid();
	  }

	  	public String getUsername() {
	  		return username;
	  	}
	  	
	  	public String getPassword() {
	  		return password;
	  	}
	  	
	  	public String getIsValid() {
	  		return isValid;
	  	}
	  	
}
