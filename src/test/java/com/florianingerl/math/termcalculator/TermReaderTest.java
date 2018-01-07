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
	
	@Test
	public void parseMixedTerms() {
		TermParser reader = new TermParser();
		Term t = reader.parse("5+4*2");
		assertEquals(13, t.calculate());

		t = reader.parse("5+(-3)*2");
		assertEquals(-1, t.calculate());

		t = reader.parse("5+(-3*2)");
		assertEquals(-1, t.calculate());
		
		t = reader.parse("6+(-(6+7))");
		assertEquals(-7, t.calculate() );
		
		t = reader.parse("5-(-3)");
		assertEquals(8, t.calculate() );
		
		t = reader.parse("5-(-3)+6");
		assertEquals(14, t.calculate() );
		
		t = reader.parse("(-(3-2))-8");
		assertEquals(-9, t.calculate() );
		
		t = reader.parse("6-(5-7)");
		assertEquals(8, t.calculate() );
		
		t = reader.parse("8/1");
		assertEquals(8, t.calculate() );
		
		t = reader.parse("8:1");
		assertEquals(8, t.calculate() );
		
		t = reader.parse("8:(-1)");
		assertEquals(-8, t.calculate() );
		
		t = reader.parse("(-8):(-1)");
		assertEquals(8, t.calculate() );
	}

}
