package com.florianingerl.math.termcalculator;

import java.util.List;

public class Product extends Term {

	private Term factor1;
	private Term factor2;

	public Product(Term factor1, Term factor2) {
		super();
		this.factor1 = factor1;
		this.factor2 = factor2;
	}

	@Override
	public int calculate() {
		return factor1.calculate() * factor2.calculate();
	}

}
