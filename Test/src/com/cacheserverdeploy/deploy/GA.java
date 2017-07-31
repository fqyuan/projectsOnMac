package com.cacheserverdeploy.deploy;

public class GA {
	private static final double uniformRate = 0.5;
	private static final double mutationRate = 0.015;
	private static final int tournamentSize = 5;
	private static final boolean elitism = true;
	public static Location bestLocation;

	// Evolve a populatin
	public static Population evolvePopulation(Population pop, int netSize, MCFF mc) {
		Population newPopulation = new Population(pop.size(), netSize, false);
		// Keep our best individual
		int elitismOffset = 0;
		if (elitism) {
			newPopulation.saveLocation(0, pop.getFittest(mc));
			bestLocation = pop.getFittest(mc);
			elitismOffset = 1;
		}

		/*
		 * CrossOver population: Loop over popution's size and create
		 * individuals from current population
		 */
		for (int i = elitismOffset; i < newPopulation.size(); i++) {
			// Select parents:
			Location parent1 = tournamentSelection(pop, netSize, mc);
			Location parent2 = tournamentSelection(pop, netSize, mc);
			// Crossover parents
			Location child = crossover(parent1, parent2, netSize);
			// Add child to the new population
			newPopulation.saveLocation(i, child);
		}
		// Mutate population
		for (int i = elitismOffset; i < newPopulation.size(); i++) {
			mutate(newPopulation.getLocation(i));
		}

		return newPopulation;
	}

	// Applies crossover to a set of parents and creates offspring
	public static Location crossover(Location parent1, Location parent2, int netSize) {
		// Create new child location
		Location child = new Location(netSize);

		// Loop through genes:
		for (int i = 0; i < parent1.size(); i++) {
			// Crossover
			if (Math.random() <= uniformRate) {
				child.setGene(i, parent1.getGene(i));
			} else
				child.setGene(i, parent2.getGene(i));
		}
		return child;
	}

	// Mutate an location
	private static void mutate(Location loc) {
		// Loop through genes:
		for (int i = 0; i < loc.size(); i++) {
			if (Math.random() <= mutationRate) {
				// Create random gene
				byte gene = (byte) Math.round(Math.random());
				loc.setGene(i, gene);
			}
		}
	}

	// Select candidates location for crossover
	private static Location tournamentSelection(Population pop, int netSize, MCFF mc) {
		// Create a tournament population
		// For each place in the tournament get a random candidate location and
		// add it
		// Population tournament = new Population(tournamentSize, netSize,
		// false);
		// for (int i = 0; i < tournamentSize; i++) {
		// int randomId = (int) (Math.random() * pop.size());
		// tournament.saveLocation(i, pop.getLocation(randomId));
		// }
		// Location bestLocation = tournament.getFittest(mc);
		// return bestLocation;
		double curBest = 0;
		Location location = new Location(netSize);
		for (int i = 0; i < tournamentSize; i++) {

			int randomId = (int) (Math.random() * pop.size());
			double curFitness = pop.getPopFitness()[randomId];
			if (curFitness > curBest) {
				location = pop.getLocation(randomId);
				curBest = curFitness;
			}
		}
		return location;
	}
}