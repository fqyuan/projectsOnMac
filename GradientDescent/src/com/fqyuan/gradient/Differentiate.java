package com.fqyuan.gradient;

import java.util.ArrayList;
import java.util.List;

public class Differentiate {
	private Differentiate() {
	}

	public static Double grad(AbstractMathFunction<Double> func, List<Double> args) {
		Double sum = 0.0;
		for (int i = 0; i < args.size(); ++i) {
			sum += Math.pow(partialDerivative(func, args, i), 2);
		}
		return Math.sqrt(sum);
	}

	public static Double partialDerivative(AbstractMathFunction<Double> func, List<Double> args, int index) {
		Double dx = 0.001;
		Double variable = args.get(index);
		List<Double> list = new ArrayList<>(args);
		list.set(index, variable + dx);
		return (func.f(list) - func.f(args)) / dx;
	}
}