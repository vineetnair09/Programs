# -*- coding: utf-8 -*-
"""
Created on Mon Nov 30 21:02:16 2015

@author: vineet
"""

import random
import sys
import time

# To get pivot from three random elements in list and choose the appropriate one
def getPivotIndex(start, end):
    num1 = random.randint(start, end)
    num2 = random.randint(start, end)
    num3 = random.randint(start, end)
    if ((list[num1]>list[num2]) & (list[num1]<list[num3])) | ((list[num1]<list[num2]) & (list[num1]>list[num3])):
            pivot = num1
    elif ((list[num2]>list[num1]) & (list[num2]<list[num3])) | ((list[num2]<list[num1]) & (list[num2]>list[num3])):
        pivot = num2
    else:
        pivot = num3
    return pivot

#Find the position of pivot and then apply quicksort to two partitions on either side of pivot
def Quicksort(start, end):
    if start < end:
        pivotIndex = partition(start, end, getPivotIndex(start, end))
        Quicksort(start, pivotIndex - 1)
        Quicksort(pivotIndex + 1, end)

#Find the postion of pivot in the list
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
    print(t2-t1)
    with open ("Output_QuickSort_Median.txt","w")as fp:
        fp.write("Using Quick Sort with Finding Median:\n")
        fp.write("The Sorted order for the array:\n")
        for line in list:
            fp.write(str(line)+"\n")
    print ("Success")