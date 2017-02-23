package hashcode.mainevent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import hashcode.pizza.Pizza;
import hashcode.pizza.SlicingBuilder;
import hashcode.pizza.SlicingScore;

public class Main {

	private static final String INPUT_DIRECTORY = "inputs/";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		for (String fileName : args) {

			IProblem problem = new Pizza();
			ClassLoader classLoader = Main.class.getClassLoader();
			problem.readFile(new File(classLoader.getResource(INPUT_DIRECTORY + fileName).getFile()));

			System.out.println("problem=" + problem);

			IStrategy strategy = new SlicingBuilder();
			ISolution solution = strategy.getSolution(problem);

			AFitnessFunction fitnessFunction = new SlicingScore();
			Optional<Double> fitness = fitnessFunction.getFitness(problem, solution);

			if (fitness.isPresent()) {
				System.out.println("Fitness :" + fitness.get());
				solution.toFile(new File(fileName + "_result"));
			} else {
				System.out.println("Solution is not feasible");
			}
		}
	}

}
