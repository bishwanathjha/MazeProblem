package maze.Solver;

import maze.Maze;
import java.io.*;

/**
 * Solution class that go recursive and search for path
 * 
 * @author Bishwanath Jha <bishwanathkj@gmail.com>
 */
public class Recursive implements Solver {

	private int visited = 5;
	private int path = 7;
	private int startX = -1;
	private int startY = 0;
	private int[][] mazeData;

	public void PrintSolution() {
		Maze.Print(this.mazeData);
	}

	/**
	 * Constructor
	 * 
	 * @param maze
	 * @throws InvalidObjectException
	 */
	public Recursive(Maze maze) throws InvalidObjectException {
		if (!maze.IsValid()) {
			throw new InvalidObjectException("Invalid object found");
		}

		this.mazeData = maze.GetMaze();

		this.FindStart();
	}

	/**
	 * Set the start pointer of maze
	 */
	public void FindStart() {
		for (int i = 0; i < this.mazeData.length; i++) {
			if (this.mazeData[i][0] == 1) {
				this.startX = i;
				break;
			}
		}

	}

	/**
	 * @return boolean
	 */
	public boolean Traverse() {
		if (this.startX != -1) {
			return this.Solve(this.startX, this.startY);
		}

		System.out.println("Maze has no entry point from left");
		return false;
	}

	/**
	 * It attempts to recursively traverse the maze. Inserts special characters
	 * indicating locations that have been visited
	 * 
	 * @param row
	 * @param column
	 * 
	 * @return boolean
	 */
	private boolean Solve(int row, int column) {
		boolean foundPath = false;

		if (this.IsValid(row, column)) {

			this.mazeData[row][column] = this.visited;

			// If we reached to the end of maze, then it is solved
			if (row == this.mazeData.length - 1 && column == this.mazeData[0].length - 1) {
				foundPath = true;
			} else {

				// Go Down
				foundPath = this.Solve(row + 1, column);

				// Go Right
				if (!foundPath) {
					foundPath = this.Solve(row, column + 1);
				}

				// Go UP
				if (!foundPath) {
					foundPath = this.Solve(row - 1, column);
				}

				// Go Left
				if (!foundPath) {
					foundPath = this.Solve(row, column - 1);
				}
			}

			// Location is part of the final path
			if (foundPath) {
				this.mazeData[row][column] = this.path;
			}
		}

		return foundPath;
	}

	/**
	 * @param row
	 * @param column
	 * 
	 * @return boolean
	 */
	private boolean IsValid(int row, int column) {
		// check if cell is in the bounds of the maze and is valid to traverse
		return (row >= 0 && row < this.mazeData.length && column >= 0 && column < this.mazeData[row].length
				&& this.mazeData[row][column] == 1);
	}
}
