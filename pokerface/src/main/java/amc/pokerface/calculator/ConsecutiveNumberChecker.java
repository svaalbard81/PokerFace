package amc.pokerface.calculator;

import java.util.Collections;
import java.util.List;

public class ConsecutiveNumberChecker {

	private ConsecutiveNumberChecker() {}
	
	/**
	 * Checks if a list of numbers are consecutive and returns true if they are
	 * @param numbersToCheck
	 * @return
	 */
	public static boolean numbersAreConsecutive(List<Integer> numbersToCheck) {
		
		Collections.sort(numbersToCheck);
		
		for (int i = 0 ; i < numbersToCheck.size() - 1; i ++) {
			if (numbersToCheck.get(i) + 1 != numbersToCheck.get(i + 1)) {
			    return false;
			  }
		}
		
		return true;
	}
	
}
