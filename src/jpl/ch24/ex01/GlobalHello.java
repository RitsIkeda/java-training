package jpl.ch24.ex01;

import java.util.ResourceBundle;

public class GlobalHello {
	public static String getGreet(String bundle, String key) {
		ResourceBundle res = ResourceBundle.getBundle(bundle);
		return res.getString(key);
	}
}
