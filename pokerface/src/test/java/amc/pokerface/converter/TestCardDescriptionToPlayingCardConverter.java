package amc.pokerface.converter;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import amc.pokerface.enums.CardName;
import amc.pokerface.enums.Suite;
import amc.pokerface.model.PlayingCard;

public class TestCardDescriptionToPlayingCardConverter {

	@Test
	public void convertCardDescriptiontoPlayingCard_2H_returnsTwoOfHearts() {
		PlayingCard expected = new PlayingCard(Suite.HEARTS, CardName.TWO);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("2H");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_2D_returnsTwoOfDiamonds() {
		PlayingCard expected = new PlayingCard(Suite.DIAMONDS, CardName.TWO);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("2D");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_2S_returnsTwoOfSpades() {
		PlayingCard expected = new PlayingCard(Suite.SPADES, CardName.TWO);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("2S");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_2C_returnsTwoOfClubs() {
		PlayingCard expected = new PlayingCard(Suite.CLUBS, CardName.TWO);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("2C");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_3H_returnsThreeOfHearts() {
		PlayingCard expected = new PlayingCard(Suite.HEARTS, CardName.THREE);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("3H");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_4H_returnsFourOfHearts() {
		PlayingCard expected = new PlayingCard(Suite.HEARTS, CardName.FOUR);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("4H");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_5H_returnsFiveOfHearts() {
		PlayingCard expected = new PlayingCard(Suite.HEARTS, CardName.FIVE);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("5H");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_6H_returnsSixOfHearts() {
		PlayingCard expected = new PlayingCard(Suite.HEARTS, CardName.SIX);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("6H");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_7H_returnsSevenOfHearts() {
		PlayingCard expected = new PlayingCard(Suite.HEARTS, CardName.SEVEN);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("7H");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_8H_returnsEightOfHearts() {
		PlayingCard expected = new PlayingCard(Suite.HEARTS, CardName.EIGHT);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("8H");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_9H_returnsNineOfHearts() {
		PlayingCard expected = new PlayingCard(Suite.HEARTS, CardName.NINE);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("9H");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_TH_returnsTenOfHearts() {
		PlayingCard expected = new PlayingCard(Suite.HEARTS, CardName.TEN);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("TH");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_JH_returnsJackOfHearts() {
		PlayingCard expected = new PlayingCard(Suite.HEARTS, CardName.JACK);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("JH");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_QH_returnsQueenOfHearts() {
		PlayingCard expected = new PlayingCard(Suite.HEARTS, CardName.QUEEN);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("QH");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_KH_returnsKingOfHearts() {
		PlayingCard expected = new PlayingCard(Suite.HEARTS, CardName.KING);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("KH");
		assertEquals(result, expected);
	}
	
	@Test
	public void convertCardDescriptiontoPlayingCard_AH_returnsAceOfHearts() {
		PlayingCard expected = new PlayingCard(Suite.HEARTS, CardName.ACE);
		PlayingCard result = CardDescriptionToPlayingCardConverter.convertCardDescriptiontoPlayingCard("AH");
		assertEquals(result, expected);
	}
	
}
