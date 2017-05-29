package jpl.ch24.ex03;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DateParser {

	public static String[] parseDateStr(String input, Locale locale ) {

		String[] result = new String[4];
		DateFormat[] formats = new DateFormat[4];
		formats[0] = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL, locale);
		formats[1] = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG ,locale);
		formats[2] = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM, locale);
		formats[3] = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT,locale);

		for(int i = 0; i < result.length; i++) {
			try {
				 Date date = formats[i].parse(input);
				 result[i] = formats[i].format(date);
			} catch(ParseException e) {
				//System.out.println("err " + input + e.getMessage());
				//System.out.println(locale.toString());
				result[i] = "failed parce";
			}
		}
		return result;
	}

	public static String[] getLocaleNames() {
		String[] result = new String[Locale.getAvailableLocales().length];
		for(int i = 0; i < result.length; i++) {
			result[i] = Locale.getAvailableLocales()[i].toLanguageTag();
		}
		return result;
	}

}
