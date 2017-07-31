package com.fqyuan.gradient;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		DoubleFunction df = new DoubleFunction();
		List<Double> variables = new ArrayList<>();
		variables.add(0.8);
		variables.add(1.1);
		double lambda = 0.0001;
		System.out.print((new Grad()).optimize(df, variables, lambda));
	}
}
