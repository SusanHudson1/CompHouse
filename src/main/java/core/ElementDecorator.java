/*
 * Author: Susan Hudson
 */

package core;

import org.openqa.selenium.By;

public class ElementDecorator extends Element {
    protected final Element element;

    protected ElementDecorator(Element element) {
        this.element = element;
    }

    @Override
    public By getBy() {
        return element.getBy();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public Boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public void typeText(String text) throws InterruptedException {
        element.typeText(text);
    }

    @Override
    public void click() throws InterruptedException {
        element.click();
    }

    @Override
    public void waitToExist() {
        element.waitToExist();
    }

    @Override
    public void waitToNotExist() {
        element.waitToNotExist();
    }

    
    @Override
    public void waitToBeVisible() {
        element.waitToBeVisible();
    }

    
    @Override
    public String getAttribute(String attributeName) {
        return element.getAttribute(attributeName);
    }

    @Override
    public Element findElement(By locator) {
        return element.findElement(locator);
    }
    
    @Override
    public void selectByIndex(int index) {
    	element.selectByIndex(index);
    }

    
}
