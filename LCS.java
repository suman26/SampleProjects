package example;

public class LCS {
	public static int LCSCalculate(char[] X, char[] Y, int m, int n) {
		int[][] lcs = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			lcs[i][0] = 0;
		}
		for (int j = 0; j <= n; j++) {
			lcs[0][j] = 0;
		}
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				if (X[i - 1] == Y[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		printLCS(X, Y, m, n, lcs);
		return lcs[m][n];

	}

	private static int max(int i, int j) {

		return i >= j ? i : j;
	}

	public static void printLCS(char[] X, char[] Y, int m, int n, int lcs[][]) {
		int index = lcs[m][n];
		char[] result = new char[index + 1];
		result[index] = '\0';
		index = index - 1;
		while (m > 0 && n > 0) {

			if (X[m - 1] == Y[n - 1]) {
				result[index] = X[m - 1];
				m--;
				n--;
				index--;
			} else if (X[m - 1] != Y[n - 1]) {
				if (lcs[m - 1][n] > lcs[m][n - 1]) {
					m = m - 1;
				} else {
					n = n - 1;
				}
			}

		}

		System.out.println(result);
	}
	public static void LCSNormal()
	{
		String str1 = "someString";	
		int m = str1.length();
		char[] X = str1.toCharArray();
		String str2 = "someStringdfgfd";
		int n = str2.length();
		char[] Y = str2.toCharArray();
		System.out.println(LCSCalculate(X, Y, m, n));
	}
	public static void LCPallindromicSubString()
	{
		String str1 = "sdabaqwerty";
		int m = str1.length();
		char[] X = str1.toCharArray();
		String str2;
		StringBuilder s2=new StringBuilder();
		s2.append(str1);
		s2=s2.reverse();
		str2=s2.toString();
		char[] Y = str2.toCharArray();
		System.out.println(LCSCalculate(X, Y, m, m));
	}

	public static void main(String[] args) {
		LCSNormal();
		LCPallindromicSubString();
	}

}
