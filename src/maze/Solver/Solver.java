package maze.Solver;

/**
 * @author Bishwanath Jha <bishwanathkj@gmail.com>
 */
public interface Solver {

	// Locate the starting pointer
	public void FindStart();
	
	// Traverse thru maze
	public boolean Traverse();

	// Print the final solution maze
	public void PrintSolution();
}
