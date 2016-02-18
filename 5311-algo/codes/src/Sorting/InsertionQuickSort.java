package Sorting;

import Util.Util;

public class InsertionQuickSort extends QuickSort {
	
	final int THRESHOLD_FOR_INSERTION_SORT = 7;
	
	public InsertionQuickSort(float[] input) {
		super(input);
	}

	@Override
	protected int getPivotIndex(int start, int end) {		
		return Util.rand(start, end);
	}
	
	@Override
	public void sort(int start, int end) {
		if(start < end) {
			if ((end - start) < THRESHOLD_FOR_INSERTION_SORT) {
				insertionSort(start, end);	
			}
			else {
				int pivotIndex = partition(start, end, getPivotIndex(start, end));
				sort(start, pivotIndex - 1);
				sort(pivotIndex + 1, end);
			}
		}
	}	
	
	private void insertionSort(int start, int end) {		
		float val = 0;
		for (int i = start + 1; i <= end; i++) {
			val = input[i];
			int j = i - 1;
			while( j >= start && input[j] > val) {
				input[j + 1] = input[j];  
				j--;				 
			}
			input[j + 1] = val;
		}
	}
}
