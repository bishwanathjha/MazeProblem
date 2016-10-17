package maze;

import java.io.*;

/**
 * @author Bishwanath Jha <bishwanathkj@gmail.com>
 */
public class Maze {

	/** The maze */
	private int[][] maze;

	/** Total number of rows and columns */
	private int rows, columns;

	// Getter functions

	public int[][] GetMaze() {
		return this.maze;
	}

	public int GetRows() {
		return this.rows;
	}

	public int GetColumns() {
		return this.columns;
	}

	/**
	 * Constructor
	 * 
	 * @throws InvalidObjectException
	 */
	public Maze(FileParser FP) throws InvalidObjectException {
		if (!FP.IsLoaded()) {
			throw new InvalidObjectException("Invalid object found");
		}

		this.maze = FP.GetData();
		this.rows = FP.GetRowsCount();
		this.columns = FP.GetColCount();
	}

	/**
	 * Checks if given maze has only 1,0 in it
	 * 
	 * @return boolean
	 */
	public boolean IsValid() {
		// If the its 1*1 metrics then its not valid maze
		if (this.columns <= 1 || this.rows <= 1) {
			return false;
		}

		for (int row = 0; row < this.maze.length; row++) {
			for (int column = 0; column < this.maze[row].length; column++)
				if (this.maze[row][column] != '1' && this.maze[row][column] != '0') {
					return true;
				}
		}

		return true;
	}

	/**
	 * Return the maze as string
	 * 
	 * @param mazeData
	 * 
	 * @return String
	 */
	public static void Print(int[][] mazeData) {
		String mazeString = "\n";

		for (int row = 0; row < mazeData.length; row++) {
			for (int column = 0; column < mazeData[row].length; column++)
				mazeString += mazeData[row][column] + " ";
			mazeString += "\n";
		}

		System.out.println(mazeString);
	}
}
