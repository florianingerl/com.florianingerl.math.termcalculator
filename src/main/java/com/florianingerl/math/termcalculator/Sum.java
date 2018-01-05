package com.florianingerl.math.termcalculator;

import java.util.List;
import java.util.stream.Collectors;

public class Sum extends Term {

	private Term summand1;
	private Term summand2;

	public Sum(Term summand1, Term summand2) {
		super();
		this.summand1 = summand1;
		this.summand2 = summand2;
	}

	@Override
	public int calculate() {
		return summand1.calculate() + summand2.calculate();
	}

}
