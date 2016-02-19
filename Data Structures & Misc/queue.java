import java.io.*;

class queue1
{
	int size,f,r,stk[];
	public queue1()
	{
		size=10;
		stk=new int[size];
		f=0;
		r=-1;
	}
	public boolean isempty()
	{
		if(r<f)
			return(true);
		else
			return(false);	
	}
	public boolean isfull()
	{
		if(r==(size-1))
			return(true);
		else
			return(false);	
	}
	public void enqueue()
	{
		if(isfull())
			System.out.println("Queue Overflow");
		else
		{
			try
			{
				DataInputStream d=new DataInputStream(System.in);
				System.out.print("Enter Enqueue Element : ");
				int no=Integer.parseInt(d.readLine());
				stk[++r]=no;	
			}
			catch(Exception e)
			{
				System.out.println("Enter No Only");
			}
		}
	}
	public void dequeue()
	{
		if(isempty())
			System.out.println("Queue Underflow");
		else
			System.out.println(stk[f]);
			f++;	
	}
	public void peek()
	{
		if (isempty())
			System.out.println("No element available");
		else
			System.out.println("Peek Element : "+stk[f]);	
	}
	public void display()
	{
		for(int i=f;i<=r;i++)
			System.out.print("\t"+stk[i]);
	}
}
class queue
{
	public static void main(String args[])
	{
		int no=0;
		System.out.println("hello");
		queue1 q=new queue1();
		do
		{
		try
		{
			System.out.println("\n1.ENQUEUE");
			System.out.println("2.DEQUEUE");
			System.out.println("3.DISPLAY");
			System.out.println("4.PEEK");
			System.out.println("5.EXIT");
			DataInputStream d=new DataInputStream(System.in);
			no=Integer.parseInt(d.readLine());
			switch(no)
			{
				case 1:
					q.enqueue();
					break;
				case 2:
					q.dequeue();
					break;
				case 3:
					q.display();
					break;
				case 4:
					q.peek();
					break;
				case 5:	
					System.exit(0);
			}
		}
		catch(Exception e)
			{
				System.out.println("Enter Number Only");
			}
	}while(true);
	}
}
/*
 1.ENQUEUE
 2.DEQUEUE
 3.DISPLAY
 4.PEEK
 5.EXIT
 3
	10	30
 1.ENQUEUE
 2.DEQUEUE
 3.DISPLAY
 4.PEEK
 5.EXIT
 4
 Peek Element : 10 
 1.ENQUEUE
 2.DEQUEUE
 3.DISPLAY
 4.PEEK
 5.EXIT
*/
