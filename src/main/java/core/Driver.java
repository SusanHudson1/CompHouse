/*
 * Author: Susan Hudson
 */

package core;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.util.List;

public abstract class Driver implements NavigationService, BrowserService, CookiesService, ElementFindService, DialogService {
    public abstract WebDriverWait getBrowserWait() throws IOException ;
}
