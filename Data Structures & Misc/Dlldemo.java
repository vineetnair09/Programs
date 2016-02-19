import java.io.*;
class node
{
	int data;
	node prev,next;
	public node()
	{
		prev=next=null;
		data=0;
	}
}
class Dll
{
	node start,last,current=null;
	public void createlist(int x)
	{
		node p=new node();
		p.data=x;
		start=last=p;
	}
	public void insertatfirst(int x)
	{
		if (start==null)
		{
			createlist(x);
		}
		else
		{
			node p=new node();
			p.data=x;
			p.next=start;
			start=p;
		}
	}
	public void insertatlast(int x)
	{
		if (start==null)
		{
			createlist(x);
		}
		else
		{
			node p=new node();
			p.data=x;
			p.prev=last;
			last.next=p;
			last=p;
		}
	}
	public void insertafter(int x,int p1)
	{
		if (start==null)
		{
			createlist(x);
		}
		else
		{
			if (p1>0)
			{
				int i=1;
				current=start;
				while (current!=null)
				{
					if (i==p1)
					{
						node p=new node();
						p.data=x;
						p.next=current.next;						
						p.prev=current;
						current.next=p;
						current.next.prev=p;
						return;
					}
					else
					{
						current=current.next;
						i++;
					}
				}
			}
			else
			{
				System.out.println("Invalid position");
			}
		}
	}
	public void insertbefore(int x,int p1)
	{
		if (start==null)
		{
			createlist(x);
		}
		else
		{
			if (p1>0)
			{
				int i=0;//Before condition
				current=start;
				while (current!=null)
				{
					if (i==p1-1)
					{
						node p=new node();
						p.data=x;
						p.next=current.next;						
						p.prev=current;
						current.next=p;
						current.next.prev=p;
						return;
					}
					else
					{
						current=current.next;
						i++;
					}
				}
			}
			else
			{
				System.out.println("Invalid position");
			}
		}
	}
	public int search(int x)
	{
		current=start;
		int i=1;
		while (current!=null)
		{
			if(current.data==x)
				return i;
			else
			{
				current=current.next;
				i++;
			}
		}		
		return(-1);
	}
	public void displayf()
	{
		current=start;
		while (current!=null)
		{
			System.out.print(current.data+" ");
			current=current.next;
		}
	}
	public void displayr()
	{
		current=last;
		while (current!=null)
		{
			System.out.print(current.data+" ");
			current=current.prev;
		}
	}
	public int deletefirst()
	{
		if (start==null)
		{
			System.out.println("No nodes");
			return 0;
		}
		else
		{
			int x=start.data;
			start=start.next;
			start.prev=null;
			return x;
		}
	}
	public int deletelast()
	{
		if (start==null)
		{
			System.out.println("No nodes");
			return 0;
		}
		else
		{
			int x=last.data;
			last=last.prev;
			last.next=null;
			return x;
		}
	}
	public int deletesp(int p)
	{
		int y=0;
		if (start==null)
		{
			System.out.println("No nodes");
			y=0;
		}
		else
		{
			if (p>0)
			{	
				int i=1;
				current=start;
				while (i!=p)
				{
					if (i==p)
					{
						y=current.data;
						current.prev.next=current.next;
						current.next.prev=current.prev;
					}
					else
					{
						current=current.next;
						i++;
					}
				}
			}
		}
		return y;
	}
}
class Dlldemo
{
	public static void main(String ankur[])throws IOException
	{
		BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
		Dll dll=new Dll();
		int ch;
		do
		{
			System.out.println();
			System.out.println("MENU");
			System.out.println("1.Insert");
			System.out.println("2.Remove");
			System.out.println("3.Display list");
			System.out.println("4.Search");
			System.out.println("5.Exit");
			System.out.println("Select Option");
			ch=Integer.parseInt(obj.readLine());
			switch (ch)
			{
			case 1:	{
						System.out.println("1.Insert At First Postion");
						System.out.println("2.Insert At last position");
						System.out.println("3.Insert after");
						System.out.println("4.Insert before");
						System.out.println("Select Option");
						int i11=Integer.parseInt(obj.readLine());
						switch (i11)
						{
						case 1:	{
									System.out.println("Enter element:");
									int i111=Integer.parseInt(obj.readLine());
									dll.insertatfirst(i111);
									break;
								}
						case 2:	{
									System.out.println("Enter element:");
									int i112=Integer.parseInt(obj.readLine());
									dll.insertatlast(i112);
									break;
								}
						case 3:	{
									System.out.println("Enter element:");
									int i113x=Integer.parseInt(obj.readLine());
									System.out.println("Enter postion:");
									int i113p=Integer.parseInt(obj.readLine());	
									dll.insertafter(i113x,i113p);
									break;
								}
						case 4:	{ 
									System.out.println("Enter element:");
									int i114x=Integer.parseInt(obj.readLine());
									System.out.println("Enter postion:");
									int i114p=Integer.parseInt(obj.readLine());	
									dll.insertafter(i114x,i114p);
									break;
								}
						}
						break;
					}
			case 2:	{
						System.out.println("1.Delete First element");
						System.out.println("2.Delete last element");
						System.out.println("3.Delete specific element");
						System.out.println("Select Option");
						int i2=Integer.parseInt(obj.readLine());
						switch (i2)
						{
						case 1:
							{
								int i22=dll.deletefirst();
								System.out.println("deleted element="+i22);
								break;
							}
						case 2:
							{
								int i23=dll.deletelast();
								System.out.println("deleted element="+i23);
								break;
							}
						case 3:
							{
								System.out.println("Enter position of element");
								int i24t=Integer.parseInt(obj.readLine());
								int i24=dll.deletesp(i24t);
								System.out.println("deleted element="+i24);
								break;
							}
						}
					break;
					}
			case 3:	{
						System.out.println("1.Display in forward direction");
						System.out.println("2.Display in reverse direction");
						System.out.println("Select Option");
						int i31=Integer.parseInt(obj.readLine());
						switch (i31)
						{
						case 1:dll.displayf();break;
						case 2:dll.displayr();break;
						}
					break;
					}
			case 4:	{
						System.out.println("Enter elemnet you want to search");
						int i41=Integer.parseInt(obj.readLine());
						int i42=dll.search(i41);
						System.out.println("Element is at="+i42);
						break;
					}
			}
		}while(ch!=5);
	}
}


