package hashcode.mainevent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import hashcode.videos.VideoCaching;

public class Main {

	private static final String INPUT_DIRECTORY = "inputs/";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		for (String fileName : args) {

			System.out.println("fileName=" + fileName);

			IProblem problem = new VideoCaching();
			ClassLoader classLoader = Main.class.getClassLoader();
			problem.readFile(new File(classLoader.getResource(INPUT_DIRECTORY + fileName).getFile()));

			System.out.println("problem=" + problem);

			IStrategy strategy = new SlicingBuilder(); //TODO
			ISolution solution = strategy.getSolution(problem);

			AFitnessFunction fitnessFunction = new FitnessFunction(new Validator());
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
