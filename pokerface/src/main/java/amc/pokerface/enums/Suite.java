package amc.pokerface.enums;

import lombok.Getter;

public enum Suite {

	DIAMONDS("D"), HEARTS("H"), CLUBS("C"), SPADES("S"); 
	
	@Getter
	private String suiteCode;
	
	private Suite(String suiteCode) {
		this.suiteCode = suiteCode;
	}
	
}
