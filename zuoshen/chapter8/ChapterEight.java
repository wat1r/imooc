package zuoshen.chapter8;

import java.util.LinkedList;
import java.util.Queue;

public class ChapterEight {

	public static void main(String[] args) {
		ChapterEight ce = new ChapterEight();

	/*	int[][] m = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };

		ce.minPathValue(m);*/
		
		int [][] m = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
				};

		ce.spiralOrderPrint(m);
	}

	/**
	 * 求最短通路值(BFS) P384 没懂
	 * 
	 * @param m
	 * @return
	 */
	public int minPathValue(int[][] m) {

		System.out.println("---------");
		// m的数组不存在，或是起始不为1时，返回0，表明无此路径（）
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
	 * 转圈打印矩阵 P331
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
		if (tR == dR) {//子矩阵只有一行（row）
			for (int i = tC; i <= tC; i++) {
				System.out.print(m[tR][i] + " ");
			}
		} else if (tC == dC) {//子矩阵只有一列（column）
			for (int i = tR; i <= dR; i++) {
				System.out.print(m[i][tC] + " ");
			}
		} else {//其他情况
			int curC = tC;
			int curR = tR;
			//以下顺序严格按转圈打印矩阵的方式进行编写，不可调整乱了
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
