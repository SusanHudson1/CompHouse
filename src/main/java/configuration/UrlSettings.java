/*
 * Author: Susan Hudson
 */

package configuration;

public class UrlSettings {
    private String loginUrl;

    public String getLoginUrl() {
        return loginUrl;
    }


    @Override
    public String toString() {
        return "UrlSettings{" +
                "loginUrl='" + loginUrl + '\'' +
                '}';
    }
}
