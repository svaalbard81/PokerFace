package amc.pokerface.enums;

import lombok.Getter;

public enum PokerHandResult {

	HIGH_CARD("High Card"), PAIR("One Pair"), TWO_PAIR("Two Pair"), THREE_OF_A_KIND("Three of a kind"), 
	STRAIGHT("Straight"), FLUSH("Flush"), FULL_HOUSE("Full house"), FOUR_OF_A_KIND("Four of a kind"), 
	STRAIGHT_FLUSH("Straight flush"), ROYAL_FLUSH("Royal Flush");
	
	@Getter
	private String resultMessage;
	
	private PokerHandResult(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
}
