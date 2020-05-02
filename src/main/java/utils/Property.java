package utils;

import aquality.selenium.core.logging.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {
    private String fileName;
    private Properties property = new Properties();

    public Property(String fileName) {
        this.fileName = fileName;
    }

    public String getPropertyValue(String propertyName) {

        try (InputStream fis = Property.class.getResourceAsStream(fileName)) {
            property.load(fis);
        } catch (IOException e) {
            Logger.getInstance().error(String.format("Can't load the file: %s", e));
        }

        return property.getProperty(propertyName);
    }
}