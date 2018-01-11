package com.florianingerl.math.termcalculator;

import org.jscience.mathematics.number.Rational;

public class Number extends Term {

	private int i;

	public Number(int i) {

		this.i = i;
	}

	@Override
	public Rational calculate() {
		return Rational.valueOf(i,1);
	}

}
