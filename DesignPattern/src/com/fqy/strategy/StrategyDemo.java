package com.fqy.strategy;

public class StrategyDemo {
	public static void clientCode(Strategy stra) {
		stra.solve();

	}

	public static void main(String[] args) {
		Strategy[] algorithms = { new Impl1(), new Impl2() };
		for (int i = 0; i < algorithms.length; i++)
			clientCode(algorithms[i]);
	}

}
