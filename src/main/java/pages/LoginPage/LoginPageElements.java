/*
 * Author: Susan Hudson
 */

package pages.LoginPage;

import core.Element;
import core.ElementFindService;

import java.io.IOException;

import org.openqa.selenium.By;

public class LoginPageElements {
    private final ElementFindService elementFindService;

    public LoginPageElements(ElementFindService elementFindService)  {
        this.elementFindService = elementFindService;
    }

    public Element demoLink() throws IOException {
        return elementFindService.findElement(By.linkText("Restful Booker Platform Demo"));
    }
    
    public Element frontPageLink() throws IOException {
        return elementFindService.findElement(By.linkText("Front Page"));
    }

    public Element logoutButton() throws IOException {
        return elementFindService.findElement(By.linkText("btnLogout"));
    }
    
    public Element usernameTextbox() throws IOException {
        return elementFindService.findElement(By.id("username"));
    }
    
    public Element passwordTextbox() throws IOException {
        return elementFindService.findElement(By.id("password"));
    }
    
    public Element loginButton() throws IOException {
        return elementFindService.findElement(By.id("doLogin"));
    }
    
    public Element failMessage() throws IOException {
        return elementFindService.findElement(By.className("alert alert-danger"));
    }
    
    
}
