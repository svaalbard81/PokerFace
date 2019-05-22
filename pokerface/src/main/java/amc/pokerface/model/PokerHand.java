package amc.pokerface.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import amc.pokerface.enums.CardName;
import amc.pokerface.enums.PokerHandSize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokerHand {

	private PokerHandSize pokerHandSize;
	private Set<PlayingCard> cardsInHand;
	
	/**
	 * Gets the lowest ranked card in the poker hand.
	 * @return
	 */
	public int getLowestRankingAceHigh() {
		
		List <Integer> basicRanks = cardsInHand.stream().map(o1 -> o1.getCardName().getBasicCardRank()).sorted().collect(Collectors.toList());
		return basicRanks.get(0);
	}
	
	/**
	 * Gets the list of distinct card names.  Ignores Suite.
	 * @return
	 */
	public Set<CardName> getDistinctCardNames(){
		return this.getCardsInHand().stream().map(o1 -> o1.getCardName()).collect(Collectors.toSet()); 
	}
	
	/**
	 * Gets the card names and counts the number of occurences.  It ignores Suite.
	 * @return
	 */
	public Map<CardName, Integer> getCardNamesAndCounts(){
		
		Map<CardName, Integer> cardNameAndCardCount = new HashMap<>();
		for (CardName cardname: this.getDistinctCardNames()) {
			int countOfCardName = 0;
			for (PlayingCard card: this.getCardsInHand()) {
				if (card.getCardName() == cardname) {
					countOfCardName ++;
				}
			}
			cardNameAndCardCount.put(cardname, countOfCardName);
		}
		return cardNameAndCardCount;
		
	}
	
}
