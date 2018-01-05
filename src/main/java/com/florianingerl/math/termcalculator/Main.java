package com.florianingerl.math.termcalculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please enter a term:");

		Scanner scanner = new Scanner(System.in);

		String term = scanner.nextLine();

		TermParser reader = new TermParser();
		Term t = reader.parse(term);

		System.out.println(term + " = " + t.calculate());
	}

}
