
import sys
import time

#for given element in array find its correct position in the heap
def Max_Heapify(array, i):
    l = 2*i+1
    r = 2*i+2
    if l < heap_size and array[l] > array[i]:
        largest = l
    else:
        largest = i
    if r < heap_size and array[r] > array[largest]:
        largest = r
    if largest != i:
        temp = array[i]
        array[i] = array[largest]
        array[largest] = temp
        Max_Heapify(array, largest)

#for given array convert them in heap structure
def Build_Heap(array):
    global heap_size
    heap_size = len(array)
    for j in range(int(len(array)/2), -1, -1):
        Max_Heapify(array, j)

#perform the sorting function for the list after creating its heap structure
def Heap_Sort(array):
    Build_Heap(array)
    global heap_size
    for i in range(len(array)-1, -1, -1):
        temp = array[0]
        array[0] = array[i]
        array[i] = temp
        heap_size -= 1
        Max_Heapify(array, 0)

# return the top element in heap which is largest
def Return_Max(array):
    Max_Heapify(array, 0)
    return array[0]

#a = [2, 7, 3, 9, 1, 4, 8, 6, 5, 0]
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
    Heap_Sort(list)
    t2=time.time()
    print (t2-t1)
    with open ("Output_HeapSort.txt","w")as fp:
        fp.write("Using Heap Sort:\n")
        fp.write("The Sorted order for the array:\n")
        for line in list:
            fp.write(str(line)+"\n")
print ("Success")

