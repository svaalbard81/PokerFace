package amc.pokerface.model;

import amc.pokerface.enums.CardName;
import amc.pokerface.enums.Suite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PlayingCard {

	private Suite suite;
	private CardName cardName;
	
}
