package hashcode.pizza;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import hashcode.mainevent.IProblem;
import hashcode.mainevent.ISolution;
import hashcode.mainevent.IStrategy;

public class SlicingBuilder implements IStrategy {

	private Pizza pizza;
	private boolean[][] assignedCells;

	public List<PizzaSlice> getGreedySolution() {
		List<PizzaSlice> solution = new ArrayList<>();

		ImmutablePair<Integer, Integer> firstCoordinate = new ImmutablePair<Integer, Integer>(0, 0);

		int currentRow = 0;

		for (int currentColumn = 0; currentColumn < pizza.getColumns(); currentColumn += 1) {

		}

		return solution;
	}

	public Pair<Integer, Integer> getIngredientsPerArea(Pair<Integer, Integer> firstCoordinate,
			Pair<Integer, Integer> secondCoordinate) {
		int numberOfMushrooms = 0;
		int numberOfTomatos = 0;

		return new ImmutablePair<Integer, Integer>(numberOfMushrooms, numberOfTomatos);
	}

	@Override
	public ISolution getSolution(IProblem problem) {
		PizzaSolution solution = new PizzaSolution();
		solution.setSlices(getSampleSolution());
		return solution;
	}

	public static List<PizzaSlice> getSampleSolution() {
		ArrayList<PizzaSlice> sampleSolution = new ArrayList<>();

		sampleSolution.add(new PizzaSlice(0, 0, 2, 1));
		sampleSolution.add(new PizzaSlice(0, 2, 2, 2));
		sampleSolution.add(new PizzaSlice(0, 3, 2, 4));
		return sampleSolution;
	}

}
