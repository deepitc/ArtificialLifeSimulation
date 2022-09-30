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