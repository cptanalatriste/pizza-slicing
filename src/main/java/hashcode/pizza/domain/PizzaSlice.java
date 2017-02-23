package hashcode.pizza.domain;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class PizzaSlice {
	private Pair<Integer, Integer> firstCoordinate;
	private Pair<Integer, Integer> secondCoordinate;

	public PizzaSlice(int rowFirstCoordinate, int columnFirstCoordinate, int rowSecondCoordinate,
			int columnSecondCoordinate) {
		this.firstCoordinate = new ImmutablePair<Integer, Integer>(rowFirstCoordinate, columnFirstCoordinate);
		this.secondCoordinate = new ImmutablePair<Integer, Integer>(rowSecondCoordinate, columnSecondCoordinate);
	}

	public Pair<Integer, Integer> getFirstCoordinate() {
		return firstCoordinate;
	}

	public void setFirstCoordinate(Pair<Integer, Integer> firstCoordinate) {
		this.firstCoordinate = firstCoordinate;
	}

	public Pair<Integer, Integer> getSecondCoordinate() {
		return secondCoordinate;
	}

	public void setSecondCoordinate(Pair<Integer, Integer> secondCoordinate) {
		this.secondCoordinate = secondCoordinate;
	}

}
