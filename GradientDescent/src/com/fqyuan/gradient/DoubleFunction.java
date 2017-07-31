package com.fqyuan.gradient;

import java.util.List;

public class DoubleFunction implements AbstractMathFunction<Double> {

	public Double f(List<Double> args) {
		Double x = args.get(0);
		Double y = args.get(1);
		return Math.sin(x) * Math.cos(y);
	}
}