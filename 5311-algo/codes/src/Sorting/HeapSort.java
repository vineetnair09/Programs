package Sorting;

public class HeapSort {
	
	private float[] input;
	private int heapsize;

	public HeapSort(float[] input) {
		this.input = input;
		heapsize = input.length;
	}
	
	private void buildHeap() {
		for(int i = heapsize/2; i >= 0; i--) {
			heapify(i);
		}
	}

	public void sort() {		
		buildHeap();		
		for(int i = heapsize -1; i > 0; i--) {
			swap(0, i);
			heapsize--;
			heapify(0);
		}		
	}
	
	public float[] getSortedArray() {
		return input;
	}

	private void heapify(int i) {
		int largest;
		int l=left(i);
		int r=right(i);
		
		if (l< heapsize && input[l] > input[i]){
			largest = l;
		}
		else {
			largest = i;
		}
		if (r < heapsize && input[r] > input[largest]) {
			largest = r;
		}
		
		if (largest != i) {
			swap(i, largest);
			heapify(largest);		
		}
	}

	private int left(int i) {
		return 2 * i + 1;
	}

	private int right(int i) {
		return 2 * i + 2;
	}

	private void swap(int i, int j) {
		float temp = input[i];
		input[i] = input[j];
		input[j] = temp;		
	}	
}


