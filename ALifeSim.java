import java.util.HashMap;
import java.util.Map;
import java.lang.NumberFormatException;

/*
 * Authors: Deepit Chandgothia
 * Project: Artificial Life Simulation 
 */

public class ALifeSim {

	/**
	 * Main method
	 * 
	 * @param args : Command line arguments
	 */
	public static void main(String[] args) {

		System.out.println("Welcome to Artificial Life");

		int total_iterations = 0;
		int cooperators = 0;
		int defectors = 0;
		int partials = 0;

		if (args.length != 4) {
			System.out.println("Incorrect command line arguments");
			System.out.println(
					"Command line argument form: java ALifeSim <#/iterations> <#/cooperators> <#/defectors> <#/partial cooperators> ");
			System.exit(0);
		}

		// try catch for exceptions

		try {
			total_iterations = Integer.parseInt(args[0]);
			cooperators = Integer.parseInt(args[1]);
			defectors = Integer.parseInt(args[2]);
			partials = Integer.parseInt(args[3]);

		} catch (NumberFormatException e) {
			System.out.println(
					"Command line argument form: java ALifeSim <#/iterations> <#/cooperators> <#/defectors> <#/partial cooperators> ");
			System.out.println("Values must be integers");
			System.exit(0);

		}

		HashMap<String, Integer> population = new HashMap<>();
		population.put("Cooperator", cooperators);
		population.put("Defector", defectors);
		population.put("PartialCooperator", partials);

		Population temp = new Population(population);

		for (int i = 0; i < total_iterations; i++)
			temp.update();

		Map<String, Integer> new_pop = temp.getPopulationCounts();

		System.out.println("After " + total_iterations + " ticks:");
		System.out.println("Cooperators  = " + new_pop.get("Cooperator"));
		System.out.println("Defectors    = " + new_pop.get("Defector"));
		System.out.println("Partial      = " + new_pop.get("PartialCooperator"));
		System.out.println("\nMean Cooperation Probability: " + temp.calculateCooperationMean());

	}

}