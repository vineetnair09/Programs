# -*- coding: utf-8 -*-
"""
Created on Thu Dec 03 23:03:30 2015

@author: vineet
"""

import sys
import time
import random
#find smallest element for k
def ksmallest(arr,l,r,k):
    if k>0 and k<=r-l+1:
        pos=randompartition(arr,l,r)
        if pos-l == k-1:
            return arr[pos]
        if pos-l > k-1:
            return ksmallest(arr,l,pos-1,k)
        return ksmallest(arr,pos+1,r,k-pos+l-1)
    return 10000000000000000

#To return pivot element's index 
def partition(arr,l,r):
    pivot=arr[r]
    i=l
    for j in range(l,r):
        if pivot>=arr[j]:
            swap(arr,i,j)
            i+=1
    swap(arr,i,r)
    return i

def randompartition(arr,l,r):
    n=r-l+1
    pivot=random.randint(0,n-1)
    swap(arr,l+pivot,r)
    return partition(arr,l,r)


def swap(arr,i,r):
    arr[i], arr[r] = arr[r], arr[i]

content = [line.rstrip('\t') for line in open('Input_1K.txt')]
k,n=content[0].split()
k=int(k)
n=float(n)
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
    ksmall = ksmallest(list,start,end,k)
    t2=time.time()
    print (t2-t1)
    print (ksmall)
    with open ("Output_OrderStatistics_KthsmallestElementExpectedLinearTime.txt","w")as fp:
        fp.write("The %d smallest element is:\n"%k)
        fp.write(str(ksmall)+"\n")