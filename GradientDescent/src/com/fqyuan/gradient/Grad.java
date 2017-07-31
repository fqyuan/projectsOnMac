package com.fqyuan.gradient;

import java.util.ArrayList;
import java.util.List;

public class Grad implements GradientMethod<Double> {
	private final static double EPSILON = 0.001;
	private List<Double> variables;
	private List<Double> nextVariables;

	@Override
	public List<Double> optimize(AbstractMathFunction<Double> func, List<Double> args, double lambda) {
		variables = new ArrayList<>();
		nextVariables = new ArrayList<>(args);
		do {
			variables.clear();
			variables.addAll(nextVariables);
			int i = 0;
			for (Double arg : variables) {
				nextVariables.set(i, arg - lambda * Differentiate.grad(func, variables));
				++i;
			}
		} while (!isStopCondition());
		return nextVariables;
	}

	public boolean isStopCondition() {
		Double max = 0.0;
		for (int i = 0; i < variables.size(); ++i) {
			Double t = Math.abs(variables.get(i) - nextVariables.get(i));
			if (max < t) {
				max = t;
			}
		}
		return max <= EPSILON;
	}
}
