package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

	public static Properties prop = new Properties();
	public static String projectPath = System.getProperty("user.dir");
	public static String configPath = projectPath + "/src/test/java/config/config.properties";

	public static void main(String[] args) {

		getBaseBrowser();		
		getBaseUrl();
		getProperties("homePageProductLink");

	}
	
	public static String getBaseBrowser() {

		String baseBrowser = null;
		
		try {

			InputStream input = new FileInputStream(configPath);
			prop.load(input);
			baseBrowser = prop.getProperty("baseBrowser");

		} catch(Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
		return baseBrowser;
		
	}
	
	public static String getBaseUrl() {

		String baseUrl = null;
		
		try {

			InputStream input = new FileInputStream(configPath);
			prop.load(input);
			baseUrl = prop.getProperty("baseUrl");

		} catch(Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
		return baseUrl;
		
	}
	
	public static String getProperties(String key) {
		
		String propertyValue = null;
		
		try {

			InputStream input = new FileInputStream(configPath);
			prop.load(input);
			propertyValue = prop.getProperty(key);

		} catch(Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
		
		return propertyValue;
		
	}
	
	public static void setProperties(String key, String value) {

		try {

			OutputStream output = new FileOutputStream(configPath);
			prop.setProperty(key, value);
			prop.store(output, null);

		} catch(Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}

	}


}
