import java.io.*;
import org.junit.Test;
import maze.FileParser;
import maze.Maze;
import maze.Solver.Recursive;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

/**
 * Testing Recursive class
 * 
 * @author Bishwanath Jha <bishwanathkj@gmail.com>
 */
public class TestRecursive {

	@Test
	public void testObject() throws IOException {
		Maze maze = new Maze(FileParser.HandleDefault());
		Recursive recursive = new Recursive(maze);

		assertThat(recursive, instanceOf(Recursive.class));
		assertTrue(recursive.Traverse());
	}

	@Test(expected = InvalidObjectException.class)
	public void testInvalidObject() throws InvalidObjectException {
		Maze maze = new Maze(new FileParser());
		new Recursive(maze);
	}

}
