/*
 * Authors: Deepit
 * Assignment 5
 * Due: May 14, 2022 
 * Written/Online sources used: Looked up implementation of random 
 * https://docs.microsoft.com/en-us/dotnet/api/system.random?view=net-6.0
 * Help obtained: Evening tutor to implement random
 * I confirm that the above list of sources is 
 * complete AND that I have not talked to anyone else 
 * about the solution to this problem
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