package com.florianingerl.math.termcalculator;

import org.jscience.mathematics.number.Rational;

public class Product extends Term {

	private Term factor1;
	private Term factor2;

	public Product(Term factor1, Term factor2) {
		super();
		this.factor1 = factor1;
		this.factor2 = factor2;
	}

	@Override
	public Rational calculate() {
		Rational product = Rational.valueOf(1, 1);
		product = product.times(factor1.calculate());
		return product.times(factor2.calculate() );
	}

}
