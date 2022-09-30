/*
* Authors: Deepit Chandgothia
* Project: Artificial Life Simulation
*/

public class Defector extends Organism {

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