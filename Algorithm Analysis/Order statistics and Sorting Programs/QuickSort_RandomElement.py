
import random
import sys
import time

#Select a random element as pivot
def getPivotIndex(start, end):
    return random.randint(start, end)

#Dividing the list into two parts around pivot element
def Quicksort(start, end):
        if start < end:
            pivotIndex = partition(start, end, getPivotIndex(start, end))
            Quicksort(start, pivotIndex - 1)
            Quicksort(pivotIndex + 1, end)
			
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


content = [line.rstrip('\t') for line in open('Input_1K.txt')]
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
    with open("Output_QuickSort_RandomElement.txt","w")as fp:
        fp.write("Using Quick Sort Random Element as pivot:\n")
        fp.write("The Sorted order for the array:\n")
        for line in list:
            fp.write(str(line)+"\n")
    print ("Success")