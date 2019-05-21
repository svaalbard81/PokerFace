package amc.pokerface.converter;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import amc.pokerface.enums.CardName;
import amc.pokerface.enums.Suite;
import amc.pokerface.model.PlayingCard;
import amc.pokerface.model.PokerHand;

public class TestCardDescriptionSSVToPokerHandConverter {

	//NB Description says that the inputs will be valid or I would put more tests and 
	//checks in this class for validity.
	
	@Test
	public void convertCardDescriptionSSVToPokerHand_validInputList_returnsPokerHand() {
		
		String ssvPokerHandString = "3H JS 3C 7C 5D";
		PokerHand pokerHand = CardDescriptionSSVToPokerHandConverter.convertCardDescriptionSSVToPokerHand(ssvPokerHandString);
		
		assertTrue(pokerHand.getCardsInHand().contains(new PlayingCard(Suite.HEARTS, CardName.THREE)));
		assertTrue(pokerHand.getCardsInHand().contains(new PlayingCard(Suite.SPADES, CardName.JACK)));
		assertTrue(pokerHand.getCardsInHand().contains(new PlayingCard(Suite.CLUBS, CardName.THREE)));
		assertTrue(pokerHand.getCardsInHand().contains(new PlayingCard(Suite.CLUBS, CardName.SEVEN)));
		assertTrue(pokerHand.getCardsInHand().contains(new PlayingCard(Suite.DIAMONDS, CardName.FIVE)));
		
	}
	
}
