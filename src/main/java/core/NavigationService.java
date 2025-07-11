/*
 * Author: Susan Hudson
 */


package core;

import java.io.IOException;

public interface NavigationService  {
    void goToUrl(String url) throws IOException;
    String getUrl() throws IOException;
}
