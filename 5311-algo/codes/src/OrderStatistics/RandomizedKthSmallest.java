package OrderStatistics;

import Util.*;

public class RandomizedKthSmallest {
	
	private float[] input;
	
	public RandomizedKthSmallest(float[] input) {
		this.input = input;
	}
	
	public float select(int start, int end, int k) {
		if(start == end) {
			return input[start];
		}
	
		int initialPivotIndex = Util.rand(start, end);
		int pivotIndex = partition(start, end, initialPivotIndex);
		int leftParitionSize = pivotIndex - start + 1; // including pivot
		
		if(k == leftParitionSize) {
			return input[pivotIndex];
		}		
		else if (k < leftParitionSize) {
			return select(start, pivotIndex - 1, k);
		}
		else {
			return select(pivotIndex + 1, end, k - leftParitionSize);
		}		
	}	
	
	private int partition(int start, int end, int pivotIndex) {			
		int pivotIndexAfterPartition = start;
		float pivot = input[pivotIndex];
		
		swap(pivotIndex, end);
		
		for(int i = start; i < end; i++) {
			if(input [i] <= pivot) {
				swap(i, pivotIndexAfterPartition);
				pivotIndexAfterPartition++;
			}
		}		
		swap(end, pivotIndexAfterPartition);		
		return pivotIndexAfterPartition;		
	}
	
	private void swap(int i, int j) {
		float tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
}
