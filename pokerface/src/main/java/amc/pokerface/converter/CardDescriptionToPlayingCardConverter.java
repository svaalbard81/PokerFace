package amc.pokerface.converter;

import amc.pokerface.enums.CardName;
import amc.pokerface.enums.Suite;
import amc.pokerface.model.PlayingCard;

public class CardDescriptionToPlayingCardConverter {

	private CardDescriptionToPlayingCardConverter () {}
	
	/**
	 * Converts card description string in format CS where C is card name and S is the card suite
	 * and converts it into its PlayingCard object.
	 * @param cardDescription
	 * @return
	 */
	public static PlayingCard convertCardDescriptiontoPlayingCard(String cardDescription) {
		
		PlayingCard playingCard = new PlayingCard(getSuiteFromCardDescription(cardDescription), getCardNameFromCardDescription(cardDescription));
		return playingCard;
		
	}
	
	/**
	 * Converts the Suite part of the card description into a Suite enum
	 * @param cardDescription
	 * @return
	 */
	private static Suite getSuiteFromCardDescription(String cardDescription) {
		
		String suiteCodeString = cardDescription.substring(1, 2);
		
		if (suiteCodeString.equals(Suite.HEARTS.getSuiteCode())) {
			return Suite.HEARTS;
		}
		else if (suiteCodeString.equals(Suite.DIAMONDS.getSuiteCode())) {
			return Suite.DIAMONDS;
		}
		else if (suiteCodeString.equals(Suite.CLUBS.getSuiteCode())) {
			return Suite.CLUBS;
		}
		else {
			return Suite.SPADES;
		}
		
	}
	
	/**
	 * Converts the card name part of the card description into a CardName enum
	 * @param cardDescription
	 * @return
	 */
	private static CardName getCardNameFromCardDescription(String cardDescription) {
		
		String cardNameString = cardDescription.substring(0, 1);
		
		if (cardNameString.equals(CardName.TWO.getCardCode())) {
			return CardName.TWO;
		}
		else if (cardNameString.equals(CardName.THREE.getCardCode())) {
			return CardName.THREE;
		}
		else if (cardNameString.equals(CardName.FOUR.getCardCode())) {
			return CardName.FOUR;
		}
		else if (cardNameString.equals(CardName.FIVE.getCardCode())) {
			return CardName.FIVE;
		}
		else if (cardNameString.equals(CardName.SIX.getCardCode())) {
			return CardName.SIX;
		}
		else if (cardNameString.equals(CardName.SEVEN.getCardCode())) {
			return CardName.SEVEN;
		}
		else if (cardNameString.equals(CardName.EIGHT.getCardCode())) {
			return CardName.EIGHT;
		}
		else if (cardNameString.equals(CardName.NINE.getCardCode())) {
			return CardName.NINE;
		}
		else if (cardNameString.equals(CardName.TEN.getCardCode())) {
			return CardName.TEN;
		}
		else if (cardNameString.equals(CardName.JACK.getCardCode())) {
			return CardName.JACK;
		}
		else if (cardNameString.equals(CardName.QUEEN.getCardCode())) {
			return CardName.QUEEN;
		}
		else if (cardNameString.equals(CardName.KING.getCardCode())) {
			return CardName.KING;
		}
		else {
			return CardName.ACE;
		}
		
	}
	
}
