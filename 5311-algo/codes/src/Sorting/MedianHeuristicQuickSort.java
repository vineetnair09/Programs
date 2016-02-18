package Sorting;

import Util.Util;

public class MedianHeuristicQuickSort extends QuickSort {
	
	public MedianHeuristicQuickSort(float[] input) {
		super(input);
	}

	@Override
	protected int getPivotIndex(int start, int end) {		
		int index1 = Util.rand(start, end);
		int index2 = Util.rand(start, end);
		int index3 = Util.rand(start, end);

		float median = Math.min(Math.max(input[index1], input[index2]), input[index3]);
		
		if(input[index1] == median) return index1;
		else if(input[index2] == median) return index2;
		else return index3;		
	}
}
