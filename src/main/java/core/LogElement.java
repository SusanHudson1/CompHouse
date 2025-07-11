/*
 * Author: Susan Hudson
 */


package core;

import org.openqa.selenium.By;

public class LogElement extends ElementDecorator {

    protected LogElement(Element element) {
        super(element);
    }

    @Override
    public By getBy() {
        return element.getBy();
    }

    @Override
    public String getText() {
        System.out.printf("Element Text = %s\n", element.getText());
        return element.getText();
    }

    @Override
    public Boolean isEnabled() {
        System.out.printf("Element Enabled = %b\n", element.isEnabled());
        return element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        System.out.printf("Element Displayed = %b\n", element.isDisplayed());
        return element.isDisplayed();
    }

    @Override
    public void typeText(String text) throws InterruptedException {
        System.out.printf("Type Text = %s\n", text);
        element.typeText(text);
    }

    @Override
    public void click() throws InterruptedException  {
        System.out.printf("Element Clicked = %s\n", element.getText());
        element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        System.out.printf("Get Attribute = %s\n", attributeName);
        return element.getAttribute(attributeName);
    }
    
    @Override
    public void selectByIndex(int index)   {
        System.out.print("Select by index: " + index + "\n");
        element.selectByIndex(index);
    }
}
