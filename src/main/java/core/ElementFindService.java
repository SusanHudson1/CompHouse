/*
 * Author: Susan Hudson
 */

package core;

import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;

public interface ElementFindService {
    Element findElement(By locator) throws IOException;
    List<Element> findElements(By locator) throws IOException ;
}
