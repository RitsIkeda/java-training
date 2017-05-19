package jpl.ch24.ex01;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class JapResourceBundle extends ResourceBundle {

	@Override
	public Enumeration<String> getKeys() {
		LinkedList<String> result = new LinkedList<String>();
		result.add("こんにちは");
		result.add("さようなら");
		result.add("おやすみなさい");
		return  Collections.enumeration(result);
	}

	@Override
	protected Object handleGetObject(String str) {
		if(str.equals(GreetingKeys.HELLO)) {
			return "こんにちは";
		} else if(str.equals(GreetingKeys.GOODBYE)) {
			return "さようなら";
		} else if(str.equals(GreetingKeys.GOODNIGHT)) {
			return "おやすみなさい";
		}
		return null;
	}
}
