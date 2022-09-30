/*
* Authors: Deepit Chandgothia
* Project: Artificial Life Simulation
*/

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class Population {

	private ArrayList<Organism> pop = null;
	private int total_pop = 0;
	private Random grin = new Random();

	/**
	 * constructor for population
	 */
	public Population(Map<String, Integer> counts) throws IllegalArgumentException {

		int coop_count = counts.get("Cooperator");
		int defec_count = counts.get("Defector");
		int part_count = counts.get("PartialCooperator");
		total_pop = coop_count + defec_count + part_count;

		pop = new ArrayList<>();

		// add the number of Objects of each subclass
		for (int i = 0; i < coop_count; i++)
			pop.add(new Cooperator());

		for (int i = 0; i < defec_count; i++)
			pop.add(new Defector());

		for (int i = 0; i < part_count; i++)
			pop.add(new PartialCooperator());

	}

	/**
	 * update function to increase energy and if organism cooperates or reproduces
	 */
	public void update() {

		for (Organism org : pop) {
			org.update();

			if (org.cooperates()) {
				org.decrementEnergy();
				for (int i = 0; i < 8; i++) {
					int next_random = grin.nextInt(total_pop);
					pop.get(next_random).update();
				}
			}

			if (org.getEnergy() >= 10) { // check if organism has 10+ energy to be able to reproduce
				Organism child = org.reproduce();
				int replaced_org = grin.nextInt(total_pop);
				pop.set(replaced_org, child);
			}
		}
	}

	/**
	 * 
	 * @return calculated mean cooperation probability
	 */

	public double calculateCooperationMean() {
		double total_probs = 0.0; // variable to save total probs
		for (Organism org : pop) {
			total_probs += org.getCooperationProbability();
		}

		return total_probs / total_pop;
	}

	/**
	 * 
	 * @return total organisms in population
	 */

	public Map<String, Integer> getPopulationCounts() {
		Map<String, Integer> counts = new HashMap<>();
		int coops = 0; // cooperators
		int defecs = 0; // defectors
		int parts = 0; // partials

		for (Organism hello : pop) {
			if (hello.getType().equals("Cooperator"))
				coops++;
			else if (hello.getType().equals("Defector"))
				defecs++;
			else if (hello.getType().equals("PartialCooperator"))
				parts++;
		}

		counts.put("Cooperator", coops);
		counts.put("Defector", defecs);
		counts.put("PartialCooperator", parts);

		return counts;
	}

}