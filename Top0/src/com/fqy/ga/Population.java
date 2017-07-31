package com.fqy.ga;

import com.fqy.cdn.MCFF;

public class Population {
	private Location[] locations;
	private double popFitness[];

	public Population(int populationSize, int netSize, boolean initialise) {
		locations = new Location[populationSize];
		popFitness = new double[populationSize];
		// Initialize
		if (initialise) {
			// Loop and create new individuals
			for (int i = 0; i < locations.length; i++) {
				Location newLocation = new Location(netSize);
				newLocation.generateLocation(netSize);
				saveLocation(i, newLocation);
			}
		}
	}

	public Location getFittest(MCFF mc) {
		Location bestLoc = locations[0];
		double bestFitness = bestLoc.getFitness(mc);
		setPopFitness(0, bestFitness);
		for (int i = 1; i < locations.length; i++) {
			double currentFittness = locations[i].getFitness(mc);
			setPopFitness(i, currentFittness);
			if (bestFitness < currentFittness) {
				bestFitness = currentFittness;
				bestLoc = locations[i];
			}
		}

		return bestLoc;
	}

	public void saveLocation(int index, Location location) {
		locations[index] = location;
	}

	public int size() {
		return locations.length;
	}

	public Location getLocation(int index) {
		return locations[index];
	}

	// add 3.22
	public double[] getPopFitness() {
		return popFitness;
	}

	public void setPopFitness(int index, double value) {
		popFitness[index] = value;
	}
}
