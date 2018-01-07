package com.florianingerl.math.termcalculator;

public class MultiplicativeInverse extends Term {

	private Term term;
	
	public MultiplicativeInverse(Term term) {
		this.term = term;
	}
	
	@Override
	public int calculate() {
		return 1/ term.calculate();
	}

}
