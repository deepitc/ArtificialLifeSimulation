/*
* Authors: Deepit Chandgothia
* Project: Artificial Life Simulation
*/

public class Cooperator extends Organism {

	public Organism reproduce() {
		reproduce_energy();
		return new Cooperator();
	}

	/**
	 * returns type
	 */

	public String getType() {
		return "Cooperator";
	}

	/**
	 * returns cooperation probabibility
	 */

	public double getCooperationProbability() {
		return 1;
	}

	public boolean cooperates() {
		return true;
	}

}