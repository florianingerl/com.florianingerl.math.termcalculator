package com.florianingerl.math.termcalculator;

import org.jscience.mathematics.number.Rational;

public class Inverse extends Term {

	private Term term;
	
	public Inverse(Term term) {
		this.term = term;
	}
	@Override
	public Rational calculate() {
		return term.calculate().times(-1);
	}

}
