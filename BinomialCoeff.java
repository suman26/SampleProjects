//Binomial coefficent 
package example;

public class BinomialCoeff {
    public static int calculateBc(int n,int k)
    {
    	if(n<0 ||k<0)
    		return 0;
    	int coeff[][]=new int [n+1][k+1];
    	
    	coeff[0][0]=1;
        for(int i=1;i<=n;i++)
        {
        	for(int j=0;j<=min(i,k);j++)
        	{
        		if(i==j ||j==0)
        		{
        			coeff[i][j]=1;
        		}
        		else
        			coeff[i][j]=coeff[i-1][j-1]+coeff[i-1][j];
        			
        	}
        }
    	return coeff[n][k];
    }
	private static int min(int i, int k) {
		// TODO Auto-generated method stub
		return i>=k?k:i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculateBc(5,4));
	}

}
