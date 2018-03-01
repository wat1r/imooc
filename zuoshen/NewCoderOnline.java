package zuoshen.company;

public class NewCoderOnline {

	public static void main(String[] args) {

		NewCoderOnline test = new NewCoderOnline();

		// String A = "abcd";
		// int lena = 4;
		// String B = ".*";
		// int lenb = 2;
		//
		// test.chkWildMatch(A, lena, B, lenb);

	}

	public int getMost(int[][] board) {
		// dp[i][j]表示达到board[i][j]位置所获取的最大的值
		int m = board.length;// 行
		int n = board[0].length;// 列
		int[][] dp = new int[m][n];
		// 组装第一列
		for (int i = 0; i < m; i++) {
			dp[i][0] += board[i][0];
		}
		// 组装第一行
		for (int j = 0; j < n; j++) {
			dp[0][j] += board[0][j];
		}
		// 组装其他位置的dp元素
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] += board[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[m - 1][n - 1];
	}

	/**
	 * 左右最值最大差
	 * 
	 * 直接找max，min取两端的数。 不用考虑max在哪，因为无论在哪，min都只会<=max
	 * 
	 * 左部分中的最大值减去右部分最大值的绝对值，最大是多少？
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public int findMaxGap(int[] A, int n) {

		int max = A[0];
		int pos = 0;
		for (int i = 1; i < A.length; i++) {
			if (max < A[i]) {
				max = A[i];
			}
		}
		int min = A[0] > A[n - 1] ? A[n - 1] : A[0];
		return max - min;
	}

	/**
	 * 小球的距离 与来源自京东的 [抛小球] 相同 极限思维 运用递归
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	public int calcDistance(int A, int B, int C, int D) {
		return (int) (distance(A) + distance(B) + distance(C) + distance(D));
	}

	public double distance(double n) {
		if (n == 0) {
			return 0;
		}
		return (n + n / 2 + distance(n / 2));

	}

	/**
	 * 字符串通配 动态规划的思想，没咋明白
	 * 
	 * @param A
	 * @param lena
	 * @param B
	 * @param lenb
	 * @return
	 */
	public boolean chkWildMatch(String A, int lena, String B, int lenb) {

		boolean[][] dp = new boolean[lena + 1][lenb + 1];
		dp[0][0] = true;
		for (int i = 1; i <= lena; i++) {
			for (int j = 1; j <= lenb; j++) {
				if (B.charAt(j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				} else if (B.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j - 1]
							&& (A.charAt(i - 1) == B.charAt(j - 1));
				}
			}

		}
		return dp[lena][lenb];

	}

	/**
	 * 顺时针旋转矩阵
	 * 
	 * @param mat
	 * @param n
	 * @return
	 */
	public int[][] rotateMatrix(int[][] mat, int n) {

		int tR = 0;
		int tC = 0;
		int dR = mat.length - 1;
		int dC = mat[0].length - 1;

		while (tR < dR) {
			rotateEdge(mat, tR++, tC++, dR--, dC--);
		}
		return mat;
	}

	private int[][] rotateEdge(int[][] mat, int tR, int tC, int dR, int dC) {
		int times = dC - tC;
		int tmp = 0;
		for (int i = 0; i < times; i++) {
			tmp = mat[tR][tC + i];
			mat[tR][tC + i] = mat[dR - i][tC];
			mat[dR - i][tC] = mat[dR][dC - i];
			mat[dR][dC - i] = mat[tR + i][dC];
			mat[tR + i][dC] = tmp;
		}
		return mat;
	}

}
