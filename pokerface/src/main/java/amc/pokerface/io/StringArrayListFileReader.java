package amc.pokerface.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringArrayListFileReader {

	/**
	 * Reads a file in and returns it as an arraylist of each line
	 * @param filepath
	 * @return
	 * @throws IOException 
	 */
	public static List<String> readFileToListOfStrings(String filepath) throws IOException{
		
		List<String> readInStrings = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		String line;
		while ((line = reader.readLine()) != null) {
			readInStrings.add(line);
		}
		reader.close();
		
		return readInStrings;
		
	}
	
}
