package br.com.email.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {

	private static Properties props;
	
	public static Properties getProperties() throws IOException {
		if (props==null){
			props = new Properties();
			props.load(new FileInputStream("src/main/resources/email.properties"));
		}
		return props;

	}
}
