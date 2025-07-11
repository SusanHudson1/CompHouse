/*
 * Author: Susan Hudson
 */


package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class LoggingDriver extends DriverDecorator {

    public LoggingDriver(Driver driver) {
        super(driver);
    }

    @Override
    public void start(Browser browser) throws IOException {

        System.out.print(String.format("start browser = %s\n", browser.name()));
        driver.start(browser);
    }

    @Override
    public void quit() throws IOException {
        System.out.print("close browser\n");
        driver.quit();
    }

    @Override
    public void goToUrl(String url) throws IOException {
        System.out.print(String.format("go to url = %s\n", url));
        driver.goToUrl(url);
    }

    @Override
    public Element findElement(By locator) throws IOException {
        System.out.print("find element\n");
        return driver.findElement(locator);
    }

    @Override
    public List<Element> findElements(By locator) throws IOException {
        System.out.print("find elements\n");
        return driver.findElements(locator);
    }
}
