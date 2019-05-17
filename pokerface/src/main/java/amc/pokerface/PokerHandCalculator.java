package amc.pokerface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import amc.pokerface.enums.CardName;
import amc.pokerface.enums.PokerHandResult;
import amc.pokerface.enums.Suite;
import amc.pokerface.model.PlayingCard;
import amc.pokerface.model.PokerHand;

public class PokerHandCalculator {

	private PokerHandCalculator() {}
	
	public static PokerHandResult getPokerHandResult(PokerHand pokerHand) {
		//TODO:Implement
		return null;
		
	}
	
	
	public static boolean isFlush(PokerHand pokerHand){
		
		Set<Suite> distinctSuites = pokerHand.getCardsInHand().stream().map(o1 -> o1.getSuite()).collect(Collectors.toSet());
		return (distinctSuites.size() == 1);
		
	}
	
	public static boolean isStraight(PokerHand pokerHand) {
		
		Set<CardName> distinctCardNames = getDistinctCardNamesFromPokerHand(pokerHand); 
		
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
		return pokerHandContainsNumberOfSameRankedCards(pokerHand, 4);
	}
	
	public static boolean isThreeOfAKind(PokerHand pokerHand) {
		return pokerHandContainsNumberOfSameRankedCards(pokerHand, 3);
	}
	
	public static boolean isPair(PokerHand pokerHand) {
		return pokerHandContainsNumberOfSameRankedCards(pokerHand, 2);
	}
	
	public static boolean isFullHouse(PokerHand pokerHand) {
		return isPair(pokerHand) && isThreeOfAKind(pokerHand);
	}
	
	public static boolean isTwoPair(PokerHand pokerHand) {
		
		Map<CardName, Integer> cardNameAndCardCount = getCardNamesAndCardCounts(pokerHand);
		int countOfPairs = 0;
		for (Integer cardCount : cardNameAndCardCount.values()) {
			if (cardCount == 2) {
				countOfPairs ++;
			}
		}
		
		return countOfPairs == 2;
		
	}
	
	//TODO:Should I move this to another class?
	private static Map<CardName, Integer> getCardNamesAndCardCounts(PokerHand pokerHand){
		
		Map<CardName, Integer> cardNameAndCardCount = new HashMap<>();
		for (CardName cardname: getDistinctCardNamesFromPokerHand(pokerHand)) {
			int countOfCardName = 0;
			for (PlayingCard card: pokerHand.getCardsInHand()) {
				if (card.getCardName() == cardname) {
					countOfCardName ++;
				}
			}
			cardNameAndCardCount.put(cardname, countOfCardName);
		}
		return cardNameAndCardCount;
		
	}
	
	//TODO:Refactor to get rid of - maybe use the method above
	private static boolean pokerHandContainsNumberOfSameRankedCards(PokerHand pokerHand, int numberOfCardsToCheckFor) {
		
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
