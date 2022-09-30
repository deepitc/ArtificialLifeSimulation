/*
* Authors: Deepit Chandgothia
* Project: Artificial Life Simulation
*/

public abstract class Organism {

	int energy;
	String type;
	double coopProb;

	protected Organism() {
		energy = 0;
	}

	/**
	 * increases energy
	 */
	public void incrementEnergy() {
		energy++;
	}

	/**
	 * decreases energy by 1
	 */
	public void decrementEnergy() {
		if (energy > 0)
			energy--;
	}

	/**
	 * reduces energy for reproduction
	 */
	public void reproduce_energy() {
		for (int i = 0; i < 10; i++)
			decrementEnergy();
	}

	/**
	 * increases energy
	 */
	public void update() {
		incrementEnergy();
	}

	/**
	 * returns energy count
	 */
	public int getEnergy() {
		return energy;
	}

	abstract Organism reproduce();

	abstract String getType();

	abstract double getCooperationProbability();

	abstract boolean cooperates();

}