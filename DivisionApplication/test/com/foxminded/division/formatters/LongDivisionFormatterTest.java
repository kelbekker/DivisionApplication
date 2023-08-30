package com.foxminded.division.formatters;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.foxminded.division.processors.DivisionStep;
import com.foxminded.division.processors.LongDivisionProcessor;

@ExtendWith(MockitoExtension.class)
class LongDivisionFormatterTest {

	@Mock
	LongDivisionProcessor processorMock;
	LongDivisionFormatter formatterTest;

	@BeforeEach
	public void setUp() {
		formatterTest = new LongDivisionFormatter(processorMock);
	}

	@Test
	void takeFormattedDivisionResultWhenDividerIsGreaterThanDividendShouldBeExceptionMassageResult() {

		assertThrows(IllegalArgumentException.class, () -> formatterTest.takeFormattedDivisionResult(12, 13),
				"The divider is greater than the dividend");
	}

	@Test
	void takeFormattedDivisionResultWhenDividerIsNegativeShouldBeExceptionMassageResult() {

		assertThrows(IllegalArgumentException.class, () -> formatterTest.takeFormattedDivisionResult(10, -2));

	}

	@Test
	void takeFormattedDivisionResultWhenNullInputShouldBeExceptionMassageResult() {

		assertThrows(IllegalArgumentException.class, () -> formatterTest.takeFormattedDivisionResult(0, 2),
				"Input cannot be null");

	}

	@Test
	void takeFormattedDivisionResultWhenNormalNumbersShouldBeLondDivision() throws NumberFormatException, IOException {
		Integer dividend = 1234;
		Integer divider = 23;

		StringBuilder expectedOutput = new StringBuilder();
		expectedOutput.append(String.format("_1234|23\n     |53\n 3\n 23\n ----\n  04\n  23\n  ----\n   11"));

		List<DivisionStep> divisionSteps = new ArrayList<>();

		DivisionStep step1 = new DivisionStep();
		step1.setDividend(3);
		step1.setDivider(23);
		step1.setQuotient(23);
		step1.setRemainder(0);
		divisionSteps.add(step1);

		DivisionStep step2 = new DivisionStep();
		step2.setDividend(4);
		step2.setDivider(23);
		step2.setQuotient(23);
		step2.setRemainder(11);
		divisionSteps.add(step2);

		when(processorMock.divide(dividend, divider)).thenReturn(divisionSteps);

		String actualOutput = formatterTest.takeFormattedDivisionResult(dividend, divider);

		assertEquals(expectedOutput.toString(), actualOutput);
		verify(processorMock).divide(dividend, divider);
	}
}