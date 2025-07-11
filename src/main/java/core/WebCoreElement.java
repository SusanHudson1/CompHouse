/*
 * Author: Susan Hudson
 */

package core;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class WebCoreElement extends Element {
    private final WebDriver webDriver;
    private final WebElement webElement;
    private final By by;

    public WebCoreElement(WebDriver webDriver, WebElement webElement, By by)
    {
        this.webDriver = webDriver;
        this.webElement = webElement;
        this.by = by;
    }

    @Override
    public By getBy() {
        return by;
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public Boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        return webElement.isDisplayed();
    }
    

    @Override
    public void typeText(String text) throws InterruptedException {
        Thread.sleep(500);
        webElement.clear();
        webElement.sendKeys(text);
    }

    @Override
    public void click() throws InterruptedException {
//        waitToBeClickable(by);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", webElement);
    }

    @Override
    public String getAttribute(String attributeName) {
        return webElement.getAttribute(attributeName);
    }

    @Override
    public Element findElement(By locator) {
        var nativeWebElement = webElement.findElement(locator);
		Actions action = new Actions(webDriver);
        Element element = new WebCoreElement(webDriver, nativeWebElement, locator);
        Element logElement = new LogElement(element);
        action.moveToElement(webElement);
        action.perform();
        return logElement;
    }

    @Override
    public void waitToExist()
    {
    	var webDriverWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @Override
    public void waitToBeVisible()
    {
    	var webDriverWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    
    @Override
    public void waitToNotExist()
    {
    	var webDriverWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    
    private void waitToBeClickable(By by)
    {
    	var webDriverWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    @Override
    public void selectByIndex(int index) {
		Select selector =new Select(webElement);
		if(index == 0) {
		   	List<WebElement> dropdownOptions = selector.getOptions();
		   	int maxIndex = dropdownOptions.size();
    		Random rnd = new Random();   
    		index = rnd.nextInt(maxIndex-1)+1;
		}
		selector.selectByIndex(index);
		
    }

}
