package com.florianingerl.math.termcalculator;

import org.jscience.mathematics.number.Rational;

public class Quotient extends Term {

	private Term dividend;
	private Term divisor;
	
	
	
	public Quotient(Term dividend, Term divisor) {
		super();
		this.dividend = dividend;
		this.divisor = divisor;
	}



	@Override
	public Rational calculate() {
		return dividend.calculate().divide(divisor.calculate());
	}

}
