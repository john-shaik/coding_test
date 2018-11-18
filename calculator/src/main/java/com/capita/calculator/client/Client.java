package com.capita.calculator.client;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.capita.calculator.Calculator;
import com.capita.calculator.CalculatorImpl;
import com.capita.calculator.exception.InvalidExpression;

public class Client {
	
	public static void main(String args[]) {
		Client client = new Client();
		client.testCalculator();	
	}

	private void testCalculator() {
		Scanner sc = new  Scanner(System.in);
		System.out.println("Enter number of test cases"); 
		
		int numberOfTests = sc.nextInt();
		
		System.out.println("Enter ALL tests ..  "); 
		
		DecimalFormat dtime = new DecimalFormat("#.##"); 
		
		Calculator cal = new CalculatorImpl();
		for(int i = 0; i < numberOfTests; i++) {
			String expression = sc.next();
			cal.setExpression(expression);
			try {
				double value = cal.calculate();
				System.out.println("Case #" + i + ": " + dtime.format(value));
			} catch(InvalidExpression ex) {
				System.out.println("Case #" + i + ": INVALID EXPRESSION");
			}
		}
		sc.close();	
	}
 
}
