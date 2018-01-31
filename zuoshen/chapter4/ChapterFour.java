package zuoshen.chapter4;

import com.google.gson.Gson;

public class ChapterFour {

	public static void main(String[] args) {
		ChapterFour cf = new ChapterFour();

		// int[][] m = { { 1, 3, 5, 9, 1 }, { 8, 1, 3, 4, 2 }, { 5, 0, 6, 1, 3
		// },
		// { 8, 8, 4, 0, 4 } };
		//
		// // cf.minPathSum1(m);
		// cf.minPathSum2(m);

		// int[] arr = { 3, 2, 3, 1, 1, 4 };
		// cf.jump(arr);

		// int[][] m = { { -2, -3, 3 }, { -5, -10, 1 }, { 0, 30, -5 } };
		//
		// cf.minHP1(m);

		// int[] arr = { 5, 10, 25, 1 };
		// int aim = 15;
		// // cf.coins2(arr, aim);
		// cf.coins3(arr, aim);

		int[] arr = { 5, 2, 3 };
		int aim = 20;

	}

	public int minCoins(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}

		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[n][aim + 1];

		for (int j = 1; j <= aim; j++) {
			dp[0][j] = max;
			if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
				dp[0][j] = dp[0][j - arr[0]] + 1;
			}
		}
		int left = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				left = max;
				if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
					left = dp[i][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(left, dp[i - 1][j]);
			}
		}

		return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
	}

	/**
	 * 换钱的方法 P196 第四种方法：动态规划算法（优化时间复杂度到O(N*aim)）
	 ********* 
	 * dp[i][j]表示在使用arr[0,1....i]货币的情况下，组成钱数j有多少中方法
	 * 
	 * @param arr
	 * @param aim
	 * @return
	 */
	public int coins4(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length + 1][aim + 1];
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; j * arr[0] <= aim; j++) {
			dp[0][j * arr[0]] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[i][j] = dp[i - 1][j];// 与coins3的方法的不同之处，此处没有三层循环
				dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
			}
		}

		return dp[arr.length - 1][aim];
	}

	/**
	 * 换钱的方法 P196 第三种方法：动态规划算法
	 ********* 
	 * dp[i][j]表示在使用arr[0,1....i]货币的情况下，组成钱数j有多少中方法
	 * 
	 * @param arr
	 * @param aim
	 * @return
	 */
	public int coins3(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length + 1][aim + 1];
		for (int i = 0; i < arr.length; i++) {// 做第一列的数据
			dp[i][0] = 1;
		}

		for (int j = 1; j * arr[0] <= aim; j++) {// 做第一行的数据
			dp[0][arr[0] * j] = 1;
		}
		int num = 0;
		for (int i = 1; i < arr.length; i++) {// 做其他的dp[i][j]的数据
			for (int j = 0; j <= aim; j++) {
				num = 0;
				for (int k = 0; j - arr[i] * k >= 0; k++) {
					num += dp[i - 1][j - arr[i] * k];
				}
				dp[i][j] = num;
			}
		}

		return dp[arr.length - 1][aim];

	}

	/**
	 * 换钱的方法 P196 第二种方法：基于暴力算法改进后的记忆搜索算法
	 * 
	 * @param arr
	 * @param aim
	 * @return
	 */
	public int coins2(int[] arr, int aim) {

		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}

		int[][] map = new int[arr.length + 1][aim + 1];
		return process2(arr, 0, aim, map);
	}

	private int process2(int[] arr, int index, int aim, int[][] map) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
			int mapValue = 0;
			for (int i = 0; arr[index] * i <= aim; i++) {
				mapValue = map[index + 1][aim - arr[index] * i];
				if (mapValue != 0) {
					res += mapValue == -1 ? 0 : mapValue;
				} else {
					res += process2(arr, index + 1, aim - arr[index] * i, map);// return_res的时候会再次进入这段代码
				}
			}
		}
		map[index][aim] = res == 0 ? -1 : aim;
		return res;
	}

	/**
	 * 换钱的方法 P196 第一种方法：暴力算法
	 * 
	 * @param arr
	 * @param aim
	 * @return
	 */
	public int coins1(int[] arr, int aim) {

		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}

		return process1(arr, 0, aim);
	}

	private int process1(int[] arr, int index, int aim) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
			for (int i = 0; arr[index] * i <= aim; i++) {// 每次顶一个arr[index]需要的话，一步步的++上去
				res += process1(arr, index + 1, aim - arr[index] * i);
			}
		}
		return res;
	}

	/**
	 * P223 龙与地下城游戏问题
	 * 
	 * @param m
	 * @return
	 */
	public int minHP1(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 1;
		}

		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row--][col--];// 做成一个（row）*（col）的数组 row col都--
		dp[row][col] = m[row][col] > 0 ? 1 : -m[row][col] + 1;// 判断最后一个右下角的数组的值，确定最右下角的值（目标血量），要是正数的话，只需要dp在此位置为1即可，负数的话，需要+1

		for (int j = col - 1; j >= 0; j--) {// 将（row-1）行配置好，也就所谓的最下面的墙
			dp[row][j] = Math.max(dp[row][j + 1] - m[row][j], 1);
		}
		int right = 0;
		int down = 0;

		for (int i = row - 1; i >= 0; i--) {// 开始遍历row（行），一步步先将（col-1）的墙补上，
			dp[i][col] = Math.max(dp[i + 1][col] - m[i][col], 1);
			for (int j = col - 1; j >= 0; j--) {// 嵌套在行递减的循环内，将这一行的左边位置一个个补齐
				right = Math.max(dp[i][j + 1] - m[i][j], 1);
				down = Math.max(dp[i + 1][j] - m[i][j], 1);
				dp[i][j] = Math.min(right, down);// 哪个最小选用哪一个
			}
		}

		return dp[0][0];// 返回开始的的动态数组的dp[0][0]
	}

	public int jump(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int jump = 0;// Ŀǰ���˶��ٲ�
		int cur = 0;// ���ֻ����jump������Զ�ܹ��ﵽ��λ��
		int next = 0;// ��������ٶ���һ������Զ�ܹ��ﵽ��λ��
		for (int i = 0; i < arr.length; i++) {
			if (cur < i) {
				jump++;
				cur = next;
			}
			next = Math.max(next, i + arr[i]);
		}

		return jump;
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
		// ע������������������ʱ��ѡȡ[j][i] [i][j]
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