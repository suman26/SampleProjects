package example;

public class longestBitonicSubseq {

	 public static int  calculateLis(int []arr,int n)
	 {
		 int Lis[]=new int [n];
		 int Lid[]=new int[n];
		 int res=0;
		 for(int i=0;i<n;i++)
			 Lis[i]=1;
		 for(int j=0;j<n;j++)
			 Lid[j]=1;
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<=i;j++)
			 {
				 if(arr[i]>arr[j]&& Lis[i]<Lis[j]+1)
					 Lis[i]=Lis[j]+1; 
			 }
		 }
		 for(int i=n-1;i>=0;i--)
		 {
			 for(int j=n-1;j>=i;j--)
			 {
				 if(arr[i]>arr[j]&& Lid[i]<Lid[j]+1)
					 Lid[i]=Lid[j]+1; 
			 }
		 }
			 res=Lid[0]+Lis[0]-1;
			 for(int i=0;i<n;i++)
			 {
				 if((Lis[i]+Lid[i]-1)>res)
					 res=Lis[i]+Lid[i]-1;
			 }
			return res;
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
	     System.out.println(calculateLis(arr,16));
	}

}
