package amc.pokerface.enums;

import lombok.Getter;

@Getter
public enum PokerHandSize {

	FIVE(5);
	
	private int pokerHandSize;
	private PokerHandSize(int pokerHandSize) {
		this.pokerHandSize = pokerHandSize;
	}
	
}
