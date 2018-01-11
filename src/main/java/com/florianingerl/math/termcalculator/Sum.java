package com.florianingerl.math.termcalculator;

import java.util.List;
import java.util.stream.Collectors;
import org.jscience.mathematics.number.Rational;

public class Sum extends Term {

	private Term summand1;
	private Term summand2;

	public Sum(Term summand1, Term summand2) {
		super();
		this.summand1 = summand1;
		this.summand2 = summand2;
	}

	@Override
	public Rational calculate() {
		Rational sum = Rational.ZERO;
		sum = sum.plus(summand1.calculate() );
		return sum.plus(summand2.calculate() );
	}

}
