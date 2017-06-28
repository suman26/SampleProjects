//bINARY SEQUENCE generation 
package example;

public class BinarySeqCount {

	public static int binSeqCount(int n)
	{
		int []a=new int [n];
		int []b=new int[n];
		if(n<=0)
			return 0;
		a[0]=1;
		b[0]=1;
		for(int i=1;i<n;i++)
		{
			a[i]=a[i-1]+b[i-1];
			b[i]=a[i-1];
		}
		return a[n-1]+b[n-1];
	}
	public static int binSeqCountTernery(int n)
	{
		int []a=new int [n];
		int []b=new int[n];
		if(n<=2)
			return 0;
		a[0]=1;
		b[0]=1;
		a[1]=2;
		b[1]=2;
		a[2]=4;
		b[2]=3;
		for(int i=3;i<n;i++)
		{
			a[i]=a[i-1]+b[i-1];
			b[i]=a[i-1]+b[i-2];
		}
		return a[n-1]+b[n-1];
	}
	
	public static int totalNoThreeConsecutiveOnes(int n)
	{
		int []a=new int [n];
		a[0]=2;
		a[1]=4;
		a[2]=7;
		for(int i=3;i<n;i++)
			a[i]=a[i-1]+a[i-2]+a[i-3];
		
		return a[n-1];
	}
	
	public static int binSeqCountAll(int n)
	{
		int []a=new int [n];
		int []b=new int[n];
		if(n<=0)
			return 0;
		a[0]=1;
		b[0]=1;
		for(int i=1;i<n;i++)
		{
			a[i]=a[i-1]+b[i-1];
			b[i]=a[i-1]+b[i-1];
		}
		return a[n-1]+b[n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("binary sequence count containing no consecutive 1's:"+binSeqCount(3));
       System.out.println("binary sequence count containg all combinations:"+binSeqCountAll(3));
       System.out.println("binary sequence count containg all combinations containing at least 1 consecutive 1's:"+(binSeqCountAll(3)-binSeqCount(3)));
	   System.out.println("binary sequence count containing no  three consecutive 1's:"+binSeqCountTernery(5));
	   System.out.println("binary sequence count containing three consecutive 1's:"+(binSeqCountAll(5)-binSeqCountTernery(5)));
	   System.out.println(totalNoThreeConsecutiveOnes(4));
	}

}
