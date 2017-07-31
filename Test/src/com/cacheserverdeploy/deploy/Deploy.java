package com.cacheserverdeploy.deploy;

import java.util.ArrayList;

public class Deploy {
	public static String[] deployServer(String[] graphContent) {
		/*
		 * Test codes are lying here:
		 */
		final int IterTime = 200;
		final int populationSize = 250;
		long startTime = System.currentTimeMillis();
		long timeOut = 85000;
		/*
		 * 
		 */
		String[] content = new String[graphContent.length];
		Graph graph = new Graph(graphContent);
		MCFF mc = new MCFF(graph);
		int netSize = graph.getNetNodeNum();
		Population myPop = new Population(populationSize, netSize, true);
		// myPop = GA.evolvePopulation(myPop, netSize, mc);
		// double curCost = 0;
		// double minCost = 0;
		// int dupCnt = 0;
		// minCost = (int) (1 / myPop.getFittest(mc).getFitness());
		for (int i = 0; i < IterTime; i++) {
			// mc = new MCFF(new Graph(graphContent));
			long iterStart = System.currentTimeMillis();
			// curCost = (int) (1 / myPop.getFittest(mc).getFitness());
			myPop = GA.evolvePopulation(myPop, netSize, mc);
			// System.out.println("Iteration " + i + " " + curCost);
			// if (minCost > curCost)
			// minCost = curCost;
			// if (curCost == minCost)
			// dupCnt++;
			// else
			// dupCnt = 0;
			long iterEnd = System.currentTimeMillis();
			long timePerIter = iterEnd - iterStart;
			if (System.currentTimeMillis() - startTime + timePerIter > timeOut)
				break;
		}

		// Get the best routes:
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < netSize; i++) {
			if (GA.bestLocation.getGene(i) == 1)
				al.add(i);
		}
		System.out.println(al);
		mc.getResult(al);

		content = mc.getContent(al);
		// for (String str : content)
		// System.out.println(str);
		return content;
	}
}
