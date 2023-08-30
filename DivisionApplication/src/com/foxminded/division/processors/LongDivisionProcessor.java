package com.foxminded.division.processors;

import java.util.ArrayList;
import java.util.List;

public class LongDivisionProcessor {

	public List<DivisionStep> divide(Integer dividend, Integer divider) {

		ArrayList<DivisionStep> steps = new ArrayList<>();

		int[] dividendArray = new int[Integer.toString(dividend).length()];

		for (int i = dividendArray.length - 1; i >= 0; i--) {
			dividendArray[i] = dividend % 10;
			dividend /= 10;
		}
		for (int i = 0; i < dividendArray.length; i++) {
			DivisionStep step = new DivisionStep();
			step.setDividend(dividend);
			step.setDivider(divider);

			if (i == 0) {
				step.setDividend(dividendArray[i]);
			} else {
				step.setDividend((dividendArray[i - 1] % step.getDivider()) * 10 + dividendArray[i]);
			}
			if (step.getDividend() >= step.getDivider()) {
				step.setQuotient((step.getDividend() / step.getDivider()) * step.getDivider());
				step.setRemainder(step.getDividend() % step.getDivider());
				step.setDividend(dividendArray[i]);
				steps.add(step);
			}
		}
		return steps;
	}
}
