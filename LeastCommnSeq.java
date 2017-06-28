package com.citi.tds.dna.consumer.externalenricher.qps;

public class LeastCommnSeq {

	public static int calculateLcs(char[]X,char []Y,int m,int n)
	{
		int L[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++)
			L[i][0]=0;
		for(int j=0;j<=n;j++)
			L[0][j]=0;
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(X[i-1]==Y[j-1])
					L[i][j]=L[i-1][j-1]+1;
				else
					L[i][j]=max(L[i-1][j],L[i][j-1]);
			}
		}
		printLcs(X, Y, m, n, L);
		return L[m][n];
		
	}
	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		return i>=j?i:j;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LcsNormal();
		LongestPallindromicSeq();

	}
	public static void LcsNormal()
	{
		String str1 = "somepString";	
		int m = str1.length();
		char[] X = str1.toCharArray();
		String str2 = "somepStringdfgfd";
		int n = str2.length();
		char[] Y = str2.toCharArray();
		System.out.println(calculateLcs(X, Y, m, n));
	}
	public static void LongestPallindromicSeq()
	{
		String str1 = "sdabbaqwerty";	
		int m = str1.length();
		char[] X = str1.toCharArray();
		StringBuilder sb =new StringBuilder();
		sb.append(str1);
		sb=sb.reverse();
		char Y[]=sb.toString().toCharArray();
		System.out.println(calculateLcs(X,Y,m,m));
	}
	public static void printLcs(char[]X,char[] Y,int m,int n,int[][]lcs)
	{
		int index=lcs[m][n];
		char[]res=new char[index+1];
		res[index]='\0';
		index=index-1;
		while(m>0 && n>0)
		{
		 	if(X[m-1]==Y[n-1])
		 	{
		 		res[index]=X[m-1];
		 		m=m-1;
		 		n=n-1;
		 		index=index-1;
		 	}
		 	else if(X[m-1]!=Y[n-1])
		 	{
		 		if(lcs[m][n-1]>lcs[m-1][n])
		 		{
		 			n=n-1;
		 		}
		 		else
		 			m=m-1;
		 	}
		}
		System.out.println(res);

	}

}
