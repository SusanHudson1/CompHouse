/*
 * Author: Susan Hudson
 */

package pages;

import core.*;

import java.io.IOException;

public class App implements AutoCloseable {
    private Boolean disposed = false;

    public App(Browser browserType) throws IOException {
        LoggingSingletonDriver.getInstance().start(browserType);
    }

    public NavigationService getNavigationService()  throws IOException {
        return SingletonFactory.getInstance(NavigationService.class);
    }

    public BrowserService getBrowserService() {
        return SingletonFactory.getInstance(BrowserService.class);
    }

    public CookiesService getCookiesService() {
        return SingletonFactory.getInstance(CookiesService.class);
    }

    public DialogService getDialogService() {
        return SingletonFactory.getInstance(DialogService.class);
    }

    public <TPage extends NavigatableStdPage> TPage goTo(Class<TPage> pageOf)  throws IOException
    {
        var page = SingletonFactory.getInstance(pageOf);
        page.open();

        return page;
    }

    public <TPage extends StdPage> TPage create(Class<TPage> pageOf)
    {
        return SingletonFactory.getInstance(pageOf);
    }

    @Override
    public void close() throws Exception {
        if (disposed)
        {
            return;
        }

        LoggingSingletonDriver.getInstance().quit();

        disposed = true;
    }
}
