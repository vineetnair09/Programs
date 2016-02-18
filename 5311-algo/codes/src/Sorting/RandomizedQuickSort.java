package Sorting;

import Util.*;

public class RandomizedQuickSort extends QuickSort {
	
	public RandomizedQuickSort(float[] input) {
		super(input);
	}

	@Override
	protected int getPivotIndex(int start, int end) {		
		return Util.rand(start, end);
	}
}
