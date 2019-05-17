package amc.pokerface.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import amc.pokerface.enums.PokerHandSize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PokerHand {

	private PokerHandSize pokerHandSize;
	private Set<PlayingCard> cardsInHand;
	
	public int getLowestRankingAceHigh() {
		
		List <Integer> basicRanks = cardsInHand.stream().map(o1 -> o1.getCardName().getBasicCardRank()).sorted().collect(Collectors.toList());
		return basicRanks.get(0);
	}
	
	public PlayingCard getHighCard() {
		return null;
	}
	
}
