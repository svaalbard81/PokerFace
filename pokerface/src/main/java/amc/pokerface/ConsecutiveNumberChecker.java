package amc.pokerface;

import java.util.Collections;
import java.util.List;

public class ConsecutiveNumberChecker {

	private ConsecutiveNumberChecker() {}
	
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
