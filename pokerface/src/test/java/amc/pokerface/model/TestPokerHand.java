package amc.pokerface.model;

import static org.testng.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import amc.pokerface.enums.CardName;
import amc.pokerface.enums.PokerHandSize;
import amc.pokerface.enums.Suite;
import amc.pokerface.model.PlayingCard;
import amc.pokerface.model.PokerHand;

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
		
		assertEquals(CardName.TWO.getBasicCardRank(), pokerHandLowTwo.getLowestRankingAceHigh());
		
	}
	
}
