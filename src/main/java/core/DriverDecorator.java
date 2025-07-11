/*
 * Author: Susan Hudson
 */

package core;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class DriverDecorator extends Driver {
    protected final Driver driver;

    public DriverDecorator(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void start(Browser browser) throws IOException {
        driver.start(browser);
    }

    @Override
    public void quit() throws IOException {
        driver.quit();
    }

    @Override
    public void goToUrl(String url) throws IOException {
        driver.goToUrl(url);
    }

    @Override
    public String getUrl() throws IOException {
        return driver.getUrl();
    }

    @Override
    public Element findElement(By locator) throws IOException  {
        return driver.findElement(locator);
    }

    @Override
    public List<Element> findElements(By locator) throws IOException {
        return driver.findElements(locator);
    }

    @Override
    public void waitForAjax() throws IOException {
        driver.waitForAjax();
    }

    @Override
    public void waitUntilPageLoadsCompletely() throws IOException {
        driver.waitUntilPageLoadsCompletely();
    }

    @Override
    public WebDriverWait getBrowserWait() throws IOException  {
        return driver.getBrowserWait();
    }
    
    @Override
    public void back() throws IOException {
        driver.back();
    }
}