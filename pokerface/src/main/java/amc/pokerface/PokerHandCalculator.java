package amc.pokerface;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import amc.pokerface.enums.CardName;
import amc.pokerface.enums.Suite;
import amc.pokerface.model.PlayingCard;
import amc.pokerface.model.PokerHand;

public class PokerHandCalculator {

	private PokerHandCalculator() {}
	
	public static boolean isFlush(PokerHand pokerHand){
		
		Set<Suite> distinctSuites = pokerHand.getCardsInHand().stream().map(o1 -> o1.getSuite()).collect(Collectors.toSet());
		return (distinctSuites.size() == 1);
		
	}
	
	public static boolean isStraight(PokerHand pokerHand) {
		
		Set<CardName> distinctCardNames = pokerHand.getCardsInHand().stream().map(o1 -> o1.getCardName()).collect(Collectors.toSet()); 
		
		if (distinctCardNames.size() == pokerHand.getPokerHandSize().getPokerHandSize()) {
			
			List<Integer> basicCardRanks = distinctCardNames.stream().map(o1 -> o1.getBasicCardRank()).sorted().collect(Collectors.toList());
			
			boolean consecutiveCards = ConsecutiveNumberChecker.numbersAreConsecutive(basicCardRanks);
			if (!consecutiveCards && distinctCardNames.contains(CardName.ACE)) {
				basicCardRanks.remove(basicCardRanks.size() - 1);
				basicCardRanks.add(1);
				consecutiveCards = ConsecutiveNumberChecker.numbersAreConsecutive(basicCardRanks);
			}
			
			return consecutiveCards;
		}
		
		return false;
		
	}
	
	public static boolean isStraightFlush(PokerHand pokerHand) {
		
		return isFlush(pokerHand) && isStraight(pokerHand);
		
	}
	
	public static boolean isRoyalFlush(PokerHand pokerHand) {
		
		if (isStraightFlush(pokerHand) && pokerHand.getLowestRankingAceHigh() == CardName.TEN.getBasicCardRank()) {
			return true;
		}
		
		return false;
		
	}

	public static boolean isFourOfAKind(PokerHand pokerHand) {
		return pokerHandContainsNumberOfCards(pokerHand, 4);
	}
	
	public static boolean isThreeOfAKind(PokerHand pokerHand) {
		return pokerHandContainsNumberOfCards(pokerHand, 3);
	}
	
	private static boolean pokerHandContainsNumberOfCards(PokerHand pokerHand, int numberOfCardsToCheckFor) {
		
		for (CardName cardname: getDistinctCardNamesFromPokerHand(pokerHand)) {
			
			int countOfCardName = 0;
			for (PlayingCard card: pokerHand.getCardsInHand()) {
				if (card.getCardName() == cardname) {
					countOfCardName ++;
				}
			}
			
			if (countOfCardName == numberOfCardsToCheckFor) {
				return true;
			}
			
		}
		
		return false;
		
	}
		
	//TODO:Move to different class
	private static Set<CardName> getDistinctCardNamesFromPokerHand(PokerHand pokerHand){
		return  pokerHand.getCardsInHand().stream().map(o1 -> o1.getCardName()).collect(Collectors.toSet()); 
	}

	
}
