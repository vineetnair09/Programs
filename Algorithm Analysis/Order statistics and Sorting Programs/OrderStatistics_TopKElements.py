# -*- coding: utf-8 -*-
"""
Created on Fri Dec 04 11:46:24 2015

@author: vineet
"""


import sys
import time

#Find correct position of element in min heap
def Min_Heapify(array, i):
    l = 2*i+1
    r = 2*i+2
    if l < heap_size and array[l] < array[i]:
        largest = l
    else:
        largest = i
    if r < heap_size and array[r] < array[largest]:
        largest = r
    if largest != i:
        temp = array[i]
        array[i] = array[largest]
        array[largest] = temp
        Min_Heapify(array, largest)
        
#builds heap structure
def Build_Heap(array):
    global heap_size 
    heap_size = len(array)
    for j in range(int(heap_size/2), -1, -1):
        Min_Heapify(array, j)
    return array

heap_size = None
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
    t1=time.time()
    temp = list[k:]
    ans = Build_Heap(temp)
    temp2 = list[:k]
    for i in range(0,len(temp2)):
        if ans[0]<=temp2[i]:
            ans[0] = temp2[i]
            Min_Heapify(ans,0)
    print(ans)    
    t2=time.time()
    print (t2-t1)
    topk= list[n-k:]
    with open ("Output_MinHeapSortTopKElements.txt","w")as fp:
        fp.write("the %d top elements are:\n"%k)
        for line in ans:
            fp.write(str(line)+"\n")        
print ("done")

