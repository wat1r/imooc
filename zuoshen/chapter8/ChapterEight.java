package zuoshen.chapter8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ChapterEight {

	public static void main(String[] args) {
		ChapterEight ce = new ChapterEight();

		/*
		 * int[][] m = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1
		 * }, { 0, 0, 0, 0, 1 } };
		 * 
		 * ce.minPathValue(m);
		 */

		// int[][] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
		// { 13, 14, 15, 16 }, };
		//
		// ce.spiralOrderPrint(m);

		// int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
		// { 13, 14, 15, 16 }, };
		// ce.rotate(matrix);
		// System.out.println(new Gson().toJson(matrix));

		// int[][] matrix = { { 0, 1, 2, 5 }, { 2, 3, 4, 7 }, { 4, 4, 4, 8 },
		// { 5, 7, 7, 9 }, };
		// ce.isContains(matrix, 6);

		// int[] arr = { 1, 2, 5, 3, 4 };
		// ce.sort1(arr);

		// int[] arr = { 1, 2, 5, 3, 4 };
		// ce.product2(arr);

		// int[] nums = { 9, 3, 1, 10 };
		// ce.maxGap(nums);

		String str1 = "mabfbemlnffphefbbcahkfknlroaprchrnosaqankcnmi";
		String str2 = "mabfbemlnffphefbbcahkfknlroaprchrnosaqanlgtqj";
		int len1 = 45;
		int len2 = 45;

		//
		// // System.out.println(ChapterEight.getStrCount(str1, str2, len1,
		// len2));
		//
		// // System.out.println(ce.process(str1, str2, len1, len2));
		//
//		System.out.println(ChapterEight.countString(str1, str2, len1, len2));

		// Scanner sc = new Scanner(System.in);
		// while (sc.hasNext()) {
		// long result = 0;
		// String str1 = sc.next();
		// String str2 = sc.next();
		// int len1 = sc.nextInt();
		// int len2 = sc.nextInt();
		// System.out.println(Main.countString(str1, str2, len1, len2));
		// ChapterEight.countString(str1, str2, len1, len2);
		// }

	}

	// public static long getStrCount(String str1, String str2, int len1, int
	// len2) {
	// // System.out.println(str1+" "+ str2+" "+len1+" "+len2);
	// long sum = 0;
	// char a[] = str1.toCharArray();
	// char b[] = str2.toCharArray();
	// int i = len1;
	// for (i = len1; i <= len2; i++) {// 长度从len1 到len2，共有len2-len1种情况
	// char a1 = a[0];
	// char b1 = b[0];
	// int t = b1 - a1;// 两者的差值
	// sum = sum + t * (long) Math.pow(26, i - 1);// 先比较高位的差值，记得乘以26的i-1次幂
	// long suma = 0, sumb = 0;// 用于统计a[1]~a[i]的个数和b[1]~b[i]的个数，例a[1]-a[3]
	// // = abc 则每一位的个数分别为
	// // 123即a[1]-'a'-1=1,a[2]-'a'-1=2,a[3]-'a'-1=3
	// int j = 1;
	// // int min = a.length > i ? i : a.length;
	// for (j = 1; j < a.length; j++) {
	// t = a[j] - 'a' + 1;// 算出其字典序的位置，所以是要剪掉'a'但还要加上一个1，例a的字典序为1，b的字典序为2
	// suma = suma + t * (long) Math.pow(26, i - 1 - j);
	// }
	// // min = b.length > i ? i : b.length;
	// for (j = 1; j < b.length; j++) {
	// t = b[j] - 'a' + 1;
	// sumb = sumb + t * (long) Math.pow(26, i - 1 - j);
	// }
	// sum = sum + sumb - suma;// sumb - suma
	// // 即剪掉a、b两个字符串从b[1]~b[i]的所有字符串的情况-a[1]~a[i]的所有字符串的情况即两者之间的字符串个数
	// }
	// sum = sum - 1;//
	// 在计算最后一位的时候把字符串str2也包含进去了，所以要减去一个1，即题目给的例子计算ce的时候把ce计算进去了（b[1]-'a'+1的时候），所以要减掉一个1
	// return sum % 1000007;
	// }
	//
	// private int process(String str1, String str2, int len1, int len2) {
	// char[] ch1 = str1.toCharArray();
	// char[] ch2 = str2.toCharArray();
	// long res = 0;
	// for (int i = len1; i <= len2; i++) {
	// char a = ch1[0];
	// char b = ch2[0];
	// res += (long) Math.pow(26, i - 1) * (b - a);
	// long suma = 0;
	// long sumb = 0;
	// for (int j = 1; j < ch1.length; j++)// 找到比ch1剩余字符串小的字符串个数
	// {
	// suma = suma + (ch1[j] - 'a') * (long) Math.pow(26, i - 1 - j);
	// }
	// for (int j = 1; j < ch2.length; j++)// 找到比ch2剩余字符串小的字符串个数
	// {
	// sumb = sumb + (ch2[j] - 'a') * (long) Math.pow(26, i - 1 - j);
	// }
	// res = res + sumb - suma;
	// }
	// res--;
	// res = res % 1000007;
	// return (int) res;
	// }

	/**
	 * 数组排序之后相邻数的最大差值 P388（时间复杂度空间复杂度O（N）的解法，使用了桶排序的想法）
	 * 
	 * @param nums
	 * @return
	 */
	public int maxGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		int len = nums.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {// 找到nums中的max和min
			max = Math.max(nums[i], max);
			min = Math.min(nums[i], min);
		}
		if (min == max) {
			return 0;
		}
		boolean[] hasNum = new boolean[len + 1];// 标识桶中是否有数
		int[] maxs = new int[len + 1]; // 桶中最大值
		int[] mins = new int[len + 1]; // 桶中最小值
		int bid = 0;
		for (int i = 0; i < len; i++) {// 统计每个桶中的最小值和最大值
			bid = bucket(nums[i], len, min, max); // 当前元素所在的桶
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
			hasNum[bid] = true;
		}
		int res = 0;
		int lastMax = 0;
		int i = 0;
		while (i <= len) {// 找到第一个不为空的桶
			if (hasNum[i++]) {
				lastMax = maxs[i - 1];
				break;
			}
		}
		for (; i <= len; i++) {
			if (hasNum[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}

		return res;
	}

	// 算出桶号 使用long类型为了防止相乘时溢出
	private int bucket(long num, long len, long min, long max) {
		return (int) ((num - min) * len / (max - min));
	}

	/**
	 * ��������λ��ֵ���۳����� ����1��ʹ�õĳ��� P380
	 * 
	 * @param arr
	 *            ���������
	 * @return
	 */
	public int[] product1(int[] arr) {
		if (arr == null || arr.length < 2) {
			return null;
		}
		int count = 0;// ����arr������0Ԫ�صĸ�����һ��0��ʱ�򣬳���0������۳�������0.������
		int all = 1;// ����0�����е����ֵ��۳˻�
		for (int i = 0; i < arr.length; i++) {// ��ȡall��ֵ��count��ֵ
			if (arr[i] != 0) {
				all *= arr[i];
			} else {
				count++;
			}
		}
		int[] res = new int[arr.length];// ������鷵��
		if (count == 0) {// arr������û��0�����
			for (int i = 0; i != res.length; i++) {
				res[i] = all / arr[i];
			}
		}

		if (count == 1) {// arr��������һ��0�����
			for (int i = 0; i < res.length; i++) {
				if (arr[i] == 0) {
					res[i] = all;
				}
			}
		}
		return res;
	}

	/**
	 * ��������λ��ֵ���۳����� ����2��ʹ�õĳ��� P380 ʹ������������lr[] ��rl[]
	 * lr��ʾ�����ҵ��۳ˣ�rl��ʾ���ҵ���ߵ��۳� ������ȡ�ɸ�����res���飬��Ϊ�м������ת��
	 * 
	 * @param arr
	 *            ���������
	 * @return
	 */
	public int[] product2(int[] arr) {
		if (arr == null || arr.length < 2) {

			return null;
		}
		int[] res = new int[arr.length];// ������鷵��
		res[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			res[i] = res[i - 1] * arr[i];
		}
		int tmp = 1;
		for (int i = arr.length - 1; i > 0; i--) {
			res[i] = res[i - 1] * tmp;
			tmp *= arr[i];
		}
		res[0] = tmp;
		return res;
	}

	/**
	 * ��Ȼ����������� P364 method1
	 * 
	 * @param arr
	 */
	public void sort1(int[] arr) {
		int tmp = 0;
		int next = 0;
		for (int i = 0; i != arr.length; i++) {
			tmp = arr[i];
			while (arr[i] != i + 1) {
				next = arr[tmp - 1];
				arr[tmp - 1] = tmp;
				tmp = next;
			}
		}
	}

	/**
	 * �����ж��ź���ľ��������� P347
	 * 
	 * @param matrix
	 * @param K
	 * @return
	 */
	public boolean isContains(int[][] matrix, int K) {

		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length && col > -1) {
			if (matrix[row][col] == K) {
				return true;
			} else if (matrix[row][col] > K) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}

	/**
	 * �������ξ���˳ʱ��ת��90�� P333
	 * 
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while (tR < dR) {
			rotateEdge(matrix, tR++, tC++, dR--, dC--);
		}

	}

	/**
	 * �������ξ���˳ʱ��ת��90�� P333 2nd
	 * 
	 * @param m
	 * @param tR
	 * @param tC
	 * @param dR
	 * @param dC
	 */
	public void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
		int times = dC - tC;
		int tmp = 0;
		for (int i = 0; i != times; i++) {
			tmp = m[tR][tC + i];
			m[tR][tC + i] = m[dR - i][tC];
			m[dR - i][tC] = m[dR][dC - i];
			m[dR][dC - i] = m[tR + i][dC];
			m[tR + i][dC] = tmp;
		}
	}

	/**
	 * �����ͨ·ֵ(BFS) P384 û��
	 * 
	 * @param m
	 * @return
	 */
	public int minPathValue(int[][] m) {

		System.out.println("---------");
		// m�����鲻���ڣ�������ʼ��Ϊ1ʱ������0�������޴�·������
		if (m == null || m.length == 0 || m[0].length == 0 || m[0][0] != 1
				|| m[m.length - 1][m[0].length - 1] != 1) {
			return 0;
		}
		int res = 0;
		int[][] map = new int[m.length][m[0].length];
		map[0][0] = 1;
		Queue<Integer> rQ = new LinkedList<Integer>();
		Queue<Integer> cQ = new LinkedList<Integer>();
		rQ.add(0);
		cQ.add(0);
		int c = 0;
		int r = 0;
		System.out.println("-----0---");
		while (!rQ.isEmpty()) {
			r = rQ.poll();
			c = cQ.poll();
			if (r == m.length - 1 && c == m[0].length - 1) {
				return map[r][c];
			}

			walkTo(map[r][c], r - 1, c, m, map, rQ, cQ);
			walkTo(map[r][c], r + 1, c, m, map, rQ, cQ);
			walkTo(map[r][c], r, c - 1, m, map, rQ, cQ);
			walkTo(map[r][c], r, c + 1, m, map, rQ, cQ);

		}
		System.out.println(res);
		return res;

	}

	public void walkTo(int pre, int toR, int toC, int[][] m, int[][] map,
			Queue<Integer> rQ, Queue<Integer> cQ) {
		if (toR < 0 || toR == m.length || toC < 0 || toC == m[0].length
				|| m[toR][toC] != 1 || map[toR][toC] != 0) {
			return;
		}
		map[toR][toC] = pre + 1;
		rQ.add(toR);
		cQ.add(toC);

	}

	/**
	 * תȦ��ӡ���� P331
	 * 
	 * @param matrix
	 */
	public void spiralOrderPrint(int[][] matrix) {

		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while (tR <= dR && tC <= dC) {
			printEdge(matrix, tR++, tC++, dR--, dC--);
		}

	}

	public void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
		if (tR == dR) {// �Ӿ���ֻ��һ�У�row��
			for (int i = tC; i <= tC; i++) {
				System.out.print(m[tR][i] + " ");
			}
		} else if (tC == dC) {// �Ӿ���ֻ��һ�У�column��
			for (int i = tR; i <= dR; i++) {
				System.out.print(m[i][tC] + " ");
			}
		} else {// �������
			int curC = tC;
			int curR = tR;
			// ����˳���ϸ�תȦ��ӡ����ķ�ʽ���б�д�����ɵ�������
			while (curC != dC) {
				System.out.print(m[tR][curC] + " ");
				curC++;
			}
			while (curR != dR) {
				System.out.print(m[curR][dC] + " ");
				curR++;
			}
			while (curC != tC) {
				System.out.print(m[dR][curC] + " ");
				curC--;
			}
			while (curR != tR) {
				System.out.print(m[curR][tC] + " ");
				curR--;
			}

		}

	}
}
