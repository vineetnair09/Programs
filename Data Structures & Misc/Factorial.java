import java.io.*
class Fact
{
public static void main(String args[])throws IOException
{
	int no;
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferredReader(isr);
	System.out.print("Enter an integer no:");
	no=Integer.parseInt(br.readline());
	factorial=fact(no);
	System.out.print("Factorial:"+factorial);
}

static int fact(int n)
{
if n==0
return 0;
if n==1
return 0;
else 
	return n*fact(n-1);
}
	

}	

