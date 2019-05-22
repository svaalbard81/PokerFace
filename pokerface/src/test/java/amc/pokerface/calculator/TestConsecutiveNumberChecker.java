package amc.pokerface.calculator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import amc.pokerface.calculator.ConsecutiveNumberChecker;

public class TestConsecutiveNumberChecker {

	@Test
	public void numbersAreConsecutive_notConsecutive_returnsFalse() {
		
		List<Integer> nonConsecutiveList = new ArrayList<>(Arrays.asList(new Integer [] {10,4,5,6,9}));
		
		assertFalse(ConsecutiveNumberChecker.numbersAreConsecutive(nonConsecutiveList));
		
	}
	
	@Test
	public void numbersAreConsecutive_consecutiveList_returnsTrue() {
		
		List<Integer> consecutiveList = new ArrayList<>(Arrays.asList(new Integer [] {2,4,5,6,3}));
		
		assertTrue(ConsecutiveNumberChecker.numbersAreConsecutive(consecutiveList));
	}
	
}
