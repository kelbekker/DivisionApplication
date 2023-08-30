package com.foxminded.division.formatters;

import com.foxminded.division.processors.DivisionStep;
import com.foxminded.division.processors.LongDivisionProcessor;

public class LongDivisionFormatter implements DivisionFormatter {

	private LongDivisionProcessor processor;

	public LongDivisionFormatter(LongDivisionProcessor processor) {
		this.processor = processor;
	}

	public String takeFormattedDivisionResult(Integer dividend, Integer divider) {

		if (dividend < divider) {
			throw new IllegalArgumentException("The divider is greater than the dividend");
		}

		if (divider < 0) {
			throw new IllegalArgumentException("The numbers should be positive");
		}

		if (divider == 0 || dividend == 0) {
			throw new IllegalArgumentException("Input cannot be null");
		}

		StringBuilder formattedString = new StringBuilder();

		int quotient = dividend / divider;
		formattedString.append("_" + dividend + "|" + divider + "\n"
		+ indent(Integer.toString(dividend).length() + 1)
				+ "|" + quotient + "\n" + indent(1));

		int i = 1;
		for (DivisionStep divisionSteps : processor.divide(dividend, divider)) {

			formattedString.append(divisionSteps.getDividend() + "\n" + indent(i) + divisionSteps.getQuotient() + "\n"
					+ indent(i) + "----\n");
			i++;
			formattedString.append(indent(i) + divisionSteps.getRemainder());
		}

		return formattedString.toString();
	}

	public static String indent(int count) {
		return " ".repeat(count);
	}
}
