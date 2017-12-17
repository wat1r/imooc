package zuoshen.chapter4;

import com.google.gson.Gson;

public class ChapterFour {

	public static void main(String[] args) {
		ChapterFour cf = new ChapterFour();

		int[][] m = { { 1, 3, 5, 9, 1 }, { 8, 1, 3, 4, 2 }, { 5, 0, 6, 1, 3 },
				{ 8, 8, 4, 0, 4 } };

		// cf.minPathSum1(m);
		cf.minPathSum2(m);
	}

	/**
	 * �������С·���� P187
	 * 
	 * @param m
	 * @return
	 */
	public int minPathSum1(int[][] m) {
		// System.out.println(new Gson().toJson(m));
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];

		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}

		for (int j = 1; j < col; j++) {
			dp[0][j] = dp[0][j - 1] + m[0][j];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}
		// System.out.println(new Gson().toJson(dp));
		return dp[row - 1][col - 1];
	}

	/**
	 * �������С·���� P187 �ռ�ѹ����ĵڶ��ֽⷨ
	 * 
	 * @param m
	 * @return
	 */
	public int minPathSum2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int more = Math.max(m.length, m[0].length);// �����������ϴ���Ǹ�Ϊmore
		int less = Math.min(m.length, m[0].length);// ������������С���Ǹ�Ϊless
		boolean rowmore = (more == m.length);// m.length�����������ж������������Ƿ���ȣ���ȷ���true������ȷ���false
		int[] arr = new int[less];// ��������ĳ��Ƚ�Ϊ�����������е���Сֵ
		arr[0] = m[0][0];
		//ע������������������ʱ��ѡȡ[j][i]  [i][j]
		for (int i = 1; i < less; i++) {// ������4��5�У�arr�����������ŵ�һ�У������ұ��ƽ�
			arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);// tureʱ�������ƽ���falseʱ�����ƽ�
		}
		for (int i = 1; i < more; i++) {
			arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);// ������Ĳ�����һ��arrʱ�෴
			for (int j = 1; j < less; j++) {
				arr[j] = Math.min(arr[j - 1], arr[j])
						+ (rowmore ? m[i][j] : m[j][i]);
			}
		}

		return arr[less - 1];
	}
}
