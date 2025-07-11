/*
 * Author: Susan Hudson
 */


package core;

import java.io.IOException;

public interface BrowserService {
    void start(Browser browser) throws IOException;
    void quit() throws IOException;
    void waitForAjax() throws IOException ;
    void waitUntilPageLoadsCompletely() throws IOException;
    void back() throws IOException;
}
