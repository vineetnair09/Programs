package OrderStatistics;

public class KthSmallest {
	public static final int GROUP_BY_3 = 3;
	public static final int GROUP_BY_5 = 5;
	public static final int GROUP_BY_7 = 7;
	
	private int groupSize;
	
	public KthSmallest(int groupSize) {
		this.groupSize = groupSize;
	}
	
	public float select(float[] input, int start, int end, int k) {
		if(end - start + 1 <= groupSize) {
			insertionSort(input, start, end);
			return input[k + start - 1];
		}
		
		groupAndSort(input, start, end, groupSize);
		float[] medians = getMedians(input,start,end);
		float medianOfMedian = select(medians, 0, medians.length - 1, medians.length/2);
		int pivotIndex = partition(input, start, end, getIndex(input, medianOfMedian));
		int leftParitionSize = pivotIndex - start + 1; // including pivot
		
		if(k == leftParitionSize) {
			return input[pivotIndex];
		}		
		else if (k < leftParitionSize) {
			return select(input, start, pivotIndex - 1, k);
		}
		else {
			return select(input, pivotIndex + 1, end, k - leftParitionSize);
		}				
	}
	
	private void groupAndSort(float[] input, int start, int end, int size) {
		int i = start; 
		int arraySize = end - start + 1;
		int last = start + arraySize - (arraySize % size) - 1; 
		for (i = start; i < last; i+= size) {
			insertionSort(input, i, i + size - 1);
		}
		
		insertionSort(input, i, end);
	}
	
	private void insertionSort(float[] input, int start, int end) {		
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
	
	private float[] getMedians(float[] arr, int start, int end) {
		int length = end-start+1;
		int noOfMedians = 0;
		
		if((length) % groupSize == 0 )
			noOfMedians = length/groupSize;
		else
			noOfMedians = length/groupSize + 1;
		
		float[] medians = new float[noOfMedians];
		int medianIndex = 0;
		
		for(int i = groupSize/2; i < (length - (length % groupSize)) ; i += groupSize) {
			medians[medianIndex++] = arr[i+start];
		}
		
		if (medianIndex < noOfMedians ) {
			medians[medianIndex] =  arr[((medianIndex * groupSize)  + ((length % groupSize) - 1)/2)+ start];
		}
		return medians;		
	}
	
	private int partition(float[] input, int start, int end, int pivotIndex) {			
		int pivotIndexAfterPartition = start;
		float pivot = input[pivotIndex];
		
		swap(input, pivotIndex, end);
		
		for(int i = start; i < end; i++) {
			if(input [i] <= pivot) {
				swap(input, i, pivotIndexAfterPartition);
				pivotIndexAfterPartition++;
			}
		}		
		swap(input, end, pivotIndexAfterPartition);		
		return pivotIndexAfterPartition;		
	}
	
	private void swap(float[] input, int i, int j) {
		float tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
	
	private int getIndex(float[] input, float val) {
		for(int i = 0; i < input.length; i++) {
			if(input[i] == val) {
				return i;
			}						
		}
		return -1;
	}
}
