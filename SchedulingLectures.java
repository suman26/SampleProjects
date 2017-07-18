
//Given aset of lectures target is to reduce the buffer time in between  the lectures.
//Given a time limit as W and each lecture has some time slot try to mininze the buffer time by scheduling lectures 
// in any order 
public class SchedulingLectures {

	static int max(int a, int b) { return (a > b)? a : b; }
	 
	   
    static int schedulingLectures(int W, int wt[], int val[], int n)
    {
         int i, w;
	 int K[][] = new int[n+1][W+1];
	 
	
	 for (i = 0; i <= n; i++)
	 {
	     for (w = 0; w <= W; w++)
	     {
	         if (i==0 || w==0)
	              K[i][w] = 0;
	         else if (wt[i-1] <= w)
	               K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
	         else
	               K[i][w] = K[i-1][w];
	     }
	  }
	 
	  return K[n][W];
    }

    public static void main(String args[])
    {
    	
    int LectureDurations[] = new int[]{10,35, 29,20,25,28,29};
    
	int  DurationInDay = 50;
	int n = LectureDurations.length;
	System.out.println("Maximum timeslot utilized :"+schedulingLectures(DurationInDay, LectureDurations, LectureDurations, n));
    }
}
