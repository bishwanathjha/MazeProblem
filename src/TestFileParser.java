import static org.junit.Assert.*;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Test;
import maze.FileParser;

/**
 * @author bishwanath Jha <bishwanathkj@gmail.com>
 */
public class TestFileParser {

	@Test
	public void testHandle() throws IOException {
		String fileName = "maze1.txt";
		FileParser FP = FileParser.Handle(fileName);
		assertThat(FP, instanceOf(FileParser.class));
		assertNotNull(FP.GetData());
		assertNotNull(FP.GetRowsCount());
		assertNotNull(FP.GetColCount());
	}

	@Test(expected = IOException.class)
	public void testFailHandle() throws IOException {
		FileParser.Handle("");
		FileParser.Handle(null);
	}

	@Test
	public void testDefault() {
		FileParser FP = FileParser.HandleDefault();
		assertThat(FP, instanceOf(FileParser.class));
		assertNotNull(FP.GetData());
		assertNotNull(FP.GetRowsCount());
		assertNotNull(FP.GetColCount());
	}
}
