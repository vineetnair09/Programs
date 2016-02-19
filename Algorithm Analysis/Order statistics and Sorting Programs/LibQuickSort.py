
import sys
import time

def qsort(arr):
     if len(arr) <= 1:
          return arr
     else:
          return qsort([x for x in arr[1:] if x<arr[0]]) + [arr[0]] + qsort([x for x in arr[1:] if x>=arr[0]])

content = [line.rstrip('\t') for line in open('normal_1000K.txt')]
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
    qsort(list)
    t2=time.time()
    print (t2-t1)
    with open ("Output_LibQuickSort.txt","w")as fp:
        fp.write("Using Library Quick Sort:\n")
        fp.write("The Sorted order for the array:\n")
        for line in list:
            fp.write(str(line)+"\n")
    print ("Success")
