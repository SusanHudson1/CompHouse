/*
 * Author: Susan Hudson
 */

package pages;

import core.Browser;
import core.DriverDecorator;
import core.Element;
import core.WebCoreDriver;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class LoggingSingletonDriver extends DriverDecorator {
    private static LoggingSingletonDriver instance;


    public LoggingSingletonDriver(core.Driver driver) {
        super(driver);
    }

    public static LoggingSingletonDriver getInstance()
    {
        if (instance == null)
        {
            instance = new LoggingSingletonDriver(new WebCoreDriver());
        }

        return instance;
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
