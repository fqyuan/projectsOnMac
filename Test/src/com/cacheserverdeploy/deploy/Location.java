package com.cacheserverdeploy.deploy;

import java.util.ArrayList;

/*
 * Store a candidate tour
 */
public class Location {
	// Holds locations of servers
	// private int count;
	private byte[] genes;
	private double fitness;

	public void generateLocation(int count) {
		// genes = new byte[count];
		for (int i = 0; i < count; i++) {
			byte gene = (byte) Math.round(Math.random());
			genes[i] = gene;
		}
	}

	public Location(int netNodeNum) {
		genes = new byte[netNodeNum];
	}

	public double getFitness(MCFF m) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < size(); i++) {
			if (genes[i] == 1)
				al.add(i);
		}
		int curVal = m.getMinCostFlow(al);
		if (curVal == -1)
			curVal = FinalValues.INF;
		fitness = 1.0 / curVal;
		return fitness;
	}

	public int size() {
		return genes.length;
	}

	public void setGene(int index, byte value) {
		genes[index] = value;
		fitness = 0;
	}

	public byte getGene(int index) {
		return genes[index];
	}

	// 3.22
	public double getFitness() {
		return fitness;
	}
}