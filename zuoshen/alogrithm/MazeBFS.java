package com.alogrithm.maze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.google.gson.Gson;

public class MazeBFS {

	private static final int M = 4;
	private static final int N = 4;
	int[][] maze;// 迷宫布局：1表示障碍物
	int[][] visit;// 标记是否已经访问过
	int[][] stepArr = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 方向：左 上 右
																	// 下

	/*
	 * 定义节点模型
	 */
	class Node {
		int x, y, preX, preY;
		int step;

		public Node(int x, int y, int preX, int preY, int step) {
			this.x = x;
			this.y = y;
			this.preX = preX;
			this.preY = preY;
			this.step = step;
		}

	}

	public void init() {
		maze = new int[][] { { 0, 0, 1, 1 }, { 0, 0, 0, 1 }, { 1, 1, 0, 1 },
				{ 0, 0, 0, 0 } };
		visit = new int[4][4];
	}

	public int bfs() {
		Node node = new Node(0, 0, -1, -1, 0);
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			Node head = queue.poll();// 弹出queue的头节点 FIFO
			// System.out.println("queue:" + new Gson().toJson(queue));// F6跳过
			// System.out.println("head:" + new Gson().toJson(head));// F6跳过
			stack.push(head);// 用于回溯路径
			// System.out.println("stack:" + new Gson().toJson(stack));
			visit[head.x][head.y] = 1;// 访问过的点标记为1，visit初始值为0
			for (int i = 0; i < 4; i++) {
				int x = head.x + stepArr[i][0];// 对应的x轴增减 {-1,0} 第一个元素
				int y = head.y + stepArr[i][1];// 对应的y轴增减{-1,0} 第二个元素
				// exit 找到节点的条件
				if (x == M - 1 && y == N - 1 && maze[x][y] == 0
						&& visit[x][y] == 0) {// 找到目标点后，开始打印路径
					// 打印路径
					Node top = stack.pop();
					System.out.println("steps:" + (top.step + 1));
					System.out.println("the path:");
					System.out.println((M - 1) + "," + (N - 1));
					System.out.println(top.x + "," + top.y);

					int preX = top.preX;
					int preY = top.preY;
					while (!stack.isEmpty()) {// stack存的是回溯的点的坐标
						top = stack.pop();
						if (preX == top.x && preY == top.y) {//
							System.out.println(preX + "," + preY);
							preX = top.preX;
							preY = top.preY;
						}
					}
					return 0;
				}
				// bfs
				if (x >= 0 && x < M && y >= 0 && y < N && maze[x][y] == 0// 判断这个点能不能走，首先在0-M，0-N范围内，为0（表示可以走，1表示不可以走）且没有被访问过（visit初始值为0）
						&& visit[x][y] == 0) {
					Node newNode = new Node(x, y, head.x, head.y, head.step + 1);
					// System.out.println("if newNode:"
					// + new Gson().toJson(newNode));
					queue.offer(newNode);// 此点可以走，加入queue
					// System.out.println("if queue:" + new
					// Gson().toJson(queue));
				}
			}

		}

		return -1;
	}

	public static void main(String[] args) {

		MazeBFS mazeBFS = new MazeBFS();
		mazeBFS.init();
		if (mazeBFS.bfs() < 0) {
			System.out.println("Fail! Maybe no solution");
		}

	}
	/*
	 * 对应于题目的输入数组：
	 * 
	 * 0,1,0,0,0, 0,1,0,1,0, 0,0,0,0,0, 0,1,1,1,0, 0,0,0,1,0,
	 * 
	 * 我们把节点定义为(x,y)，(x,y)表示数组maze的项maze[x][y]。
	 * 
	 * 于是起点就是(0,0)，终点是(4,4)。按照刚刚的思路，我们大概手工梳理一遍：
	 * 
	 * 初始条件：
	 * 
	 * 起点Vs为(0,0)
	 * 
	 * 终点Vd为(4,4)
	 * 
	 * 灰色节点集合Q={}
	 * 
	 * 初始化所有节点为白色节点
	 * 
	 * 开始我们的广度搜索！
	 * 
	 * 手工执行步骤【PS：你可以直接看图4-1】:
	 * 
	 * 1.起始节点Vs变成灰色，加入队列Q，Q={(0,0)}
	 * 
	 * 2.取出队列Q的头一个节点Vn，Vn={0,0}，Q={}
	 * 
	 * 3.把Vn={0,0}染成黑色，取出Vn所有相邻的白色节点{(1,0)}
	 * 
	 * 4.不包含终点(4,4)，染成灰色，加入队列Q，Q={(1,0)}
	 * 
	 * 5.取出队列Q的头一个节点Vn，Vn={1,0}，Q={}
	 * 
	 * 6.把Vn={1,0}染成黑色，取出Vn所有相邻的白色节点{(2,0)}
	 * 
	 * 7.不包含终点(4,4)，染成灰色，加入队列Q，Q={(2,0)}
	 * 
	 * 8.取出队列Q的头一个节点Vn，Vn={2,0}，Q={}
	 * 
	 * 9.把Vn={2,0}染成黑色，取出Vn所有相邻的白色节点{(2,1),(3,0)}
	 * 
	 * 10.不包含终点(4,4)，染成灰色，加入队列Q，Q={(2,1),(3,0)}
	 * 
	 * 11.取出队列Q的头一个节点Vn，Vn={2,1}，Q={(3,0)}
	 * 
	 * 12. 把Vn={2,1}染成黑色，取出Vn所有相邻的白色节点{(2,2)}
	 * 
	 * 13.不包含终点(4,4)，染成灰色，加入队列Q，Q={(3,0),(2,2)}
	 * 
	 * 14.持续下去，知道Vn的所有相邻的白色节点中包含了(4,4)……
	 * 
	 * 15.此时获得了答案
	 */

}
