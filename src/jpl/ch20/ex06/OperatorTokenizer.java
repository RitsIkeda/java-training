package jpl.ch20.ex06;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.HashMap;

public class OperatorTokenizer {

	HashMap<String,Double> values = new HashMap<String,Double>();

	public static void main(String[] args) throws IOException {

		OperatorTokenizer tokenizer = new OperatorTokenizer();
		tokenizer.setWord("one");
		tokenizer.setWord("othrer");
		tokenizer.setWord("anothrer");

		String doc = "one=0" +
				 "othrer=1" +
				 "anothrer=2" +
				 "one+1" +
				 "othrer+2" +
				 "anothrer+3" +
				 "one-4" +
				 "othrer-5" +
				 "anothrer-6";
		StringReader reader = new StringReader(doc);
		tokenizer.operatorTokenize(reader);
		tokenizer.outValues();


	}
	public OperatorTokenizer(){
	}

	void setWord(String name) {
		values.put(name, 0.0);
	}

	 public void operatorTokenize(Reader src) throws IOException {
		StreamTokenizer in = new StreamTokenizer(src);
		in.ordinaryChar('+');
		in.ordinaryChar('-');
		in.ordinaryChar('=');

		String name = "";
		char operator = '?';
		Double value;
		while(in.nextToken() != StreamTokenizer.TT_EOF) {
			switch (in.ttype) {
			case StreamTokenizer.TT_WORD:
				name = in.sval;
				break;

			case '+':
			case '-':
			case '=':
				operator = (char) in.ttype;
				break;

			case StreamTokenizer.TT_NUMBER:
				value = new Double(in.nval);
				calclation(name,operator,value);
				break;

			default:
				throw new RuntimeException();
			}

		}
	 }

	 public void outValues() {

		for( Object keyObj: values.keySet()) {
			String key = (String) keyObj;
			System.out.println("name:" + key + " value:" + values.get(key));
		}
	 }

	private void calclation(String name, char operator, double value) {

		double result = values.get(name);
		switch (operator) {
		case '+':
			result += value;
			break;

		case '-':
			result -= value;
			break;

		case '=':
			result = value;
			break;

		default:
			throw new RuntimeException();
		}
		values.put(name, result);
	}

}

