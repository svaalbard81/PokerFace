package amc.pokerface.calculator;

import static org.testng.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import amc.pokerface.calculator.PokerHandCalculator;
import amc.pokerface.enums.CardName;
import amc.pokerface.enums.PokerHandResult;
import amc.pokerface.enums.PokerHandSize;
import amc.pokerface.enums.Suite;
import amc.pokerface.model.PlayingCard;
import amc.pokerface.model.PokerHand;

public class TestPokerHandCalculator {
	
	@Test
	public void getPokerHandResult_cardsAreHighCard_returnsHighCard() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.CLUBS, CardName.JACK));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		cardList.add(new PlayingCard(Suite.SPADES, CardName.THREE));
		
		PokerHand highCardPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertEquals(PokerHandCalculator.getPokerHandResult(highCardPokerHand), PokerHandResult.HIGH_CARD);
	}
	
	@Test
	public void getPokerHandResult_cardsAreFlush_returnsFlush() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.JACK));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		
		PokerHand flushPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertEquals(PokerHandCalculator.getPokerHandResult(flushPokerHand), PokerHandResult.FLUSH);
	}
	
	@Test
	public void getPokerHandResult_cardsAreSimpleMidCardStraight_returnsStraight() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.SEVEN));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.SIX));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		
		PokerHand simpleMidCardStraight = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertEquals(PokerHandCalculator.getPokerHandResult(simpleMidCardStraight), PokerHandResult.STRAIGHT);
	}
	
	@Test
	public void getPokerHandResult_aceLowStraight_returnsStraight() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TWO));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.ACE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		
		PokerHand aceLowStraightPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertEquals(PokerHandCalculator.getPokerHandResult(aceLowStraightPokerHand), PokerHandResult.STRAIGHT);
	}
	
	@Test
	public void getPokerHandResult_aceHighStraightPokerHand_returnsStraight() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.KING));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.QUEEN));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.ACE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.JACK));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TEN));
		
		PokerHand aceHighStraightPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertEquals(PokerHandCalculator.getPokerHandResult(aceHighStraightPokerHand), PokerHandResult.STRAIGHT);
	}
	
	@Test
	public void getPokerHandResult_cardsAreStraightFlush_returnsStraightFlush() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TWO));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.ACE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		
		PokerHand straightFlushPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertEquals(PokerHandCalculator.getPokerHandResult(straightFlushPokerHand), PokerHandResult.STRAIGHT_FLUSH);
	}
	
	public void getPokerHandResult_cardsAreRoyalFlush_returnsRoyalFlush() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.KING));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TEN));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.ACE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.QUEEN));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.JACK));
		
		PokerHand royalFlushPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertEquals(PokerHandCalculator.getPokerHandResult(royalFlushPokerHand), PokerHandResult.ROYAL_FLUSH);
	}
	
	public void getPokerHandResult_cardsAreFourOfAKind_returnsFourOfAKind() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.CLUBS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.SPADES, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		
		PokerHand fourOfAKindHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertEquals(PokerHandCalculator.getPokerHandResult(fourOfAKindHand), PokerHandResult.FOUR_OF_A_KIND);
	}
	
	public void getPokerHandResult_cardsAreThreeOfAKind_returnsThreeOfAKind() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.CLUBS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.SPADES, CardName.SEVEN));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		
		PokerHand threeOfAKindPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertEquals(PokerHandCalculator.getPokerHandResult(threeOfAKindPokerHand), PokerHandResult.THREE_OF_A_KIND);
	}
	
	public void getPokerHandResult_cardsArePair_returnsPair() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.CLUBS, CardName.NINE));
		cardList.add(new PlayingCard(Suite.SPADES, CardName.SEVEN));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		
		PokerHand pairPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertEquals(PokerHandCalculator.getPokerHandResult(pairPokerHand), PokerHandResult.PAIR);
	}

	public void getPokerHandResult_cardsAreFullHouse_returnsFullHouse() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.CLUBS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.SPADES, CardName.SEVEN));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.SEVEN));
		
		PokerHand fullHousePokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertEquals(PokerHandCalculator.getPokerHandResult(fullHousePokerHand), PokerHandResult.FULL_HOUSE);
	}
	
	public void getPokerHandResult_cardsAreTwoPair_returnsTwoPair() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.CLUBS, CardName.TEN));
		cardList.add(new PlayingCard(Suite.SPADES, CardName.SEVEN));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.SEVEN));
		
		PokerHand twoPairPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertEquals(PokerHandCalculator.getPokerHandResult(twoPairPokerHand), PokerHandResult.TWO_PAIR);
	}
	
}
