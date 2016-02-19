import java.io.*;


class node
{
	int data;
	node left,right;

	public node(int x)
	{
		data=x;
		left=null;
		right=null;
	}
}

class BinaryST
{
	private node root=null;
	
	public void insert(int x)
	{
		if (root==null)
		{
			node p=new node(x);
			root=p;
		}
		else
			insertnew(root,x);
	}
	
	private void insertnew(node Node,int x)
	{
		if (Node.data==x)
		{
			System.out.println("Elemet already present!");
			return;
		}
			
		else if (x<Node.data)
		{
			if (Node.left==null)
			{
				node p=new node(x);
				Node.left=p;
			}
			else
				insertnew(Node.left,x);
		}	
		
		else if (x>Node.data)
		{
			if (Node.right==null)
			{
				node p=new node(x);
				Node.right=p;
			}
			else
			insertnew(Node.right,x);
		}
	}

	public void search(int x)
	{
		if (root==null)
				System.out.println("The tree is empty!");
		else
			searchnew(root,x);
	}
	
	private void searchnew(node Node,int x)
	{
		if (Node!=null)
		{
		if (Node.data==x)
			System.out.println("Element found!");
		else if (x<Node.data)
			searchnew(Node.left,x);
		else if (x>Node.data)
			searchnew(Node.right,x);
		}
		else
			System.out.println("Element not found!");	
	}
	
	
	
	public void inorder()
	{
		if (root==null)
				System.out.println("The tree is empty!");
		else
			printinorder(root);
	}
	
	private void printinorder(node Node)
	{
		if (Node!=null)
		{
			printinorder(Node.left);
			System.out.print(Node.data+" ");
			printinorder(Node.right);
		}
	}
	
	public void postorder()
	{
		if (root==null)
				System.out.println("The tree is empty!");
		else
			printpostorder(root);
	}
	
	private void printpostorder(node Node)
	{
		if (Node!=null)
		{
			printpostorder(Node.left);
			printpostorder(Node.right);
			System.out.print(Node.data+" ");
		}
	}
	
	public void preorder()
	{
		if (root==null)
				System.out.println("The tree is empty!");
		else
			printpreorder(root);
	}
	
	private void printpreorder(node Node)
	{
		if (Node!=null)
		{
			System.out.print(Node.data+" ");
			printpreorder(Node.left);
			printpreorder(Node.right);
		}
	}
}
	
class BST
{
	public static void main(String args[])throws IOException
	{
		BinaryST b=new BinaryST();
					
		DataInputStream obj=new DataInputStream(System.in);
		int choice,x;
		do
		{
		System.out.println();
		System.out.println("Enter your choice:");
		System.out.println("1) Insert");
		System.out.println("2) Search");
		System.out.println("3) Inorder ");
		System.out.println("4) Preorder");
		System.out.println("5) Postorder");
		System.out.println("6) Exit");
		
		choice=Integer.parseInt(obj.readLine());
	
		switch (choice)
		{
			case 1:
				System.out.println("Enter an element");
				x=Integer.parseInt(obj.readLine());
				b.insert(x);
				break;
				
			case 2:
				System.out.println("Enter an element");
				x=Integer.parseInt(obj.readLine());
				b.search(x);
				break;
				
			case 3:
				System.out.println("Inorder Traversal");
				b.inorder();
				break;
				
			case 4:
				System.out.println("Preorder Traversal");
				b.preorder();
				break;
				
			case 5:
				System.out.println("Postorder Traversal");
				b.postorder();
				break;
				
			case 6:
				break;
				
		}
		
		}while(choice!=6);
	}
}
