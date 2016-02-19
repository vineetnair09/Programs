import java.io.*;

class Nodetype
{
	int info;
	Nodetype next;

	Nodetype(int i)
	{
		info=i;
		next=null;
	}
}

class Operations
{
Nodetype list=null;


void display()
{

	Nodetype temp;
	if(list==null)
		System.out.println("\nEmpty linked list");
	else
	{
		temp=list;
		//System.out.println("\n"+temp);
		System.out.println();

		while(temp!=null)
		{
			System.out.print("-->"+temp.info);
			temp=temp.next;
		}
	}
}

void insertbeg(int x)
{
	Nodetype node=new Nodetype(x);
	node.next=list;
	list=node;
	
}

void deletebeg()
{
	if(list==null)
		System.out.println("\nEmpty Linked List");
	else
	{
		System.out.print("\nThe element deleted is "+list.info);
		list=list.next;
	}
	display();
}/*end deletebeg*/


void insertend(int x)
{
	Nodetype node=new Nodetype(x);
	node.info=x;
	node.next=null;
	Nodetype temp;
	temp=list;
	if(temp==null)
	{
		list=node;
	}
	else
	{
		while(temp.next!=null)
			temp=temp.next;
		temp.next=node;
	}
	display();
}

void deleteend()
{
	Nodetype temp=null;
	Nodetype p=list;
	if(p==null)
		System.out.println("\nEmpty Linked List");
	else
	{
		while(p.next!=null)
		{
			temp=p;
			p=p.next;
		}
		System.out.print("\nThe element deleted is "+p.info);
		temp.next=null;
	}
	display();
}

void insloc(int p,int x)
{
	int i;
	Nodetype temp=list;
	for(i=0;i<(p-2);i++)
	{
		if(temp==null)
			break;
		temp=temp.next;

	}
	if(temp!=null)
	{
		Nodetype node=new Nodetype(x);
		node.next=temp.next;
		temp.next=node;
	}
	display();
}

void delloc(int p)
{
	int i;
	Nodetype temp=list;
	Nodetype t=null;
	if(p==1)
		list=list.next;
	for(i=0;i<p-1;i++)
	{
		if(temp.next==null)
		{
		System.out.print("\nThere are less than "+p+" elements in list ");
		break;
		}
		t=temp;
		temp=temp.next;
	}
	if(i==p-1)
	{
		System.out.print("\nThe element deleted is "+temp.info);
		t.next=temp.next;
	}
	display();
}

void search(int x)
{
/*search an element in linked list and return its location*/
	int i=1;
	Nodetype q;
	if(list==null)
		System.out.println("\nList is empty");
	else
	{
		q=list;
		do
		{
			if(q.info==x)
			{
				System.out.println("\nElement found at location "+i);
				break;
			}
			i++;
			q=q.next;
		}
		while(q!=null);
		if(q==null)
		System.out.println("\nElement not found");
	}
}

}


class DynamicLL
{
public static void main(String args[])throws Exception
{
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	Operations L =new Operations();
	int ch,v,x;
	boolean stop=false;
	do
	{
	System.out.println("Menu:");
	System.out.println("1.Insert at beginning:");
	System.out.println("2.Insert at end:");
	System.out.println("3.Insert at particular location:");
	System.out.println("4.Delete at beginning:");
	System.out.println("5.Delete at end:");
	System.out.println("6.Delete particular location:");
	System.out.println("7.Search:");
	System.out.println("8.display:");
	System.out.println("9.Exit:");
	System.out.println("Select any condition:");
	ch=Integer.parseInt(br.readLine());
	switch(ch)
	{
	case 1:    System.out.println("Node to be inserted:");
	               v=Integer.parseInt(br.readLine());
		L.insertbeg(v);
	
		break;
	case 2:    System.out.println("Node to be inserted:");
	               v=Integer.parseInt(br.readLine());
		L.insertend(v);
		
	
		break;
	case 3:	System.out.println("Node to be inserted:");
	               v=Integer.parseInt(br.readLine());
				   System.out.println("Enter the location:");
		 x=Integer.parseInt(br.readLine());  
		L.insloc(v,x);
		
		
		break;
	case 4:     L.deletebeg();
		System.out.println("Node deleted is:");
		System.out.println("Linked List:");
		L.display();
		break;
	case 5:      L.deleteend();
		System.out.println("Node deleted is:");
		System.out.println("Linked List:");
		L.display();
		break;
	case 6:System.out.println("Enter the location:");
		 v=Integer.parseInt(br.readLine());  
		 L.delloc(v);
		System.out.println("Node deleted is:");
		System.out.println("Linked List:");
		L.display();
		break;
	case 7:    System.out.println("Element to be searched:");
	               v=Integer.parseInt(br.readLine());
		L.search(v);
		System.out.println("Linked List:");
		L.display();
		break;
	case 8:L.display();break;
	case 9:stop=true;
	}
	}
	while(!stop);
	}
	}
	

/*
OUTPUT:

*/