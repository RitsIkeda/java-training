package jpl.ch24.ex01;

import java.util.ListResourceBundle;

public class EngListBundle extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return contents;
	}

	private static final Object[][]contents = {
			{GreetingKeys.HELLO, "Hi!"},
			{GreetingKeys.GOODBYE, "See You!"},
			{GreetingKeys.GOODNIGHT, "Sleep tight."}
	};

}
