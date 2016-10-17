package maze;

import java.io.IOException;
import java.util.Arrays;

import maze.Solver.Recursive;

import java.io.*;

/**
 * Main controller class
 * 
 * @author Bishwanath Jha <bishwanathkj@gmail.com>
 */
public class Main {

	public static void main(String[] args) throws IOException {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter filename [maze1.txt or maze2.txt or maze3.txt] or just press enter");
			String s = br.readLine();
			System.out.println("You entered: " + ((s.isEmpty()) ? "None, picking default maze" : s));

			// Parse the file and create maze object
			FileParser FP = !s.isEmpty() ? FileParser.Handle("src/" + s) : FileParser.HandleDefault();
			Maze maze = new Maze(FP);

			// Print input maze
			System.out.println("Input Maze:");
			Maze.Print(maze.GetMaze());

			// Create object of recursive solution and run
			Recursive recursive = new maze.Solver.Recursive(maze);
			if (recursive.Traverse() == true) {
				System.out.println("Maze Solved!!!");
			} else {
				System.out.println("Unable to solve maze");
			}

			// Print final maze
			System.out.println("Final Maze:");
			recursive.PrintSolution();

		} catch (Exception e) {
			System.out.println("Oops there is some error: " + e.toString());
		}

	}

}
