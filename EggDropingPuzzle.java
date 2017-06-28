package example;

public class EggDropingPuzzle {

	public static int calculate(int n,int k)
	{
		int [][]res=new int[n+1][k+1];
	    int value=0;
		for(int i=1;i<=n;i++)
		{
			res[i][0]=0;
			res[i][1]=1;
		}
		for(int j=1;j<=k;j++)
		{
			res[1][j]=j;
		}
		for(int i=2;i<=n;i++)
		{
			for(int j=2;j<=k;j++)
			{
				res[i][j]=Integer.MAX_VALUE;
				for(int x=1;x<=j;x++)
				{
					value=1+Math.max(res[i-1][x-1], res[i][j-x]);
					if(value<res[i][j])
						res[i][j]=value;
				}
			}
		}
	return res[n][k];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(calculate(2,36));
	}

}
