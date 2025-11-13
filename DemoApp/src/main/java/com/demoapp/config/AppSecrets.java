package com.demoapp.config;

import java.util.Locale;
import java.util.ResourceBundle;

public class AppSecrets {
	public static Locale setLocale(String lang, String country) {
//		Locale locale = new Locale(lang, country);
		Locale locale = Locale.of(lang, country);
		return locale;
	}
	
	public static String getSecretData(String key, String lang, String country) {
		ResourceBundle rb = ResourceBundle.getBundle("appData", setLocale(lang, country));
		return rb.getString(key);
	}
	
	
}
