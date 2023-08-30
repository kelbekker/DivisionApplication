package com.foxminded.division.processors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LongDivisionProcessorTest {

	private LongDivisionProcessor processorsTest;

	@BeforeEach
	void setUp() {
		processorsTest = new LongDivisionProcessor();
	}

	@Test
	void longDivisionProcessorWhenNormalNumbersShouldBeLondDivision() {
		processorsTest.divide(321, 2);
		assertEquals(2, processorsTest.divide(321, 2).size());
		assertEquals(2, processorsTest.divide(321, 2).get(0).getQuotient());
		assertEquals(1, processorsTest.divide(321, 2).get(0).getRemainder());
		assertEquals(12, processorsTest.divide(321, 2).get(1).getQuotient());
		assertEquals(0, processorsTest.divide(321, 2).get(1).getRemainder());
	}

}
