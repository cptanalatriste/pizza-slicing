package haschode.pizza.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import hashcode.pizza.domain.Pizza;
import hashcode.pizza.domain.PizzaSlice;

public class FileManager {

	public Pizza getPizzaFromFile(String fileName) throws FileNotFoundException, IOException {

		ClassLoader classLoader = getClass().getClassLoader();
		File inputFile = new File(classLoader.getResource(fileName).getFile());

		Pizza pizza = new Pizza();

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			String line;
			int lineCounter = 0;
			while ((line = reader.readLine()) != null) {
				if (lineCounter == 0) {
					String[] characters = line.split("\\s+");
					int rows = Integer.parseInt(characters[0]);
					int columns = Integer.parseInt(characters[1]);

					pizza.setRows(rows);
					pizza.setColumns(columns);
					pizza.setMinimumIngredients(Integer.parseInt(characters[2]));
					pizza.setMaxCells(Integer.parseInt(characters[3]));

					pizza.setIngredientMap(new char[rows][columns]);

				} else if (lineCounter >= 1) {
					char[] characters = line.toCharArray();
					int rowInMap = lineCounter - 1;
					char[][] ingredientMap = pizza.getIngredientMap();

					for (int columnInMap = 0; columnInMap < characters.length; columnInMap += 1) {
						ingredientMap[rowInMap][columnInMap] = characters[columnInMap];
					}

				}

				lineCounter += 1;
			}
		}

		return pizza;
	}

	public void writeSolutionToFile(List<PizzaSlice> solution, String fileName) throws FileNotFoundException {

		String text = "" + solution.size() + "\n";

		for (PizzaSlice slice : solution) {
			String[] numbers = new String[] { slice.getFirstCoordinate().getLeft().toString(),
					slice.getFirstCoordinate().getRight().toString(), slice.getSecondCoordinate().getLeft().toString(),
					slice.getSecondCoordinate().getRight().toString() };

			text += StringUtils.join(numbers, ' ') + "\n";
		}

		try (PrintWriter writer = new PrintWriter(fileName)) {
			writer.print(text);
		}
	}
}
