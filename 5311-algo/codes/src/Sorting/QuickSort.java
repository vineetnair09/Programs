package Sorting;

abstract public class QuickSort {	
	public float[] input;
	
	public QuickSort(float[] input) {
		this.input = input;		
	}

	public void sort(int start, int end) {
		if(start < end) {
			int pivotIndex = partition(start, end, getPivotIndex(start, end));
			sort(start, pivotIndex - 1);
			sort(pivotIndex + 1, end);			
		}
	}
	
	protected int partition(int start, int end, int pivotIndex) {			
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
	
	protected void swap(int i, int j) {
		float tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
	
	abstract protected int getPivotIndex(int start, int end);	
}
