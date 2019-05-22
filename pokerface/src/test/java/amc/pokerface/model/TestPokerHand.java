package amc.pokerface.model;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import amc.pokerface.enums.CardName;
import amc.pokerface.enums.PokerHandSize;
import amc.pokerface.enums.Suite;

public class TestPokerHand {

	@Test
	public void getLowestRankingAceHigh_lowCardTwo_returnsTwo() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TWO));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FOUR));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TEN));
		
		PokerHand pokerHandLowTwo = new PokerHand(PokerHandSize.FIVE, cardList);
		
		assertEquals(pokerHandLowTwo.getLowestRankingAceHigh(), CardName.TWO.getBasicCardRank());
		
	}
	
	@Test
	public void getDistinctCardNames_severalCards_returnsCorrectNames() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TWO));
		cardList.add(new PlayingCard(Suite.CLUBS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.TWO));
		
		PokerHand pokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		Set<CardName> resultCardNames = pokerHand.getDistinctCardNames();
		assertEquals(resultCardNames.size(), 3);
		assertTrue(resultCardNames.contains(CardName.THREE));
		assertTrue(resultCardNames.contains(CardName.FIVE));
		assertTrue(resultCardNames.contains(CardName.TWO));
		
	}
	
	@Test
	public void getCardNamesAndCount_severalCards_returnsCorrectValues() {
		
		Set<PlayingCard> cardList = new HashSet<>();
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.THREE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.HEARTS, CardName.TWO));
		cardList.add(new PlayingCard(Suite.SPADES, CardName.FIVE));
		cardList.add(new PlayingCard(Suite.DIAMONDS, CardName.TWO));
		
		PokerHand pokerHand = new PokerHand(PokerHandSize.FIVE, cardList);
		
		Map<CardName, Integer> resultCardNames = pokerHand.getCardNamesAndCounts();
		assertEquals(resultCardNames.size(), 3);
		assertEquals(resultCardNames.get(CardName.THREE).intValue(), 1);
		assertEquals(resultCardNames.get(CardName.FIVE).intValue(), 2);
		assertEquals(resultCardNames.get(CardName.TWO).intValue(), 2);
		
	}
	
}
