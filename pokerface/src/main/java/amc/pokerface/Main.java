package amc.pokerface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import amc.pokerface.calculator.PokerHandCalculator;
import amc.pokerface.converter.CardDescriptionSSVToPokerHandConverter;
import amc.pokerface.enums.PokerHandResult;
import amc.pokerface.io.StringArrayListFileReader;
import amc.pokerface.model.PokerHand;

public class Main {

	private static final String RESULT_SEPARATOR = " => ";
	
	private static BufferedReader consoleReader;
	
	public static void main(String [] args) throws IOException {
		
		consoleReader = new BufferedReader(new InputStreamReader(System.in));
		String userInput = "";
		while (!userInput.toLowerCase().equals("q")){
			System.out.println("");
			
			System.out.println("Please type in the file path to the card descriptions file (or q to quit):-");
			userInput = consoleReader.readLine();
			
			if (!userInput.toLowerCase().equals("q")) {
				performPokerHandCalculations(userInput);
			}
			
		}

	}
	
	private static void performPokerHandCalculations(String filePath) {
		
		List<String> cardDescriptionSSVs = new ArrayList<>();
		try {
			
			cardDescriptionSSVs = StringArrayListFileReader.readFileToListOfStrings(filePath);
			for (String cardDescriptionSSV : cardDescriptionSSVs) {
				
				PokerHand pokerHand = CardDescriptionSSVToPokerHandConverter.convertCardDescriptionSSVToPokerHand(cardDescriptionSSV);
				PokerHandResult pokerHandResult = PokerHandCalculator.getPokerHandResult(pokerHand);
				
				StringBuilder outputResult = new StringBuilder(cardDescriptionSSV);
				outputResult.append(RESULT_SEPARATOR);
				outputResult.append(pokerHandResult.getResultMessage());
				System.out.println(outputResult);
				
			}
			
		} catch (IOException e) {
			System.out.println("Unable to load file.  Please try again.");
		}
		
		
		
	}
	
	
}
