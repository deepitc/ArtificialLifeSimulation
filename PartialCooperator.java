/*
* Authors: Deepit Chandgothia
* Project: Artificial Life Simulation
*/

import java.util.Random;

public class PartialCooperator extends Organism {

	private Random grin = new Random();

	/**
	 * returns new partial cooperator
	 */
	public Organism reproduce() {
		reproduce_energy();
		return new PartialCooperator();
	}

	/**
	 * returns type
	 */
	public String getType() {
		return "PartialCooperator";
	}

	/**
	 * returns cooperation probability
	 */
	public double getCooperationProbability() {
		return 0.5;
	}

	public boolean cooperates() {
		double coop = grin.nextDouble(); // gives a real number between 0 and 1

		if (coop > 0.5)
			return true;
		else
			return false;
	}

}