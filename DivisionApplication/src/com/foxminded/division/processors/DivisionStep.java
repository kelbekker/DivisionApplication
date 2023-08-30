package com.foxminded.division.processors;

public class DivisionStep {
	Integer dividend;
	Integer divider;
	int quotient;
	int remainder;

	public Integer getDividend() {
		return this.dividend;
	}

	public Integer getDivider() {
		return this.divider;
	}

	public int getQuotient() {
		return quotient;
	}

	public void setQuotient(int quotient) {
		this.quotient = quotient;
	}

	public int getRemainder() {
		return remainder;
	}

	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}

	public void setDividend(int dividend) {
		this.dividend = dividend;
	}

	public void setDivider(int divider) {
		this.divider = divider;
	}
}