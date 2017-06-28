package example;

public class MinCostPath {
	public static int MinPathCalculate(int[][] arr, int m, int n) {
		int Cost[][] = new int[m + 1][n + 1];
		Cost[0][0] = arr[0][0];
		for (int i = 1; i <= m; i++)
			Cost[i][0] = Cost[i - 1][0] + arr[i][0];
		for (int j = 1; j <= n; j++)
			Cost[0][j] = Cost[0][j - 1] + arr[0][j];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				Cost[i][j] = min(Cost[i - 1][j - 1], Cost[i - 1][j], Cost[i][j - 1]) + arr[i][j];
			}
		}
		return Cost[m][n];
	}

	private static int min(int i, int j, int k) {
		// TODO Auto-generated method stub
		int min = i;
		if (j < min)
			min = j;
		if (k < min)
			min = k;
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3 }, {4,8,2}, {1,5,3} };
		System.out.println(MinPathCalculate(arr, 2, 2));
	}

}
