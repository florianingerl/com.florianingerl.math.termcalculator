package com.florianingerl.math.termcalculator;

public class Inverse extends Term {

	private Term term;
	
	public Inverse(Term term) {
		this.term = term;
	}
	@Override
	public int calculate() {
		return (-1) * term.calculate();
	}

}
