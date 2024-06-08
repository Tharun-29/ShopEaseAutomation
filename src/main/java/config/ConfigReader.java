package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	 public Properties properties;

	    public ConfigReader() {
	        properties = new Properties();
	        try {
	            FileInputStream fis = new FileInputStream("src/main/java/Resources/GlobalData.properties");
	            properties.load(fis);
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Unable to load properties file: " + e.getMessage());
	        }
	    }

	    public String getProperty(String key) {
	        return properties.getProperty(key);
	    }
}
