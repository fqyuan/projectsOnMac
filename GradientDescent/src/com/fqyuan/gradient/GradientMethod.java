package com.fqyuan.gradient;

import java.util.List;

interface GradientMethod<T extends Number> {
	List<T> optimize(AbstractMathFunction<T> func, List<Double> args, double lambda);

	boolean isStopCondition();
}