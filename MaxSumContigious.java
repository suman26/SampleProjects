package example;

public class MaxSumContigious {
    
	public static int maxSum(int [] arr,int n)
	{
		int maxSum=0;
		int []M=new int [n];
		if(arr[0]>0)
			M[0]=arr[0];
		else
			M[0]=0;
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=i;j++)
			{
				if(M[i-1]+arr[j]>0)
					M[i]=M[i-1]+arr[j];
				else
					M[i]=0;
			}
		}
		for(int i=0;i<n;i++)
		{
			if(M[i]>=maxSum)
				maxSum=M[i];
		}
		return maxSum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int []arr={-2,-3,-1};
		System.out.println(maxSum(arr,3));
	}

}
