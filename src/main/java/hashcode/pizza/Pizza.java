package hashcode.pizza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import hashcode.mainevent.IProblem;

public class Pizza implements IProblem {

	private int rows;
	private int columns;
	private int minimumIngredients;
	private int maxCells;
	private char[][] ingredientMap;

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getMinimumIngredients() {
		return minimumIngredients;
	}

	public void setMinimumIngredients(int minimumIngredients) {
		this.minimumIngredients = minimumIngredients;
	}

	public int getMaxCells() {
		return maxCells;
	}

	public void setMaxCells(int maxCells) {
		this.maxCells = maxCells;
	}

	public char[][] getIngredientMap() {
		return ingredientMap;
	}

	public void setIngredientMap(char[][] ingredientMap) {
		this.ingredientMap = ingredientMap;
	}

	@Override
	public String toString() {
		return "Pizza [rows=" + rows + ", columns=" + columns + ", minimumIngredients=" + minimumIngredients
				+ ", maxCells=" + maxCells + ", ingredientMap=" + Arrays.deepToString(ingredientMap) + "]";
	}

	@Override
	public void readFile(File inputFile) throws FileNotFoundException, IOException {
		ClassLoader classLoader = getClass().getClassLoader();

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			String line;
			int lineCounter = 0;
			while ((line = reader.readLine()) != null) {
				if (lineCounter == 0) {
					String[] characters = line.split("\\s+");
					int rows = Integer.parseInt(characters[0]);
					int columns = Integer.parseInt(characters[1]);

					this.setRows(rows);
					this.setColumns(columns);
					this.setMinimumIngredients(Integer.parseInt(characters[2]));
					this.setMaxCells(Integer.parseInt(characters[3]));

					this.setIngredientMap(new char[rows][columns]);

				} else if (lineCounter >= 1) {
					char[] characters = line.toCharArray();
					int rowInMap = lineCounter - 1;
					char[][] ingredientMap = this.getIngredientMap();

					for (int columnInMap = 0; columnInMap < characters.length; columnInMap += 1) {
						ingredientMap[rowInMap][columnInMap] = characters[columnInMap];
					}

				}

				lineCounter += 1;
			}
		}

	}

}
