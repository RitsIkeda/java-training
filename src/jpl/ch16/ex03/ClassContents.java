package jpl.ch16.ex03;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class ClassContents {

	public static void main(String args[]) {
		String[] strs = {"java.awt.Color"};
		mainMethod(strs);
	}

	private static ArrayList<String> printedStrs;

	public static void mainMethod(String args[]) {
		printedStrs = new ArrayList<String>();
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printMembers(c.getFields());
			printMembers(c.getConstructors());
			printMembers(c.getMethods());
			printMembers(c.getClasses());
		} catch (ClassNotFoundException e) {
			System.out.println("unkown class " + args[0] );
		}
		printedStrs.clear();
	}

	private static boolean previouslyCovered (String str) {
		for( String comparison: printedStrs) {
			if (str.equals(comparison)) {
				return true;
			}
		}
		return false;
	}

	private static void printMembers(Class<?>[] classes) {
		for(Class<?> c : classes) {
			String decl = c.toString();
			if(previouslyCovered(decl)) {
				return;
			}
			printedStrs.add(decl);


			System.out.print(" ");
			System.out.println( strip(decl, "java.lang"));
		}
	}

	private static void printMembers(Member[] mems) {
		for(Member m : mems) {
			if(m.getDeclaringClass() == Object.class) {
				continue;
			}
			String decl = m.toString();
			if(previouslyCovered(decl)) {
				return;
			}
			System.out.print(" ");
			System.out.println( strip(decl, "java.lang"));
		}
	}

	private static String strip(String target, String part ) {
		return target.replaceAll(part,  "");
	}


}
