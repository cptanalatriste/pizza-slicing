package hashcode.pizza.domain;

import java.util.Arrays;

public class Pizza {

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

}
