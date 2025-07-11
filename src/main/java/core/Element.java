/*
 * Author: Susan Hudson
 */

package core;

import org.openqa.selenium.By;

public abstract class Element {
    public abstract By getBy();
    public abstract String getText();
    public abstract Boolean isEnabled();
    public abstract Boolean isDisplayed();
    public abstract void typeText(String text) throws InterruptedException;
    public abstract void click() throws InterruptedException;
    public abstract String getAttribute(String attributeName);
    public abstract void waitToExist();
    public abstract void waitToBeVisible();
    public abstract void waitToNotExist();
    public abstract void selectByIndex(int index); 
    public abstract Element findElement(By locator);
}
