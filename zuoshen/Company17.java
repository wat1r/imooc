package zuoshen.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company17 {

	public static void main(String[] args) {

		Company17 mainTest = new Company17();

		// mainTest.loopWords();

		// mainTest.findDivision();

		// String str1 = "Sit it out G";
		// String str2 = "Sit down and shut up";
		//
		// System.out.println(mainTest.findSubstring(str1, str2));

	}

	/**
	 * 2017年校招全国统一模拟笔试(第二场)编程题集合 2/8 找整除
	 * 
	 * 在[a, b]区间内找到一些数满足可以被一个整数c整除,
	 */
	public void findDivision() {

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int begin = in.nextInt();
			int end = in.nextInt();
			int num = in.nextInt();
			while (begin % num != 0) {
				begin++;
			}
			if (begin > end) {
				System.out.println(0);
			} else {
				int res = (end - begin) / num + 1;
				System.out.println(res);
			}

		}

	}

	/**
	 * 2017年校招全国统一模拟笔试(第二场)编程题集合 1/8 最长公共连续子串
	 * 
	 * 思路： 这题其实是动态规划的变形经典题型，应用动态规划的思想，创建一个二维数组dp[n][n]，其中dp[i][j]，
	 * 表示取到s1[i]和取到s2[ j]时的最大连续子串长度
	 * 。如果s1[i]等于s2[j]，则dp[i-1][j-1]等于取到s1[i-1]和取到s2[j-1]时的最大连续子串长度加1，即
	 * dp[i][j]=dp[i-1][j-1]+1。
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public int findSubstring(String str1, String str2) {

		// String str1 = in.nextLine();
		char[] chas1 = str1.toCharArray();
		char[] chas2 = str2.toCharArray();

		int m = chas1.length;
		int n = chas2.length;

		int[][] dp = new int[m][n];
		// 初始化第一行，初始化第一列，因为状态转移公式：dp[i][j]=1 +dp[i-1][j-1]
		for (int i = 0; i < m; i++) {
			if (chas1[i] == chas2[0]) {
				dp[i][0] = 1;
			}
		}

		for (int j = 1; j < n; j++) {
			if (chas1[0] == chas2[j]) {
				dp[0][j] = 1;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (chas1[i] == chas2[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}

		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] > res) {
					res = dp[i][j];
				}
			}
		}

		return res;
	}

	/**
	 * 2017年校招全国统一模拟笔试(第一场)编程题集合 2/8 循环单词
	 ********** 
	 * 该解法思想就是，把每个单词所有可能的循环单词都放在一个数据结构中， 可以是List，map,set，数组等等，此处用ArrayList.
	 * 然后判断下一个单词是否在表中，不在则加入，并把循环种类加1 在的话，则它与之前的单词是同一种循环单词
	 * 
	 * 结果是寻找需要统计这个n个单词中有多少种循环单词。 （同种单词不同形式的，算一种循环单词）
	 */
	public void loopWords() {

		System.out.println("Input---n:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 第一行为单词个数n(1 ≤ n ≤ 50)
		List<String> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			System.out.println("Input---s:");
			String s = sc.next();
			if (!list.contains(s)) {
				count++;
				list.add(s);

				// 输入的字符串s，将其所有的可能都找到
				for (int j = 0; j < s.length() - 1; j++) {
					char last = s.charAt(s.length() - 1);
					s = s.substring(0, s.length() - 1);
					s = last + s;
					list.add(s);

				}

			}

		}
		sc.close();
		System.out.println(count);

	}

}
