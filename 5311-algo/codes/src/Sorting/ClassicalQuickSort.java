package Sorting;

public class ClassicalQuickSort extends QuickSort {
	
	public ClassicalQuickSort(float[] input) {
		super(input);
	}

	@Override
	protected int getPivotIndex(int start, int end) {		
		return start;
	}
}
