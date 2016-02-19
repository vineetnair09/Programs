
 import java.io.*;
 class QueueEx
 {  
 	int f=-1,r=-1;
 	int q[];
	int size;
	QueueEx(int n)
	{
		size=n;
		q=new int[size];
	}
	QueueEx()
	{
		size=10;
		q=new int[size];
	}
	void enqueue(int v)
	{
		if ((f==0 && r==size-1)|| (f==r+1))
		{
			System.out.print("Queue overflow");
		return;
    	}	
		else
			++r;
		if(r==size)
			r=0;
		q[r]=v;
		if(f==-1)	
			f++;
	}
	int dequeue()
	{
		if (isEmpty())
		{
		System.out.print("Queue underflow");	
		return 0;
		}
		else
		{
			int a=q[f];
			f++;
			if(f==r+1)
				f=r=-1;
			if(f==size)
			f=0;
			return(a)	;
		}
	}
	int peek()
	{
		if (isEmpty())
		{
			System.out.print("Queue underflow");
			return 0;
		}
			else
				return(q[f]);		
	}
	boolean isEmpty()
	{
		if(f==-1)
		return true;
	else 
	    return false;
	}      	
	void display()
	{
		if(isEmpty())
			System.out.println("Queue underflow");
		else
		{
		int i=f;
		while(i!=r)
		{
		 System.out.print(q[i]+" ");
		 i=(i+1)%size;
		}
		 System.out.print(" "+q[i]);
		}
		}
		 
}
 class CircularqueueEx
 {
 	public static void main(String args[])throws Exception
 	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		System.out.println("Enter the size of queue:");
		int s=Integer.parseInt(br.readLine());
		QueueEx qu=new QueueEx(s);
		boolean g=false;
		do
		{
	    
		System.out.println("\n 1.Enqueue:");
		System.out.println("\n 2.Dequeue:");
		System.out.println("\n 3.Peek:");
		System.out.println("\n 4.Exit");
		System.out.println("Selelct any choice:");
		int ch=Integer.parseInt(br.readLine());
		
		switch (ch)
		{
			
		case 1:	System.out.println("Enter the element:");
	            int v=	Integer.parseInt(br.readLine());
				qu.enqueue(v);
				qu.display();
				break;
		case 2:	System.out.println("Element deleted is:"+qu.dequeue());
	            qu.display();
				break;
		case 3:	System.out.println("Element is:"+qu.peek());
	            qu.peek();
				break;
		case 4:	g=false;
		}
 	}
		while(!g);
 	}
 }
 
		
/*
OUTPUT:

Enter the size of queue:
3

 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
1
Enter the element:
12
 12
 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
1
Enter the element:
13
12  13
 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
1
Enter the element:
14
12 13  14
 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
1
Enter the element:
15
Queue overflow12 13  14
 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
2
Element deleted is:12
13  14
 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
2
Element deleted is:13
 14
 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
1
Enter the element:
16
14  16
 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
1
Enter the element:
17
14 16  17
 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
1
Enter the element:
18
Queue overflow14 16  17
 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
2
Element deleted is:14
16  17
 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
2
Element deleted is:16
 17
 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
2
Element deleted is:17
Queue underflow

 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
1
Enter the element:
19
 19
 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit
Selelct any choice:
3
Element is:19

 1.Enqueue:

 2.Dequeue:

 3.Peek:

 4.Exit

*/		
 
	
		
			
		
			
	
    