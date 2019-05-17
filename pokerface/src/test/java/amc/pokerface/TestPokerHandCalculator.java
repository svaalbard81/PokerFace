package amc.pokerface;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import amc.pokerface.enums.CardName;
import amc.pokerface.enums.PokerHandSize;
import amc.pokerface.enums.Suite;
import amc.pokerface.model.PlayingCard;
import amc.pokerface.model.PokerHand;

public class TestPokerHandCalculator {

	@Test
	public void isFlush_cardsAreNotFlush_returnsFalse() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.JACK));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		
		PokerHand nonFlushPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertFalse(PokerHandCalculator.isFlush(nonFlushPokerHand));
		
	}
	
	@Test
	public void isFlush_cardsAreFlush_returnsTrue() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.JACK));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		
		PokerHand flushPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertTrue(PokerHandCalculator.isFlush(flushPokerHand));
		
	}
	
	@Test
	public void isStraight_cardsAreNotStraight_returnsFalse() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.JACK));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		
		PokerHand nonStraightPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertFalse(PokerHandCalculator.isStraight(nonStraightPokerHand));
		
	}
	
	@Test
	public void isStraight_simpleMidCardStraight_returnsTrue() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.SEVEN));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.SIX));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		
		PokerHand nonStraightPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertTrue(PokerHandCalculator.isStraight(nonStraightPokerHand));
		
	}
	
	@Test
	public void isStraight_aceLowStraight_returnsTrue() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TWO));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.ACE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		
		PokerHand aceLowStraightPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertTrue(PokerHandCalculator.isStraight(aceLowStraightPokerHand));
	}
	
	@Test
	public void isStraight_aceHighStraight_returnsTrue() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.KING));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.QUEEN));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.ACE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.JACK));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TEN));
		
		PokerHand aceHighStraightPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertTrue(PokerHandCalculator.isStraight(aceHighStraightPokerHand));
	}
	
	@Test
	public void isStraightFlush_nonStraightFlush_returnsFalse() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TWO));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.ACE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.SEVEN));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		
		PokerHand nonStraightFlushPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertFalse(PokerHandCalculator.isStraightFlush(nonStraightFlushPokerHand));
		
	}
	
	@Test
	public void isStraightFlush_straightButNotFlush_returnsFalse() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TWO));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.ACE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		
		PokerHand straightPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertFalse(PokerHandCalculator.isStraightFlush(straightPokerHand));
		
	}
	
	@Test
	public void isStraightFlush_flushButNotStraight_returnsFalse() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TWO));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.ACE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.SEVEN));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		
		PokerHand flushPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertFalse(PokerHandCalculator.isStraightFlush(flushPokerHand));
		
	}
	
	@Test
	public void isStraightFlush_isStraightFlush_returnsTrue() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TWO));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.ACE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		
		PokerHand straightFlushPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertTrue(PokerHandCalculator.isStraightFlush(straightFlushPokerHand));
		
	}
	
	@Test
	public void isRoyalFlush_straightFlushButNotRoyal_returnsFalse() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TWO));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.ACE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		
		PokerHand straightFlushPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertFalse(PokerHandCalculator.isRoyalFlush(straightFlushPokerHand));
		
	}
	
	@Test
	public void isRoyalFlush_isRoyalFlush_returnsTrue() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.KING));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TEN));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.ACE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.QUEEN));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.JACK));
		
		PokerHand straightFlushPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertTrue(PokerHandCalculator.isRoyalFlush(straightFlushPokerHand));
		
	}
	
	@Test
	public void isFourOfAKind_notFourOfAKind_returnsFalse() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.JACK));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		
		PokerHand nonFourOfAKindPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertFalse(PokerHandCalculator.isFourOfAKind(nonFourOfAKindPokerHand));
		
	}
	
	@Test
	public void isFourOfAKind_isFourOfAKind_returnsTrue() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.CLUBS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.SPADES, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		
		PokerHand fourOfAKindHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertTrue(PokerHandCalculator.isFourOfAKind(fourOfAKindHand));
		
	}
	
	@Test
	public void isThreeOfAKind_notThreeOfAKind_returnsFalse() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.JACK));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		
		PokerHand nonThreeOfAKindPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertFalse(PokerHandCalculator.isThreeOfAKind(nonThreeOfAKindPokerHand));
	}
	
	@Test
	public void isThreeOfAKind_isThreeOfAKind_returnsTrue() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.CLUBS, CardName.EIGHT));
		cardList.add(new PlayingCard(Suite.SPADES, CardName.SEVEN));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		
		PokerHand threeOfAKindPokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertTrue(PokerHandCalculator.isThreeOfAKind(threeOfAKindPokerHand));
		
	}
}
