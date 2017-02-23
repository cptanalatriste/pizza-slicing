package haschode.pizza;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import haschode.pizza.io.FileManager;
import hashcode.pizza.domain.Pizza;
import hashcode.pizza.domain.PizzaSlice;

/**
 * This is the solution driver.
 *
 */
public class SolutionDriver {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileManager fileManager = new FileManager();

		String fileName = "inputs/example.in";
		Pizza pizza = fileManager.getPizzaFromFile(fileName);

		System.out.println("Pizza from file " + fileName);
		System.out.println(pizza);

		List<PizzaSlice> solution = getSampleSolution();
		fileManager.writeSolutionToFile(solution, "output.txt");
	}

	public static List<PizzaSlice> getSampleSolution() {
		ArrayList<PizzaSlice> sampleSolution = new ArrayList<>();

		sampleSolution.add(new PizzaSlice(0, 0, 2, 1));
		sampleSolution.add(new PizzaSlice(0, 2, 2, 2));
		sampleSolution.add(new PizzaSlice(0, 3, 2, 4));
		return sampleSolution;
	}
}
