package com.florianingerl.math.termcalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TermReaderTest {

	@Test
	public void readSumTest() {
		TermParser reader = new TermParser();
		Term t = reader.parse("5+8");
		assertEquals(13, t.calculate());

		t = reader.parse("4+6+8");
		assertEquals(18, t.calculate());

		t = reader.parse("5+6+7+7");
		assertEquals(25, t.calculate());
	}

}
