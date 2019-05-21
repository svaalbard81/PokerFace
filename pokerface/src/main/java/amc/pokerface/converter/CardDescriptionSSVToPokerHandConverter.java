package amc.pokerface.converter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import amc.pokerface.enums.PokerHandSize;
import amc.pokerface.model.PokerHand;

public class CardDescriptionSSVToPokerHandConverter {

	//NB Requirement says that the inputs will be valid or I would put more tests and 
	//checks in this class for validity.
	
	private static final String SPACE_SEPARATOR = " ";
	
	private CardDescriptionSSVToPokerHandConverter() {}
	
	/**
	 * Converts a space separated value string of card descriptions into a PokerHand
	 * @param spaceSeparatedValuesOfCardDescriptions
	 * @return
	 */
	public static PokerHand convertCardDescriptionSSVToPokerHand(String spaceSeparatedValuesOfCardDescriptions) {
		
		List<String> cardDescriptions = Arrays.asList(spaceSeparatedValuesOfCardDescriptions.split(SPACE_SEPARATOR));
		
		PokerHand pokerHand = new PokerHand();
		pokerHand.setPokerHandSize(PokerHandSize.FIVE);
		pokerHand.setCardsInHand(new HashSet<>());
		
		for (String cardDescription : cardDescriptions) {
			pokerHand.getCardsInHand().add(CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard(cardDescription));
		}
		
		return pokerHand;
		
	}
	
}
