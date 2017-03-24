package jpl.ch15.ex04;

import java.lang.annotation.Annotation;



public class OutAnnotation {


	public static void main(String[] args) {
		OutAnnotation test = new OutAnnotation();
		test.outAnnotation("jpl.ch15.ex04.SampleAnnotation");
	}

	public void outAnnotation(String name) {
		Class<?> c;
		try {
			c = Class.forName(name);
			Annotation[] annotations =  c.getAnnotations();

			for(Annotation annotation : annotations ){
				System.out.println(annotation);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


}
