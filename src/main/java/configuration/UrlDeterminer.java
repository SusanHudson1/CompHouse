/*
 * Author: Susan Hudson
 */

package configuration;

import org.apache.hc.core5.net.URIBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class UrlDeterminer {
    public static String getLoginUrl(String urlPart) {
        return contactUrls(ConfigurationService.get(UrlSettings.class).getLoginUrl(), urlPart);
    }


    private static String contactUrls(String url, String part) {
        try {
            var uriBuilder = new URIBuilder(url);
            URI uri = uriBuilder.setPath(uriBuilder.getPath() + part)
                    .build()
                    .normalize();
            return uri.toString();
        }
        catch (URISyntaxException ex) {
            return null;
        }
    }
}
