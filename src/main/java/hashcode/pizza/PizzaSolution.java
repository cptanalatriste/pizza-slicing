package hashcode.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import hashcode.mainevent.ISolution;

public class PizzaSolution implements ISolution {
	private List<PizzaSlice> slices;

	public List<PizzaSlice> getSlices() {
		return slices;
	}

	public void setSlices(List<PizzaSlice> slices) {
		this.slices = slices;
	}

	@Override
	public void toFile(File toWrite) throws FileNotFoundException {
		String text = "" + slices.size() + "\n";

		for (PizzaSlice slice : slices) {
			String[] numbers = new String[] { slice.getFirstCoordinate().getLeft().toString(),
					slice.getFirstCoordinate().getRight().toString(), slice.getSecondCoordinate().getLeft().toString(),
					slice.getSecondCoordinate().getRight().toString() };

			text += StringUtils.join(numbers, ' ') + "\n";
		}

		try (PrintWriter writer = new PrintWriter(toWrite)) {
			writer.print(text);
		}
	}

}
