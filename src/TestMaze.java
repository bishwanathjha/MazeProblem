import static org.junit.Assert.*;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Test;
import maze.FileParser;
import maze.Maze;

/**
 * Maze test class
 * 
 * @author Bishwanath Jha <bishwanathkj@gmail.com>
 */
public class TestMaze {

	@Test
	public void testObject() throws IOException {
		Maze maze = new Maze(FileParser.HandleDefault());
		assertThat(maze, instanceOf(Maze.class));
		assertNotNull(maze.GetMaze());
		assertNotNull(maze.GetColumns());
		assertNotNull(maze.GetRows());
		assertTrue(maze.IsValid());
	}

	@Test(expected = IOException.class)
	public void testInvalidObject() throws IOException {
		new Maze(new FileParser());

	}
}
