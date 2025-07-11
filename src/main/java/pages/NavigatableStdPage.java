/*
 * Author: Susan Hudson
 */

package pages;

import java.io.IOException;

import core.Driver;
import core.NavigationService;

public abstract class NavigatableStdPage extends StdPage {
    protected final NavigationService navigationService;

    public NavigatableStdPage(Driver driver) {
        super(driver);
        navigationService = driver;
    }

    protected abstract String getUrl();

    public void open() throws IOException
    {
        navigationService.goToUrl(getUrl());
        waitForPageLoad();
    }

    protected abstract void waitForPageLoad() throws IOException ;
}
