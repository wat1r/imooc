package zuoshen.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class NewCoderOnline {

	public static void main(String[] args) {
		NewCoderOnline test = new NewCoderOnline();
		// int[] A = { 10, 5, 3, 6, 12 };
		// int n = 5;
		// test.getDis(A, n);
		// String A="acbc";
		// int lena = A.length();
		// String B = "bc";
		// int lenb = B.length();
		// System.out.println(test.findAppearance(A, lena, B, lenb));

		// int A = 100;
		// System.out.println(test.distance(A));

		// int[][] board =
		//
		// {1,2 3 4 5 6}
		//             487 444 563 228 365 261
		//             429 505 612 564 715 726
		//             464 617 234 647 702 263
		//             245 249 231 462 453 646
		//             669 510 492 512 622 135 
		//

		// int[] prices = { 10, 22, 5, 75, 65, 80 };
		// int n = 6;
		// System.out.println(test.maxProfit(prices, n));

		// String str1 = "1AB2345CD";
		// int n = 9;
		// String str2 = "12345EF";
		// int m = 7;
		//
		// System.out.println(test.findLongest(str1, n, str2, m));
		// int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }
		// };
		// int n = 4;
		// int m = 3;
		// System.out.println(Arrays.toString(test.printMatrix(mat, n, m)));

		// int[][] A = { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 },
		// { 0, 0, 1, 0 } };
		// int[][] f = { { 2, 2 }, { 3, 3 }, { 4, 4 } };
		// System.out.println(new Gson().toJson(test.flipChess(A, f)));

		// String A = "abc";
		// int n = 3;
		// String B = "adc";
		// int m = 3;
		// int c0 = 3, c1 = 5, c2 = 100;
		// System.out.println(test.findMinCost(A, n, B, m, c0, c1, c2));
		//

		// int[] stops = { 13, 15, 26, 7, 27, 3, 30 };
		// int[] period = { 1, 2, 1, 2, 2, 2, 1 };
		// int[] interval = { 5, 1, 4, 3, 2, 1, 4 };
		// int n = 7;
		// int s = 10;
		//
		// System.out.println(test.chooseLine(stops, period, interval, n, s));
		// System.out.println(test.chooseLine1(stops, period, interval, n, s));

		String A = "qywyqer23tdd";
		int n = 11;

		// System.out.println(test.findFirstRepeat(A, n));

		System.out.println(test.firstAppearsOnlyonce(A));

	}

	/*
	 * 最后一个字符
	 */
	public static void generateFirstAppearsOnlyonce() {

		// InputStreamReader 是字节流通向字符流的桥梁;
		// 为了达到最高效率，可要考虑在 BufferedReader 内包装 InputStreamReader。
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		try {
			int t = Integer.parseInt(bf.readLine());
			for (int i = 0; i < t; i++) {
				String str = bf.readLine();
				System.out.println(firstAppearsOnlyonce(str));
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * 找字符串中第一个只出现一次的字符
	 */
	public static char firstAppearsOnlyonce(String str) {
		char[] chas = str.toCharArray();
		int[] hash = new int[256];

		for (int i = 0; i < str.length(); i++) {
			hash[chas[i]]++;
		}

		for (int i = 0; i < str.length(); i++) {
			if (hash[chas[i]] == 1) {
				return chas[i];
			}
		}
		return '\0';
	}

	/*
	 * 字符集合
	 */
	public String getCharCollection(String str) {

		char[] chas = str.toCharArray();
		Set<Character> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chas.length; i++) {
			if (set.add(chas[i])) {
				sb.append(chas[i]);
			}
		}

		return sb.toString();
	}

	/*
	 * 最长回文子串
	 * 
	 * dp[i][j]表示，若i到j已经是回文串了，那么dp[i][j]是回文串的长度，否则为0；
	 */
	public int getLongestPalindrome(String A, int n) {

		int[][] dp = new int[n][n];

		return 0;
	}

	/**
	 * 
	 * 
	 * 数组模拟hash 高效解法
	 * 
	 * 
	 * 利用hash的方式，把每个字符是否出现记录到一个数组中，初始化时都没出现，遍历字符串，将对应字符的位置置1，表示出现了，
	 * 如果在某个字符位置上已经为1了，表示前面出现过该字符，那么这个字符就是第一个重复出现的字符，返回即可
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public char findFirstRepeat(String A, int n) {

		char[] chasa = A.toCharArray();
		int[] hash = new int[256];
		for (int i = 0; i < chasa.length; i++) {
			if (hash[chasa[i] - '0'] == 0) {// 首次出现的char放进hash中，置为1，下次再次出现时，走else分支逻辑
				hash[chasa[i] - '0'] = 1;
			} else {
				return chasa[i];
			}

		}

		return '\n';

	}

	/*
	 * 微信红包
	 * 
	 * 数据可能有不存在超过红包一半的，这个时候就要输出0；即该金额的数目必须 大于
	 * 红包数一半，不能小于等于。如果一个数出现次数超过一半了，排序过后，必然排在中间，
	 */
	public int getValue(int[] gifts, int n) {

		Arrays.sort(gifts);
		int count = 0;
		int middle = gifts[n / 2];
		for (int i = 0; i < gifts.length; i++) {
			if (gifts[i] == middle) {
				count++;
			}
		}

		return (count <= n / 2) ? 0 : middle;
	}

	/*
	 * 乘坐公交
	 * 
	 * 这个题目解题思路是求多种路线下最短时间， 公交路线n和小明
	 * 出发时间s是固定的，不同的是每条公交路线的停站数stops，停站时间period，发车时间间隔interval。
	 * 总时间=出发时间（s）+等车时间（WaitTime）+公交运行时间（BusTime ）。      
	 * 如果小明出发的时间s刚好是发车时间间隔interval的整数倍，说明等车时间为0，什么意思？因为相对时间都是从0开始计算，例如如果第i 条发车
	 * 时间间隔为30，小明出发时间60，则说明不用等车，直接坐第二趟车。        公交运行时间（BusTime
	 * ）=行驶时间+停站时间。注意行驶时间为（stops+1）*5，为什么加1，自己画画就知道了，除去起点和终点， stops
	 * 个站行驶（stops+1）段距离，停车时间=停站数（stops）*5
	 */
	public int chooseLine(int[] stops, int[] period, int[] interval, int n,
			int s) {
		int totalTime = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int missTime = s % interval[i];
			int waitTime = missTime == 0 ? 0 : (interval[i] - missTime);
			int busTime = (stops[i] + 1) * 5 + stops[i] * period[i];
			totalTime = Math.min(totalTime, (s + waitTime + busTime));
		}

		return totalTime;
	}

	public int chooseLine1(int[] stops, int[] period, int[] interval, int n,
			int s) {
		// write code here
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int missTime = s % interval[i];
			int waitCost = missTime == 0 ? 0 : interval[i] - missTime;
			min = Math.min(min, waitCost + (stops[i] + 1) * 5 + stops[i]
					* period[i]);
		}
		return min + s;
	}

	/**
	 * 文本嗅探
	 * 
	 */
	public int[] containKeyword(String[] A, int n, String[] keys, int m) {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < keys.length; j++) {
				if (A[i].indexOf(keys[j]) > -1) {
					list.add(i);
					break;
				}

			}
		}
		if (list.isEmpty()) {
			return new int[] { -1 };
		}

		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}

		return res;
	}

	/*
	 * 棋子翻转
	 * 
	 * 注意棋子的边界0-3，题目的中的坐标要对应到二维数组的下标
	 */
	public static int[][] flipChess(int[][] A, int[][] f) {

		for (int i = 0; i < f.length; i++) {

			int row = f[i][0] - 1;// 每一组的第一个数字
			int col = f[i][1] - 1;// 每一组的第二个数字

			if (row - 1 >= 0) {
				A[row - 1][col] = (A[row - 1][col] == 0) ? 1 : 0;
			}

			if (row + 1 <= 3) {
				A[row + 1][col] = (A[row + 1][col] == 0) ? 1 : 0;
			}

			if (col - 1 >= 0) {
				A[row][col - 1] = (A[row][col - 1] == 0) ? 1 : 0;
			}

			if (col + 1 <= 3) {
				A[row][col + 1] = (A[row][col + 1] == 0) ? 1 : 0;
			}
		}

		return A;

	}

	/**
	 * 之字形打印矩阵
	 * 
	 * @param mat
	 * @param n
	 * @param m
	 * @return
	 */
	public int[] printMatrix(int[][] mat, int n, int m) {

		int[] res = new int[n * m];
		// index记录你的行数，count记录的是你返回的字符数组的长度
		int index = 0;
		int count = 0;
		// 偶数行顺序，奇数行倒序
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (index % 2 == 0) {// 判断数奇数行还是偶数行
					res[count++] = mat[i][j];
				} else {
					res[count++] = mat[i][m - j - 1];
				}
			}
			index++;// 写完了一行，行数需要+1
		}

		return res;

	}

	/**
	 * 最长公共子串
	 * 
	 * 这里要求的是最长公共子字符串（要求连续），而不是最长公共子串（不一定连续） 所求是最大子串，不是子序列，说明是连续的。
	 * 
	 * 
	 * 
	 * 若s是两个字符串s1和s2敏感词有的字符，s1中s左侧的字符串为s1'，s2中s左侧的字符串为s2'，那么截止到s为止，LS(s1, s2) =
	 * LS(s1', s2')+1，用矩阵记录结果，例如bab和c aba，矩阵如下：
	 * 
	 * 
	 * 
	 */
	public int findLongest(String str1, int n, String str2, int m) {

		if (n == 0 || m == 0) {
			return 0;
		}
		char[] chas1 = str1.toCharArray();
		char[] chas2 = str2.toCharArray();

		int[][] dp = new int[n][m];
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (chas1[i] == chas2[j]) {
					if (i == 0 || j == 0) {// 注意是||不是&&
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}
					max = max > dp[i][j] ? max : dp[i][j];
				}
			}
		}
		return max;
	}

	/**
	 * 股票交易日
	 * 
	 * @param prices
	 * @param n
	 * @return
	 */
	public int maxProfit(int[] prices, int n) {
		int temp1 = 0, temp2 = 0, temp3 = 0, l = 0;
		while (l < n) {

			for (int i = 0; i < l + 1; i++) {// 注意for循环的起始值， i j
				for (int j = i + 1; j < l + 1; j++) {
					if (temp1 < prices[j] - prices[i]) {
						temp1 = prices[j] - prices[i];
					}
				}
			}
			for (int i = l + 1; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (temp2 < prices[j] - prices[i]) {
						temp2 = prices[j] - prices[i];
					}
				}
			}

			if (temp3 < (temp1 + temp2)) {
				temp3 = temp1 + temp2;
			}
			temp1 = 0;
			temp2 = 0;
			l++;

		}

		return temp3;
	}

	public int getMost(int[][] board) {
		// 标准的动态规划题目，按模板写
		// 动态规划的两个核心点：1.明白动态数组dp的含义；2、分层次组装dp数组
		// dp[i][j]表示达到board[i][j]位置所获取的最大的值
		int m = board.length;// 行
		int n = board[0].length;// 列
		int[][] dp = new int[m][n];
		dp[0][0] = board[0][0];
		// 组装第一列
		for (int i = 1; i < m; i++) {
			dp[i][0] += board[i][0] + dp[i - 1][0];
		}
		// 组装第一行
		for (int j = 1; j < n; j++) {
			dp[0][j] += board[0][j] + dp[0][j - 1];
		}
		// 组装其他位置的dp元素
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] += board[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[m - 1][n - 1];
		// 说的不对之处，轻拍
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
	public int calcDistance1(int A, int B, int C, int D) {
		return (int) (distance1(A) + distance1(B) + distance1(C) + distance1(D));
	}

	public double distance1(double n) {
		if (n == 0) {
			return 0;
		}
		return (n + n / 2 + distance(n / 2));

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

	/**
	 * 
	 * 抛小球 sn = x + 2* (1/2 + 1/4 + ... + (1/2)^m)x; x只算一次，后面都应该往返没救应该乘以2.
	 * sn = x + (1+1/2 + 1/4 + ... + (1/2)^(m-1))x=x+2x=3x
	 * 
	 * 
	 * 
	 * 举个列子，比如从100米下落，第一次坠地，弹起50m，再下落50m，所以走了100，第二次坠地，弹起25m再下落25m所以走了50，第三次，
	 * 第四次一次类推，假设从x米处下落，则走的路程为x+x+0.5x+0.25x+....
	 * =x+2x(1-0.5^n),这个n是趋于无穷大的所以最终走的路程为x+2x=3x
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
		} else {
			return (n + n / 2 + distance(n / 2));
		}

	}

	/**
	 * 串的模式匹配
	 * 
	 * @param A
	 * @param lena
	 * @param B
	 * @param lenb
	 * @return
	 */
	public int findAppearance(String A, int lena, String B, int lenb) {
		// 判断长度
		if (lena < lenb) {
			return -1;
		}
		if (lena == lenb) {
			if (A.equals(B)) {
				return 0;
			} else {
				return -1;
			}
		}
		// lena>lenb
		// 截取字符串。
		// 遍历一遍，记录B字符串首字符出现的位置
		int i = 0;
		while (i <= lena - lenb) {
			if (A.charAt(i) == B.charAt(0)) {
				String temp = A.substring(i, i + lenb);
				if (temp.equals(B)) {
					return i;
				} else {
					i++;
					continue;
				}
			}

			i++;
		}

		return -1;
	}

	/**
	 * 数组单调和 动态规划思路
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public int calcMonoSum(int[] A, int n) {

		return n;
	}

	/**
	 * 最大差值
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public int getDis(int[] A, int n) {
		int dis = 0;
		if (n > 1) {
			int min = A[0];
			for (int i = 1; i < n; i++) {
				if (A[i] - min > dis) {
					dis = A[i] - min;
				}
				if (min > A[i]) {// 实时更新min值，拿到最小值
					min = A[i];
				}

			}

		}
		return dis;
	}

	/**
	 * 
	 * @param n名罪犯
	 * @param c名犯人
	 * @param t不超过t
	 * @param a按入狱时间给出每个犯人的罪行值ai
	 * @return
	 */
	public static int transferCriminalsWays(int n, int c, int t, int[] a) {

		int count = 0;
		int temp = 0;// 存连续c名罪犯的犯罪值的和

		for (int i = 0; i < c; i++) {
			temp += a[i];
		}
		if (temp <= t) {
			count++;
		}

		for (int i = c; i < n; i++) {
			temp = temp + a[i] - a[i - c];// 开始的时候下标为c，不会数组越界，有滑动数组的思想在其中
			if (temp <= t) {
				count++;
			}
		}
		return count;
	}

	/*
	 * 删数
	 */
	public int deleteNum(int n) {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int index = 0;
		while (list.size() > 1) {// 每隔2增加，size也在不断递减，index取模可能会为0，增加2 如此往复
			index = (index + 2) % list.size();
			list.remove(index);
		}

		return list.get(0);
	}

	/*
	 * 生成格雷码
	 * 
	 * 
	 * //递归 //递归的思路是n位gray码是由n-1位gray码生成，举个例子简单一些：
	 * //比如求n=3的gray码，首先知道n=2的gray码是(00,01,11,10)
	 * //那么n=3的gray码其实就是对n=2的gray码首位添加0或1生成的，添加0后变成(000,001,011,010)
	 * //添加1后需要顺序反向就变成(110,111,101,100)
	 * //组合在一起就是(000,001,011,010,110,111,101,100)
	 */
	public String[] getGray(int n) {

		String[] resStrs = null;

		if (n == 1) {
			return new String[] { "0", "1" };
		} else {
			String[] tempStrs = getGray(n - 1);
			resStrs = new String[2 * tempStrs.length];
			for (int i = 0; i < tempStrs.length; i++) {
				resStrs[i] = "0" + tempStrs[i];
				resStrs[resStrs.length - 1 - i] = "1" + tempStrs[i];
			}
		}

		return resStrs;
	}

	/*
	 * 多数组中位数 左神P465
	 */
	public int getUpMedian(int[] arr1, int[] arr2) {

		if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
			return -1;
		}
		int start1 = 0;
		int end1 = arr1.length - 1;
		int start2 = 0;
		int end2 = arr2.length - 1;
		int mid1 = 0;
		int mid2 = 0;
		int offset = 0;

		while (start1 < end1) {
			mid1 = (start1 + end1) / 2;
			mid2 = (start2 + end2) / 2;
			offset = ((end1 - start1 + 1) & 1) ^ 1;
			if (arr1[mid1] > arr2[mid2]) {
				end1 = mid1;
				start2 = mid2 + offset;
			} else if (arr1[mid1] < arr2[mid2]) {
				start1 = mid1 + offset;
				end2 = mid2;
			} else {
				return arr1[mid1];
			}
		}

		return Math.min(arr1[start1], arr2[start2]);
	}

	/*
	 * 最小编辑代价
	 * 
	 * 我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价
	 */
	public int findMinCost(String A, int n, String B, int m, int c0, int c1,
			int c2) {
		char[] chasa = A.toCharArray();
		char[] chasb = B.toCharArray();

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = i * c1;
		}

		for (int j = 0; j <= m; j++) {
			dp[0][j] = j * c0;
		}

		/*
		 * 1、长度为i的A修改为长度为j-1的B，然后插入j位置的字符； * * 2、长度为i-1的A修改为长度为j的B，然后删除i位置的字符；
		 * 3、长度为i-1的A修改为长度为j-1的B，然后i位置的字符修改为j位置的字符。
		 */
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (chasa[i - 1] == chasb[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int cost0 = dp[i][j - 1] + c0;
					int cost1 = dp[i - 1][j] + c1;
					int cost2 = dp[i - 1][j - 1] + c2;
					dp[i][j] = Math.min(cost0, Math.min(cost1, cost2));

				}

			}
		}

		return dp[n][m];
	}

	/**
	 * 裁减网格纸
	 */
	public void obtainMaxArea() {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int n = sc.nextInt();
			int maxX = Integer.MIN_VALUE;
			int minX = Integer.MAX_VALUE;
			int maxY = Integer.MIN_VALUE;
			int minY = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				maxX = (int) Math.max(maxX, x);
				minX = (int) Math.min(minX, x);
				maxY = (int) Math.max(maxY, y);
				minY = (int) Math.min(minY, y);
			}
			int side = Math.max(maxX - minX, maxY - minY);
			int res = side * side;
			System.out.println(res);
		}
	}

	/*
	 * 奇数位丢弃
	 * 
	 * list移除一次,动态数组长度减1（剩余的数整体向左移一位，因此相当于已经i=i+1），最后只需要i+1而不是i+2；
	 */
	public int discardOdd(int n) {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(i);
		}
		while (list.size() != 1) {
			for (int i = 0; i < list.size(); i = i + 1) {
				list.remove(i);
			}
		}

		return list.get(0);

	}

	/**
	 * 字符串计数
	 * 
	 * 例如ab ce 1 2 过程分为以下几个阶段： 第一阶段：i=min=1;b c,sum=2;除开首字母(剩下只有i-1=0个字母)
	 * 第二阶段：i=max=2;ac ... az ,ba ... bz ,ca ,cb;sum = 2+26*2=54; 第三阶段：i=max=2;c
	 * d e(除开首字母(剩下只有i-1=1个字母)， 判断大于b小于等于e的字符串个数);sum = 54+3=57;
	 * 第四阶段：减去等于ce这个不满足的条件。sum = 57-1 = 56; 注意：仅最后一个小于等于e这个条件需要减去， 例如abc bbc 1 3
	 * ,i=2时，ac ... az,ba,bb这里这个bb不需要排除，因为bb<bbc
	 * 
	 */
	public static long countString(String str1, String str2, int len1, int len2) {

		char[] chas1 = str1.toCharArray();
		char[] chas2 = str2.toCharArray();

		long res = 0;

		for (int i = len1; i <= len2; i++) {

			char a = chas1[0];
			char b = chas2[0];
			res += (long) Math.pow(26, i - 1) * (b - a);
			long suma = 0;
			long sumb = 0;
			for (int j = 1; j < chas1.length; j++) {
				suma += (chas1[j] - 'a') * (long) (Math.pow(26, i - j - 1));
			}
			for (int j = 1; j < chas2.length; j++) {
				sumb += (chas2[j] - 'a') * (long) (Math.pow(26, i - j - 1));
			}
			res += sumb - suma;
		}
		res--;

		return (long) res % 1000007;
	}

	/**
	 * 字符串的旋转 左神P263
	 * 
	 * @param str
	 * @param n
	 * @param p
	 * @return
	 */
	public String rotateString(String str, int n, int p) {

		// "ABCDEFGH" 8,4
		// 首先翻转下标为4的（E）之前的ABCDE,翻转后为EDCBA
		// 再次翻转下表为4之后的（F开始）的FGH，翻转为HGF
		// 组合在一起的整体为EDCBAHGF
		// 翻转上述整体得到：FGHABCDE，得到要的结果
		if (str == null || n <= 0 || p < 0) {
			return null;
		}
		char[] chas = str.toCharArray();
		reverse(chas, 0, p);// 翻转前半部分
		reverse(chas, p + 1, n - 1);// 翻转后半部分
		reverse(chas, 0, n - 1);// 翻转全部
		return String.valueOf(chas);

	}

	// 翻转函数
	public void reverse(char[] chas, int start, int end) {
		char temp = 0;
		while (start < end) {
			temp = chas[start];
			chas[start] = chas[end];
			chas[end] = temp;
			start++;
			end--;
		}

	}

	/**
	 * 换零钱 左神P196
	 * 
	 * @param changes
	 * @param n
	 * @param aim
	 * @return
	 */
	public int countWays(int[] changes, int n, int aim) {

		int[][] dp = new int[n][aim + 1];

		// 组装第一列
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		// 组装第一行
		for (int j = 1; j * changes[0] < aim + 1; j++) {
			dp[0][j * changes[0]] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < aim + 1; j++) {
				dp[i][j] = dp[i - 1][j]
						+ ((j - changes[i]) >= 0 ? dp[i][j - changes[i]] : 0);
			}
		}

		return dp[n - 1][aim];

	}

	/**
	 * 最长公共子序列 左神P210 dp[ i ][ j ]为字符串A的第一个字符到第 i 个字符串和字符串B的第一个字符串到第 j
	 * 个字符串的最长公共子序列长度
	 * 
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 * @return
	 */
	public int findLCS(String A, int m, String B, int n) {

		int[][] dp = new int[m][n];
		char[] chasa = A.toCharArray();
		char[] chasb = B.toCharArray();
		dp[0][0] = chasa[0] == chasb[0] ? 1 : 0;
		for (int i = 1; i < m; i++) {// 组装第一列
			dp[i][0] = Math.max(dp[i - 1][0], chasa[i] == chasb[0] ? 1 : 0);
		}
		for (int j = 1; j < n; j++) {// 组装第一行
			dp[0][j] = Math.max(dp[0][j - 1], chasa[0] == chasb[j] ? 1 : 0);
		}
		for (int i = 1; i < m; i++) {// 组装其他位置的dp元素
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (chasa[i] == chasb[j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}

		return dp[m - 1][n - 1];
	}

	/**
	 * 同findLCS
	 * 
	 * @param A
	 * @param n
	 * @param B
	 * @param m
	 * @return
	 */
	public static int findLCS1(String A, int n, String B, int m) {
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A.charAt(i) == B.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
			}
		}
		return dp[n][m];
	}

	/**
	 * 二维数组打印
	 * 
	 * 题意很简单，主要是边界的处理： 1. 沿着主对角线打印，所以每次打印之后x与y都要加1，直到x或y超出边界。 2.
	 * 每轮遍历的起始点，是遵循(0,n-1)...（0,0）...（n-1,0）。
	 * 也就是y先减小到0，然后x增加到n-1。所以遍历的终止条件是startX>=n。 int[][] arr = { { 1, 2, 3, 4 },
	 * { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } }; int n = 4;
	 * test.arrayPrint(arr, n);
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public int[] arrayPrint(int[][] arr, int n) {

		int[] res = new int[n * n];
		int index = 0;
		int startX = 0;
		int startY = n - 1;
		while (startX < n) {// startX从0增加到n-1表示结束
			int x = startX;
			int y = startY;
			while (x < n && y < n) {// 表示碰到边界的限制条件
				res[index++] = arr[x++][y++];
			}
			if (startY > 0) {// 东北半区
				startY--;
			} else {// 西南半区
				startX++;
			}
		}

		return res;
	}

	/**
	 * 懂二进制 见左神P325
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int countBitDiff(int m, int n) {
		int dif = m ^ n;
		int res = 0;
		while (dif != 0) {
			dif &= (dif - 1);
			res++;
		}
		return res;
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


}
