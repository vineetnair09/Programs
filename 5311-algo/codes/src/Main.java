import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import OrderStatistics.*;
import Sorting.*;

public class Main {
	public static void main(String[] args) {	 
		try
		{
			printOptions();
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			
			while(option != 9) {
				System.out.println("Provide input file");
				String inFile = scanner.next();
				
				FileInputStream inputFile = new FileInputStream(inFile);
				Scanner fileScanner = new Scanner(inputFile);	
				String outputfile = "output/" + option +  ".txt";
				PrintWriter writer = new PrintWriter(outputfile);
				
				String firstLine = fileScanner.nextLine();
				String[] firstlineContents = firstLine.split(" ");
				int k;
				int n;
				float[] iInputArray;
				int start = 0;
				int end;

				switch(option) {
					case 1:												
						k = Integer.parseInt(firstlineContents[0]);
						n = Integer.parseInt(firstlineContents[1]);
						iInputArray = getInputArray(n, fileScanner);
						end = iInputArray.length - 1;
																		
						writer.println(getRandomizedKthSmallest(k, iInputArray, start, end));
						break;
						
					case 2:
						k = Integer.parseInt(firstlineContents[0]);
						n = Integer.parseInt(firstlineContents[1]);
						iInputArray = getInputArray(n, fileScanner);
						end = iInputArray.length - 1;
						
						writer.println(getKthSmallest(k, iInputArray, start, end));
						break;						

					case 3:
						k = Integer.parseInt(firstlineContents[0]);
						n = Integer.parseInt(firstlineContents[1]);
						iInputArray = getInputArray(n, fileScanner);
						end = iInputArray.length - 1;
						
						float kthSmallest = getKthSmallest(k, iInputArray, start, end);
						float[] topK = new float[k];
						int topKIndex = 0;
						for(int i = 0; i < end && topKIndex < k; i++) {
							if(iInputArray[i] <= kthSmallest) {
								topK[topKIndex++] = iInputArray[i];  
							}
						}
						
						printToFile(writer, topK);						
						break;		
					
					case 4: 
						n = Integer.parseInt(firstlineContents[0]);
						iInputArray = getInputArray(n, fileScanner);
						end = iInputArray.length - 1;						
						
						ClassicalQuickSort cq = new ClassicalQuickSort(iInputArray);
						cq.sort(start, end);
						
						printToFile(writer, iInputArray);
						break;

					case 5: 
						n = Integer.parseInt(firstlineContents[0]);
						iInputArray = getInputArray(n, fileScanner);
						end = iInputArray.length - 1;
						
						RandomizedQuickSort rq = new RandomizedQuickSort(iInputArray);
						rq.sort(start, end);
						
						printToFile(writer, iInputArray);
						break;
						
					case 6: 
						n = Integer.parseInt(firstlineContents[0]);
						iInputArray = getInputArray(n, fileScanner);
						end = iInputArray.length - 1;
						
						MedianHeuristicQuickSort mq = new MedianHeuristicQuickSort(iInputArray);
						mq.sort(start, end);
						
						printToFile(writer, iInputArray);
						break;
						
					case 7: 
						n = Integer.parseInt(firstlineContents[0]);
						iInputArray = getInputArray(n, fileScanner);
						end = iInputArray.length - 1;
						
						InsertionQuickSort iq = new InsertionQuickSort(iInputArray);
						iq.sort(start, end);
						
						printToFile(writer, iInputArray);
						break;
						
					default:
						System.out.println("Wrong option provided\n");
						break;						
				}
			
				System.out.println("Output generated in output/" + option + ".txt\n");
				writer.close();
				fileScanner.close();
				
				
				printOptions();
				option = scanner.nextInt();							
			}
			scanner.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}	
		System.out.println("Exited\n");
		
	}

	private static void printToFile(PrintWriter writer, float[] arr) {
		for (int i = 0; i < arr.length; i++){
			writer.println(arr[i]);
		}
	}
	
	
	private static float getKthSmallest(int k, float[] iInputArray, int start, int end) {
		float kthVal;
		KthSmallest kthsmallest = new KthSmallest(KthSmallest.GROUP_BY_5);
		kthVal = kthsmallest.select(iInputArray, start, end, k);
		return kthVal;
	}

	private static float getRandomizedKthSmallest(int k, float[] iInputArray, int start, int end) {
		RandomizedKthSmallest randK = new RandomizedKthSmallest(iInputArray);
		float kthVal = randK.select(start, end, k);
		return kthVal;
	}
	
	private static float[] getInputArray(int n, Scanner fileScanner) {
		float[] iInputArray = new float[n];
		int ilength = 0;
		while(fileScanner.hasNext() && ilength < n) {
			iInputArray[ilength++] = fileScanner.nextFloat();
		}		
		
		return iInputArray;
	}
	
	private static void printOptions() {
		System.out.println("Select any option:");
		System.out.println("1. K-th Smallest element(Expected linear time)");
		System.out.println("2. K-th Smallest element(Worst case linear time");
		System.out.println("3. Top K elements");
		System.out.println("4. Classical Quick Sort");
		System.out.println("5. Randomized Quick Sort");
		System.out.println("6. Median Heuristic Quick Sort");
		System.out.println("7. Quick Sort with insertion Sort");
		System.out.println("8. Heap Sort");		
		System.out.println("9. Exit");
	}
}
