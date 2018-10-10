package zuoshen.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 自己面试准备的一些题目
 * 
 * @author FrankCooper
 *
 */
public class ICompany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[][] m = { { 1, 3, 8, 9 }, { 8, 1, 3, 4 }, { 8, 0, 6, 1
		// },
		// { 8, 8, 4, 0 } };
		// System.out.println(minPathSum1(m));

		/************** 迷宫Start-回溯法 ****************/

		int maxRow, maxLine, p;
		// Scanner in = new Scanner(System.in);
		// System.out.println("please input");
		// Pattern pattern = Pattern.compile("[ ]+");
		// String s = in.nextLine();
		// String[] str = pattern.split(s);
		// // 获取行
		// maxRow = Integer.parseInt(str[0]);
		// // 获取列
		// maxLine = Integer.parseInt(str[1]);

		// int[][] array = new int[maxRow][maxLine];
		// for (int i = 0; i < maxRow; i++) {
		// for (int j = 0; j < maxLine; j++) {
		// array[i][j] = in.nextInt();
		// }
		// }
		// 该图是一个迷宫的图。1代表是墙不能走，0是可以走的路线。只能往上下左右走，直到从左上角到右下角出口。
		int[][] array = { { 0, 0, 1, 0, 0, 0, 1, 0 },
				{ 0, 0, 1, 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 1, 0, 1 },
				{ 0, 1, 1, 1, 0, 0, 1, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 1, 0, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 0, 1 }, { 1, 1, 0, 0, 0, 0, 0, 0 } };
		maxRow = 9;
		maxLine = 8;

		// for (int i = 0; i < maxRow; i++) {
		// System.out.println("array:"+Arrays.toString(array[i]));
		// }

		check(0, 0, array, maxRow, maxLine);

		/************** 迷宫End-回溯法 ****************/

	}

	/**
	 * 智慧芽 迷宫 （矩阵的最小路径和） P187
	 * 
	 * 2018.10.10
	 */
	public static int minPathSum1(int[][] m) {

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
			for (int j = 1; j < row; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}

		return dp[row - 1][col - 1];
	}

	/**
	 * 回溯法 迷宫 智慧芽 2018.10.10 制定走的规则
	 * 
	 * @param i
	 * @param j
	 * @param array
	 * @param maxRow
	 * @param maxLine
	 */
	private static void check(int i, int j, int[][] array, int maxRow,
			int maxLine) {

		if (i == maxRow - 1 && j == maxLine - 1) {
			print(array, maxRow, maxLine);
			return;
		}

		// 向右走
		if (canMove(i, j, i, j + 1, array, maxRow, maxLine)) {
			array[i][j] = 8; // 已走过的点置标志位8
			check(i, j + 1, array, maxRow, maxLine); // 从下一个点继续寻路
			array[i][j] = 0;
		}
		// 向左走
		if (canMove(i, j, i, j - 1, array, maxRow, maxLine)) {
			array[i][j] = 8; // 已走过的点置标志位8
			check(i, j - 1, array, maxRow, maxLine); // 从下一个点继续寻路
			array[i][j] = 0;
		}
		// 向下走
		if (canMove(i, j, i + 1, j, array, maxRow, maxLine)) {
			array[i][j] = 8; // 已走过的点置标志位8
			check(i + 1, j, array, maxRow, maxLine); // 从下一个点继续寻路
			array[i][j] = 0;
		}
		// 向上走
		if (canMove(i, j, i - 1, j, array, maxRow, maxLine)) {
			array[i][j] = 8; // 已走过的点置标志位8
			check(i - 1, j, array, maxRow, maxLine); // 从下一个点继续寻路
			array[i][j] = 0;
		}
	}

	/**
	 * 
	 * 一旦该路径走到了死胡同里，清理走过的路径将当前位置重新标志为1，推出当前递归的迭代堆栈，返回上一次，继续
	 * 在当前函数里面的应用主要是清理之前走过的但是被标记为1的位置，将该位置重新置为0，以便下一次的位置可以访问
	 *
	 * 
	 * 判断[i,j]-->[targetI,targetJ]是否可行
	 * 
	 * @param i
	 * @param j
	 * @param i2
	 * @param k
	 * @param array
	 * @param maxRow
	 * @param maxLine
	 * @return
	 */
	private static boolean canMove(int i, int j, int targetI, int targetJ,
			int[][] array, int maxRow, int maxLine) {
		if (targetI < 0 || targetJ < 0 || targetI >= maxRow
				|| targetJ >= maxLine) {
			// System.out.println("到达最左边或最右边，失败了");
			return false;
		}
		if (array[targetI][targetJ] == 1) {
			// System.out.println("目标是墙，失败了");
			return false;
		}
		if (array[targetI][targetJ] == 8) {
			// System.out.println("来回走，失败了");
			return false;
		}
		return true;
	}

	/**
	 * 打印可行路径
	 * 
	 * @param array
	 * @param maxRow
	 * @param maxLine
	 */
	private static void print(int[][] array, int maxRow, int maxLine) {
		System.out.println("得到一个解：");
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxLine; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}

	}

}
