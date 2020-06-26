import java.util.*;
public class InsertionSort {
static void sort(int a[],int size)
{
	for(int i=1;i<size;i++)
	{
	  int current=a[i];
	  int j=i;
	  while(j>0 && a[j-1]>current)
	  {
		  a[j]=a[j-1];
		  j--;
	  }
	  a[j]=current;
	}
	for(int i=0;i<size;i++)
	{
		System.out.print(a[i]+" ");
	}
	System.out.println();
}
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int size=sc.nextInt();
int a[]=new int[size];
for(int i=0;i<size;i++)
{
	a[i]=sc.nextInt();
}
sort(a,size);
}
}
