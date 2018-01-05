package com.florianingerl.math.termcalculator;

public class Number extends Term {

	private int i;

	public Number(int i) {

		this.i = i;
	}

	@Override
	public int calculate() {
		return i;
	}

}
