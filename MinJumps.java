package com.citi.tds.dna.consumer.externalenricher.qps;

public class MinJumps {

	public static int countJumps(int n)
	{
		int res[]=new int[n+1];
		res[0]=0;
		res[1]=1;
		res[2]=2;
		for(int i=3;i<=n;i++)
		{
			res[i]=res[i-1]+res[i-2];
		}
		return res[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(countJumps(5));
	}

}
