package com.florianingerl.math.termcalculator;

import java.util.List;
import java.util.stream.Collectors;

public class Sum extends Term {

	private List<Term> summands;

	public Sum(List<Term> summands) {
		super();
		this.summands = summands;
	}

	@Override
	public int calculate() {
		return summands.stream().collect(Collectors.summingInt((Term t) -> {
			return t.calculate();
		}));
	}

}
