//cutting rod //
package example;

public class CuttingRod {
     
	public static int cuttingRod(int []price,int n)
	{
		int val[]=new int [n+1];
		val[0]=0;
		for(int i=1;i<=n;i++)
		{
			int max_val=Integer.MIN_VALUE;
			for(int j=0;j<i;j++)
			{
				max_val=Math.max(max_val,price[j]+val[i-j-1]);
			}
			val[i]=max_val;
		}
		return val[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int a[]={1,5,8,9,10,17,17,20};
      System.out.println(cuttingRod(a,8));
	}

}
