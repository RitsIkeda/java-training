package jpl.ch24.ex01;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class GlobalHelloTest {

	@Test
	public void testJap() {
		System.out.println();
		String greet;
		greet = GlobalHello.getGreet(JapResourceBundle.class.getName(),GreetingKeys.HELLO);
		assertEquals("こんにちは", greet);

		System.out.println(greet);

		greet = GlobalHello.getGreet(JapResourceBundle.class.getName(),GreetingKeys.GOODBYE);
		assertEquals("さようなら", greet);
		System.out.println(greet);

		greet = GlobalHello.getGreet(JapResourceBundle.class.getName(),GreetingKeys.GOODNIGHT);
		assertEquals("おやすみなさい", greet);
		System.out.println(greet);

	}

	@Test
	public void testEng() {
		System.out.println();
		String greet;
		greet = GlobalHello.getGreet(EngListBundle.class.getName(),GreetingKeys.HELLO);
		assertEquals("Hi!", greet);
		System.out.println(greet);

		greet = GlobalHello.getGreet(EngListBundle.class.getName(),GreetingKeys.GOODBYE);
		assertEquals("See You!", greet);
		System.out.println(greet);

		greet = GlobalHello.getGreet(EngListBundle.class.getName(),GreetingKeys.GOODNIGHT);
		assertEquals("Sleep tight.", greet);
		System.out.println(greet);
	}

	@Test
	public void testChina() throws IOException {
		System.out.println();
		FileOutputStream  file = new FileOutputStream ("MyItallyBundle.properties");
		OutputStreamWriter filewriter = new OutputStreamWriter(file);
		filewriter.write(
				GreetingKeys.HELLO + " = Buonasera\n" +
				GreetingKeys.GOODBYE + " = Addio\n" +
				GreetingKeys.GOODNIGHT +" = Buonanotte\n"
				);
		filewriter.close();

		String greet;
		greet = GlobalHello.getGreet("MyItallyBundle",GreetingKeys.HELLO);
		assertEquals("Buonasera", greet);
		System.out.println(greet);
		greet = GlobalHello.getGreet("MyItallyBundle",GreetingKeys.GOODBYE);
		assertEquals("Addio", greet);
		System.out.println(greet);
		greet = GlobalHello.getGreet("MyItallyBundle",GreetingKeys.GOODNIGHT);
		assertEquals("Buonanotte", greet);
		System.out.println(greet);

		new File("MyChinaBundle.properties").delete();
	}

}
