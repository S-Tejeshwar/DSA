import java.util.*;
public class SelectionSort {
static void sort(int a[],int size)
{
   for(int i=0;i<size-1;i++)
   {
	   int min=i;
	   for(int j=i+1;j<size;j++)
	   {
		   if(a[j]<a[min])
		   {
			   min=j;
		   }
	   }
	   int temp=a[i];
	   a[i]=a[min];
	   a[min]=temp;
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
