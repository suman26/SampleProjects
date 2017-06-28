package com.citi.tds.dna.consumer.externalenricher.qps;

public class EditDist {

   public static int calculateEdit(char[] X,char[] Y,int m ,int n)
   {
	   int res[][]=new int [m+1][n+1];
	   
	   for(int i=0;i<=m;i++)
	   {
		   res[i][0]=i;
	   }
	   for(int j=0;j<=n;j++)
	   {
		   res[0][j]=j;
	   }
	   for(int i=1;i<=m;i++)
	   {
		   for(int j=1;j<=n;j++)
		   {
			   if(X[i-1]==Y[j-1])
				   res[i][j]=res[i-1][j-1];
			   else
				   res[i][j]=1+ min(res[i-1][j],res[i][j-1],res[i-1][j-1]);
		   }
	   }
	   
	   return res[m][n];
   }
	private static int min(int i, int j, int k) {
	// TODO Auto-generated method stub
		int min =i;
		if(min>=j)
			min=j;
		if(min>=k)
			min=k;
	return min;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "someString";	
		int m = str1.length();
		char[] X = str1.toCharArray();
		String str2 = "abcedf";
		int n = str2.length();
		char[] Y = str2.toCharArray();
		System.out.println(calculateEdit(X, Y, m, n));

	}

}
