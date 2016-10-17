package maze;

import java.io.*;

/**
 * This class is responsible for parsing any input file that has maze input
 * 
 * @author Bishwanath Jha <bishwanathkj@gmail.com>
 */
public class FileParser {

	// Meta-data of file
	private int rows = 0;
	private int columns = 0;

	// Setting default maze
	private int[][] data = { { 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1 },
			{ 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1 },
			{ 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	private String fileName;

	// Getters functions

	public int GetRowsCount() {
		return this.rows;
	}

	public int GetColCount() {
		return this.columns;
	}

	public int[][] GetData() {
		return this.data;
	}

	public String GetFileName() {
		return this.fileName;
	}

	public boolean IsLoaded() {
		return this.rows > 0 && this.columns > 0 && this.data.length > 0;
	}

	/**
	 * It parse the input file and return the maze from it
	 * 
	 * @param fileName
	 * 
	 * @return FileParser
	 */
	public static FileParser Handle(String fileName) throws IOException {

		if (fileName.isEmpty()) {
			throw new IOException("File name can't be empty");
		}

		FileParser FP = new FileParser();
		FP.fileName = fileName;

		try {
			// Calculating rows and columns of array
			BufferedReader buffer = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = buffer.readLine()) != null) {
				String[] vals = line.trim().split("\\s+");
				FP.columns = vals.length;
				FP.rows++;
			}

			buffer.close();

			FP.data = new int[FP.rows][FP.columns];

			// Building the 2D array
			BufferedReader bufferNew = new BufferedReader(new FileReader(fileName));
			int row = 0;
			while ((line = bufferNew.readLine()) != null) {
				String[] vals = line.trim().split("\\s+");

				for (int column = 0; column < FP.columns; column++) {
					FP.data[row][column] = Integer.parseInt(vals[column]);
				}

				row++;
			}

			bufferNew.close();
			
			// TODO Optimize this array building

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("ERROR : " + e.getMessage());
		}

		return FP;
	}

	/**
	 * Default routine
	 * 
	 * @return FileParser
	 */
	public static FileParser HandleDefault() {

		FileParser FP = new FileParser();
		FP.rows = FP.data.length;
		FP.columns = FP.data[0].length;

		System.out.println(FP.data.getClass().getSimpleName());

		return FP;
	}
}
