package com.florianingerl.math.termcalculator;

import java.util.List;

public class Product extends Term {

	private List<Term> factors;

	public Product(List<Term> factors) {
		super();
		this.factors = factors;
	}

	@Override
	public int calculate() {
		int result = 1;
		for (Term factor : factors)
			result *= factor.calculate();
		return result;
	}

}
