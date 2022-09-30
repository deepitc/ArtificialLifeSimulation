public class Defector extends Organism {
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

	/**
	 * returns new defector
	 */
	public Organism reproduce() {
		reproduce_energy();
		return new Defector();
	}

	/**
	 * returns type
	 */
	public String getType() {
		return "Defector";
	}

	/**
	 * returns cooperation probability
	 */
	public double getCooperationProbability() {
		return 0;
	}

	public boolean cooperates() {
		return false;
	}

}