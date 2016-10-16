package com.sabre.api.sacs.configuration;


import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.util.Properties;

/**
 * Class reading REST config.
 */
public class SacsConfiguration extends AppCompatActivity {
    /*
        The below code is a quick and dirty solution to read the configuration file (authentication, etc.)
        We highly encourage, such information is not being kept in the application package for safety reasons.
    */
    //public static Properties restConfig = new Properties();

    public static Properties restConfig = new Properties();

	private ConfigurationDecoder decoder = new PasswordProtectedConfigurationDecoder();

	private ConfigReader configReader = new HttpConfigReader();

	private static SacsConfiguration instance;


    /**
	 * Initializes configuration objects with values read from the properties files.
	 * @throws IOException when could not read properties
	 */
	private SacsConfiguration() throws IOException {
        //restConfig = configReader.getConfig();
    }

	public static SacsConfiguration getInstance() {
		if (instance == null) {
			try {
				instance = new SacsConfiguration();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	/**
	 * Returns a value for the REST configuration key.
	 * @param key key.
	 * @return value stored under given key.
	 */
	public String getRestProperty(String key) {
		return restConfig.getProperty(key);
	}
	
    /**
     * Returns a decoded value for the REST configuration key.
     * @param key key.
     * @return value stored under given key.
     */
	public String getEncodedRestProperty(String key) {
		return decoder.decode(restConfig.getProperty(key));
	}

}
