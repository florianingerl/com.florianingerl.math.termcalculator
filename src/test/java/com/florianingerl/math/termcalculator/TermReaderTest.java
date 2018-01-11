package com.florianingerl.math.termcalculator;

import static org.junit.Assert.*;

import org.jscience.mathematics.number.Rational;
import org.junit.Test;

public class TermReaderTest {

	@Test
	public void readSumTest() {
		TermParser reader = new TermParser();
		Term t = reader.parse("5+8");
		assertEquals(Rational.valueOf(13,1), t.calculate());

		t = reader.parse("4+6+8");
		assertEquals(Rational.valueOf(18,1), t.calculate());

		t = reader.parse("5+6+7+7");
		assertEquals(Rational.valueOf(25,1), t.calculate());
	}
	
	@Test
	public void parseMixedTerms() {
		TermParser reader = new TermParser();
		Term t = reader.parse("5+4*2");
		assertEquals(Rational.valueOf(13,1), t.calculate());

		t = reader.parse("5+(-3)*2");
		assertEquals(Rational.valueOf(-1,1), t.calculate());

		t = reader.parse("5+(-3*2)");
		assertEquals(Rational.valueOf(-1,1), t.calculate());
		
		t = reader.parse("6+(-(6+7))");
		assertEquals(Rational.valueOf(-7,1), t.calculate() );
		
		t = reader.parse("5-(-3)");
		assertEquals(Rational.valueOf(8,1), t.calculate() );
		
		t = reader.parse("5-(-3)+6");
		assertEquals(Rational.valueOf(14,1), t.calculate() );
		
		t = reader.parse("(-(3-2))-8");
		assertEquals(Rational.valueOf(-9,1), t.calculate() );
		
		t = reader.parse("6-(5-7)");
		assertEquals(Rational.valueOf(8,1), t.calculate() );
		
		t = reader.parse("8/1");
		assertEquals(Rational.valueOf(8,1), t.calculate() );
		
		t = reader.parse("8:1");
		assertEquals(Rational.valueOf(8,1), t.calculate() );
		
		t = reader.parse("8:(-1)");
		assertEquals(Rational.valueOf(-8,1), t.calculate() );
		
		t = reader.parse("(-8):(-1)");
		assertEquals(Rational.valueOf(8,1), t.calculate() );
	
		t = reader.parse("8:4+2");
		assertEquals(Rational.valueOf(4,1), t.calculate() );
		
		t = reader.parse("8:(-4)+2+1:(3+5)");
		assertEquals(Rational.valueOf(1,8), t.calculate() );
	}

}
