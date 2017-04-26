package jpl.ch22.ex15;

import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Calculator {

	private enum OperandType {
		PLUS,
		MINUS,
		MULTIPLY,
		DIVIDE
	};

	LinkedList<Double> stack = new LinkedList<Double>();
	StringTokenizer formula;

	public Calculator() {

	}

	/* Argment is specifeid as reversePolishNotation */
	public double calculate(String source) throws IOException {
		formula = new StringTokenizer(source);

		while(formula.hasMoreTokens()) {
			String section = formula.nextToken();

			if( isOperand(section)) {
				oeration(section );

			} else {
				double value = Double.parseDouble(section);
				stack.addLast(value);
			}
		}
		double result = stack.removeLast();
		if(stack.isEmpty()) {
			return result;
		} else {
			throw new IllegalArgumentException("Fomula is wrong");
		}
	}
	private boolean isOperand(String section) {
		return section.equals("+") ||
				section.equals("-") ||
				section.equals("*") ||
				section.equals("/") ||
				section.equals("÷");
	}

	private void oeration(String operandStr) {
		 OperandType operand;

		if(operandStr.equals("+")) {
			operand = OperandType.PLUS;
		} else if(operandStr.equals("-")) {
			operand = OperandType.MINUS;
 		} else if(operandStr.equals("*")) {
 			operand = OperandType.MULTIPLY;
 		} else if(operandStr.equals("/") || operandStr.equals("÷")) {
 			operand = OperandType.DIVIDE;
 		}else if(operandStr.equals("=")) {
 			return;
 		} else {
 			throw new IllegalArgumentException("Fomula is wrong");
 		}
 		double v2 = stack.removeLast();
 		double v1 = stack.removeLast();

 		double result = oeration(v1, operand, v2 );
 		stack.addLast(result);

	}
	private double oeration(double v1, OperandType operand, double v2 ){
		switch (operand) {
		case PLUS:
			return v1 + v2;
		case MINUS:
			return v1 - v2;
		case MULTIPLY:
			return v1 * v2;
		case DIVIDE:
			return v1 / v2;
		default:
			throw new IllegalArgumentException("Fomula is wrong");
		}
	}
}
