/*
 * Author: Susan Hudson
 */

package configuration;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigurationService {
    private static String environment;

    public static <T> T get(Class<T> configSection) {
        T mappedObject = null;
        if (environment == null) {
            String environmentOverride = System.getProperty("environment");
            if (environmentOverride == null) {
                InputStream input = ConfigurationService.class.getResourceAsStream("app.properties");
                var p = new Properties();
                try {
                    p.load(input);
                } catch (IOException e) {
                    return mappedObject;
                }

                environment = p.getProperty("environment");
            }
           else {
                environment = environmentOverride;
            }
        }

        String fileName = String.format("testFrameworkSettings.%s.json", environment);
        String jsonFileContent = getFileAsString(fileName);
        String sectionName = getSectionName(configSection);

        var jsonObject = JsonParser.parseString(jsonFileContent).getAsJsonObject().get(sectionName).toString();

        var gson = new Gson();

        try {
            mappedObject= gson.fromJson(jsonObject, configSection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mappedObject;
    }

    public static String getSectionName(Class<?> configSection) {
        var sb = new StringBuilder(configSection.getSimpleName());
        sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
        return sb.toString();
    }

    public static String getFileAsString(String fileName) {
        try {
            InputStream input = ConfigurationService.class.getResourceAsStream(fileName);
            return IOUtils.toString(input, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return null;
        }
    }
}
