package com.alogrithm.maze;

import java.util.*;

import com.google.gson.Gson;

public class Maze {

	private int[][] maze = null;
	private Stack<Position> stack = null; // ����һ��ջ���ڴ洢״̬
	private boolean[][] p = null;// �����p����������Ѿ��߹��ĵ㣬��ʼ��Ϊfalse

	private int row; // ����
	private int col;

	/**
	 * �����Թ�
	 */
	public Maze(int[][] maze) {
		stack = new Stack<Position>();
		row = maze[0].length;// ����
		col = maze.length; // ����
		p = new boolean[row + 2][col + 2];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				p[i][j] = false; // ��ʼ��
			}
		}
		this.maze = maze;
	}

	/**
	 * �����Թ����鿴�Ƿ��г�·
	 */
	public void findPath() {
		// ����һ���µ��Թ��������߶�Χ��ǽ��Ҳ���������ܶ�����1��ǽ���γ��µ��Թ�����Ҫ��Ŀ�ľ��Ƿ�ֹ�ߵ��Թ��ı߽�ĳ��ڵ�λ�û��������ǰ��
		// �����Ҫ��ȷ���ж��Ƿ��ڱ߽����ϣ�����Ҫ����Χ����һ��ǽ,
		int[][] temp = new int[row + 2][col + 2];
		for (int i = 0; i < row + 2; ++i) {
			for (int j = 0; j < col + 2; j++) {
				temp[0][j] = 1; // ��һ��Χ��
				temp[i][0] = 1;// ���ߵ�Χ��
				temp[i][col + 1] = 1;// ���ߵ�Χ��
				temp[row + 1][j] = 1;// ���һ��Χ��
			}
		}

		// ��ԭʼ�Թ����Ƶ��µ��Թ���
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				temp[i + 1][j + 1] = maze[i][j];
			}
		}

		// �����Ͻǿ�ʼ����˳ʱ�뿪ʼ��ѯ
		int i = 1;
		int j = 1;
		p[i][j] = true;
		stack.push(new Position(i, j));// debug���Ե�ʱ��������Ƶ�stack��ʱ��ʵ��������toString������
		// �������ǽ��ߵ��ĵ���ջ��Ȼ�����ǰ�����Ҷ��߲�ͨ�Ļ��ų�ջ
		while (!stack.empty() && !end(i, j)) {
			// ����Ϳ�ʼ��������̽�������·����ǰ�ߣ�˳��ֱ����ң��£��ϣ��󣬵�Ȼ������㶨��ģ�����һ�㶼�������º��ҵ�
			if (temp[i][j + 1] == 0 && p[i][j + 1] == false) {// ��������������ܼ���ǽ����ô�ڵ���߽��жϵ�ʱ��ͻ���ֳ�������������Ĵ�����Ϊ����߽��ټ�һ�ͻ����
				p[i][j + 1] = true;
				stack.push(new Position(i, j + 1));
				j++;
			} else if (temp[i + 1][j] == 0 && p[i + 1][j] == false) {// //�����������ߵĻ�������ǰ��ѹ��ջ��i++�ߵ���һ����
				p[i + 1][j] = true;
				stack.push(new Position(i + 1, j));
				i++;
			} else if (temp[i][j - 1] == 0 && p[i][j - 1] == false) {// ����
				p[i][j - 1] = true;
				stack.push(new Position(i, j - 1));
				j--;
			} else if (temp[i - 1][j] == 0 && p[i - 1][j] == false) {// ����
				p[i - 1][j] = true;
				stack.push(new Position(i - 1, j));
				i--;
			} else {// ǰ�����Ҷ������� ����Ѿ��߹��ĵ� p����Ϊtrue����ʾ�����Ҳ�����ߣ���������
				System.out.println(i + "---------" + j);
				stack.pop();// ����㲻����ͨ������
				if (stack.empty()) {// �����ջ���Ѿ�û�е��ˣ���ôֱ������ѭ��
									// ����û�е�����ߣ�һ�������ݣ�stackΪ�գ���ʾ�ص������λ��
					System.out.println("û��·���ˣ�����ȥ��");
					return; // ֱ���˳��ˣ�����Ͳ�������
				}
				i = stack.peek().row; // ������µ������
				j = stack.peek().col;
			}

			// ����Ѿ������˱߽磬��ôֱ�ӿ��Գ�ȥ�ˣ�����Ҫ������ǰ���ˣ������ǹ涨�߽������Ϊ0��λ�ö��ǳ���
			// �����������жϵĻ�����ô������߽��ʱ��ֻ���ߵ��������ߵ�ʱ��Ż����·�ߣ�������·�����������ǱȽϳ���
			// ֻҪ�������ұߵ��Ƕ�ǽ���Ϳ�ʼ���´�ӡ�߹���·��
			if (j == temp[0].length - 2) { // ����Ѿ�����߽��ˣ���ô��ǰ��λ�þ��ǳ��ڣ��Ͳ���Ҫ������
				Stack<Position> pos = new Stack<Position>();
				System.out.println("·�����£�");
				for (int count = 0; count < stack.size(); count++) {
					System.out.println(stack.elementAt(count));
				}
			}
		}

	}

	public boolean end(int i, int j) {
		return i == row && j == col;
	}

	public static void main(String[] args) {
		int[][] maze = { { 0, 1, 0, 0, 0 }, { 0, 1, 0, 1, 0 },
				{ 0, 0, 1, 0, 0 }, { 0, 1, 1, 1, 0 }, { 0, 0, 0, 1, 0 } };
		Maze main = new Maze(maze);
		main.findPath();

	}
}

class Position {

	public int col;
	public int row;

	public Position() {
		row = 0;
		col = 0;
	}

	public Position(int row, int col) {
		this.col = col;
		this.row = row;
	}

	// ������������Χ����ǽ����������������Ҫ��ԭ���Ļ����ϼ�һ
	public String toString() {
		return "(" + (row - 1) + " ," + (col - 1) + ")";
	}

}