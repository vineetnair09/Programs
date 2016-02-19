
import java.io.*;
class Cqueue
{
	private int items[];
	private int f,r,size;
	public Cqueue(int no)
	{
		size=no;
		items=new int[10];
		f=r=-1;
	}
	public void enqueue(int ele)
	{
		if(isFull())
		{
			System.out.println("Queue Overflow");
			return;
		}
		else
		{
			if(f==-1 && r==-1)
			{	
			f=0;
			}
				items[++r]=ele;
			}
			if(!isFull() && r==(size-1))
			{
				r=0;
			}
			
		}
		public int dequeue()
			{	int x;
				if(isEmpty())
				{
					System.out.println("Queue Empty");
					return(-1);
				}
				else
				{
					x=items[f];
					f++;
				}
				if(f==(size-1))
				{
					f=0;
				}
				return(x);	
			}
			public int peek()
			{			
				if(isEmpty())
				{
					System.out.println("Queue Empty");
					return(-1);
				}
				else
				{
					int x=items[f];
					return(x);	
				}
			}
			public void display()
			{
				if(isEmpty())
				{
					System.out.println("Queue Empty");
				}
				if(r>f)
				{
					for(int i=f;i<=r;i++)
					{
						System.out.print(items[i]+"\t");
					}
				}
				else if(f>r)
				{
					for(int i=f;i<=(size-1);i++)
					{
						System.out.println(items[i]);
					}
					for(int i=0;i<=r;i++)
					{
						System.out.println(items[i]);
					}
				}
				System.out.println();
			}
			public boolean isFull()
			{
				if((f==0&&r==(size-1))||(r==(f-1)))
				{
					return(true);	
				}
				else
				{
					return(false);
				}
			}
			public boolean isEmpty()
			{
				if((f==-1 && r==1)||(r<f))
				{
					return(true);
				}
				else
				{
					return(false);
				}
				
			}
}
class CqueueDemo
{
	public static void main(String args[])throws Exception
	{
		DataInputStream obj=new DataInputStream(System.in);
		System.out.println("Please enter the queue size:");
		int n=Integer.parseInt(obj.readLine());
		Cqueue q1=new Cqueue(n);
        int ch;
       
       do
       {
           System.out.println("##########MENU##########");
           System.out.println("1]Enqueue");
           System.out.println("2]Dequeue");
           System.out.println("3]Peek");
           System.out.println("4]Display");
           System.out.println("5]End");
           System.out.println("########################");
           ch=Integer.parseInt(obj.readLine());
         
           switch(ch)
           {
               case 1:
               {    System.out.println("Please enter the number to be pushed:");
                    int no=Integer.parseInt(obj.readLine());
                    q1.enqueue(no);
                    break;
               }
               case 2:
               {
                   System.out.println(q1.dequeue());
                   break;
               }
               case 3:
               {
                 System.out.println(q1.peek());
                 break;
               }
               case 4:
               {
                   q1.display();
                   break;
               }
               case 5:
               {
                  break;
               }
                   
               default:
               {
                   System.out.println("Invalid Option");
                   break;
               }
           }
       }
       while(ch!=5);
    }
}
/*
 OUTPUT:
 Please enter the queue size:
4
##########MENU##########
1]Enqueue
2]Dequeue
3]Peek
4]Display
5]End
########################
1
Please enter the number to be pushed:
1
##########MENU##########
1]Enqueue
2]Dequeue
3]Peek
4]Display
5]End
########################
1
Please enter the number to be pushed:
2
##########MENU##########
1]Enqueue
2]Dequeue
3]Peek
4]Display
5]End
########################
1
Please enter the number to be pushed:
3
##########MENU##########
1]Enqueue
2]Dequeue
3]Peek
4]Display
5]End
########################
1
Please enter the number to be pushed:
4
##########MENU##########
1]Enqueue
2]Dequeue
3]Peek
4]Display
5]End
########################
1
Please enter the number to be pushed:
5
Queue Overflow
##########MENU##########
1]Enqueue
2]Dequeue
3]Peek
4]Display
5]End
########################
4
1	2	3	4	
##########MENU##########
1]Enqueue
2]Dequeue
3]Peek
4]Display
5]End
########################
2
1
##########MENU##########
1]Enqueue
2]Dequeue
3]Peek
4]Display
5]End
########################
2
2
##########MENU##########
1]Enqueue
2]Dequeue
3]Peek
4]Display
5]End
########################
3
3
##########MENU##########
1]Enqueue
2]Dequeue
3]Peek
4]Display
5]End
########################
1
Please enter the number to be pushed:
5
##########MENU##########
1]Enqueue
2]Dequeue
3]Peek
4]Display
5]End
########################
1
Please enter the number to be pushed:
6
##########MENU##########
1]Enqueue
2]Dequeue
3]Peek
4]Display
5]End
########################
4
3	4	5	6	
##########MENU##########
1]Enqueue
2]Dequeue
3]Peek
4]Display
5]End
########################
5
Process Exit.....
*/