
import java.util.*;
class Stack
{
	int s[];
	int tos=-1,size;
	Stack(int n)
	{
	size=n;
	s=new int[size];
	}
	void push(int v)
	{
		if (tos==(size-1))
		{
			System.out.println("Overflow");
			return ;
		}
		else
		++tos;
	    s[tos]=v;	
	}
    int pop()
	{
		if (tos==-1)
		{
		System.out.println("underflow");
		return -1;
		}
		else
			return s[tos--];
		
	}
		boolean isEmpty()
		{
			if(tos==-1)
				return true;
			else 
			    return  false;
		}
		int peek()
		{
			return s[tos];
		}
	}
	class Evalpostfix
	{
		Stack st;
		String postfix;
		Evalpostfix(String str)
		{
			postfix=str;
		}
		boolean isOperand(char ch)
		{
			if(ch>='0' && ch<='9')
				return true;
			else 
			return 	false;
		}
		int compute()
		{
			st=new Stack(postfix.length());
			char po[]=postfix.toCharArray();
			int i=0,a,b;
			while (i<po.length)
			{
				if(isOperand(po[i]))
					st.push(po[i]-'0');
				else
				{
				a=st.pop();
				b=st.pop();
				switch (po[i])
				{
				case '+' :st.push(a+b);
						  break;		
				case '-' :st.push(b-a);
						  break;		
				case '*' :st.push(a*b);
						  break;		 
				case '/' :st.push(b/a);
						  break;	 	
				case '%' :st.push(b%a);
						 
				}
				}
				++i;
			}
			return(st.pop());
		   }
		   public static void main(String args[])
		   {
		   	//Scanner scr=new Scanner(System.in);
			System.out.println("Enter the postfix exp:");
			//String input=scr.nextLine();
			String input="23+65-*";
			Evalpostfix obj=new Evalpostfix(input);
			System.out.println(input+"evaluates to:"+obj.compute());
		   }
	}
		
			
				
			
	
