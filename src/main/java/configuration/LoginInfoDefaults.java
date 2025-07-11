/*
 * Author: Susan Hudson
 */


package configuration;

public class LoginInfoDefaults {
	private String username;
	private String password;
	private String isValid;
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getIsValid() {
		return isValid;
	}
	
	@Override
	public String toString() {
		return "LoginInfoDefaults{" + 
				"username='" + username + "\'" +
				"password='" + password + "\'" +
				"isValid='" + isValid + "\'" +
				"}";
	}
}