/*
OUTPUT:
MENU
1.Insert
2.Remove
3.Display list
4.Search
5.Exit
Select Option
1
1.Insert At First Postion
2.Insert At last position
3.Insert after
4.Insert before
Select Option
1
Enter element:
12
MENU
1.Insert
2.Remove
3.Display list
4.Search
5.Exit
Select Option
1
1.Insert At First Postion
2.Insert At last position
3.Insert after
4.Insert before
Select Option
2
Enter element:
15

MENU
1.Insert
2.Remove
3.Display list
4.Search
5.Exit
Select Option
1
1.Insert At First Postion
2.Insert At last position
3.Insert after
4.Insert before
Select Option
3
Enter element:
13
Enter postion:
2
MENU
1.Insert
2.Remove
3.Display list
4.Search
5.Exit
Select Option
1
1.Insert At First Postion
2.Insert At last position
3.Insert after
4.Insert before
Select Option
4
Enter element:
14
Enter postion:
3

MENU
1.Insert
2.Remove
3.Display list
4.Search
5.Exit
Select Option
3
1.Display in forward direction
2.Display in reverse direction
Select Option
1
12 15 13 14 
MENU
1.Insert
2.Remove
3.Display list
4.Search
5.Exit
Select Option
2
1.Delete First element
2.Delete last element
3.Delete specific element
Select Option
3
Enter position of element
2
deleted element=0

MENU
1.Insert
2.Remove
3.Display list
4.Search
5.Exit
Select Option
4
Enter elemnet you want to search
14
Element is at=4

MENU
1.Insert
2.Remove
3.Display list
4.Search
5.Exit
Select Option
3
1.Display in forward direction
2.Display in reverse direction
Select Option
2
15 12 
MENU
1.Insert
2.Remove
3.Display list
4.Search
5.Exit
Select Option
5
*/