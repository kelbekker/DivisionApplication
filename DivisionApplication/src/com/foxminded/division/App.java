package com.foxminded.division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.foxminded.division.formatters.DivisionFormatter;
import com.foxminded.division.formatters.LongDivisionFormatter;
import com.foxminded.division.processors.LongDivisionProcessor;

public class App {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the dividend");
		final Integer dividend = (Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));

		System.out.println("Enter the divider");
		final Integer divider = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		DivisionFormatter formatter = new LongDivisionFormatter(new LongDivisionProcessor());
		System.out.println(formatter.takeFormattedDivisionResult(dividend, divider));
	}

}