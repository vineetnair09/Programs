import random
import sys
import time

#Select a random element as pivot
def getPivotIndex(start, end):
    return random.randint(start, end)

#Dividing the list into two parts around pivot element using quicksort
def Quicksort(start, end):
    if start < end:
        if (end - start) < Threshold_Insertion_Sort:
            Insertion_Sort(start, end)
        else:
            pivotIndex = partition(start, end, getPivotIndex(start, end))
            Quicksort(start, pivotIndex - 1)
            Quicksort(pivotIndex + 1, end)

#If number of elements in array are less than 10 then use Insertion sort
def Insertion_Sort(start, end):
    val = 0
    for i in range(start + 1, end + 1, 1):
        val = list[i]
        j = i - 1
        while j >= start and list[j] > val:
            list[j + 1] = list[j]
            j -= 1
        list[j + 1] = val

#Find the position of the pivot in the list 
def partition(start, end, pivotIndex):
    pivotIndexAfterPartition = start
    pivot = list[pivotIndex]
    swap(pivotIndex, end)
    for i in range(start, end, 1):
        if list[i] <= pivot:
            swap(i, pivotIndexAfterPartition)
            pivotIndexAfterPartition += 1
    swap(end, pivotIndexAfterPartition)
    return pivotIndexAfterPartition


def swap(i, j):
    temp = list[i]
    list[i] = list [j]
    list[j] = temp


Threshold_Insertion_Sort = 10
content = [line.rstrip('\t') for line in open('Input_1.txt')]
k,n=content[0].split()
k=int(k)
n=int(n)
if n==0 :
    print("The List is empty and no elements to display")
    sys.exit
else:
    list= []
    ans=[]
    j=0
    for i in content:
        if j==0:
            j+=1
            continue
        i=i.strip()
        i=float(i)
        list.append(i)
    start = 0
    end = len(list) - 1
    t1=time.time()
    Quicksort(start, end)
    t2=time.time()
    print (t2-t1)
    with open ("Output_QuickSort_withInsertionSort.txt","w")as fp:
        fp.write("Using Quick Sort with Insertion Sort:\n")
        fp.write("The Sorted order for the array:\n")
        for line in list:
            fp.write(str(line)+"\n")
    print ("Success")