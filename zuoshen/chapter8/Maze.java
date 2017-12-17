package zuoshen.chapter8;

import java.util.Scanner;
import java.util.Stack;

/**
 * zuoshen ʹ�õ� Stack������
 * @author FrankCooper
 *
 */
public class Maze {

	public static void main(String[] args) {
		Maze maze = new Maze();
		maze.findPath();
	}

	// ��ʱ����·��
	private Stack<MazeCell> pathStack = new Stack<MazeCell>();

	private int[][] maze;
	private boolean flag = false;
	private MazeCell startCell;
	private MazeCell endCell;

	public Maze() {
		initialMaze();
	}

	public void findPath() {
		assert flag;
		processCell(startCell.getX(), startCell.getY(), startCell.getStep());
	}

	private void move(int x, int y, int step) {
		if (canMove(x, y)) {
			MazeCell mazeCell = new MazeCell(x, y, step);
			insertToPath(mazeCell);
			processCell(x, y, step);
		}

	}

	private void insertToPath(MazeCell mazeCell) {
		while (pathStack.peek().getStep() >= mazeCell.getStep()) {
			pathStack.pop();
		}
		pathStack.push(mazeCell);
	}

	private void processCell(int x, int y, int step) {
		if (x == endCell.getX() && y == endCell.getY()) {
			pathStack.pop();
			printPath();
			System.out.println("(" + endCell.getX() + "," + endCell.getY()
					+ ")");
			return;
		}
		move(x, y - 1, step + 1);
		move(x, y + 1, step + 1);
		move(x - 1, y, step + 1);
		move(x + 1, y, step + 1);

	}

	private boolean canMove(int x, int y) {
		if (maze[x][y] == 1) {
			return false;
		}
		for (int i = 0; i < pathStack.size(); i++) {
			MazeCell mazeCell = pathStack.get(i);
			if (mazeCell.getX() == x && mazeCell.getY() == y) {
				return false;
			}

		}

		return true;
	}

	private void printPath() {
		for (int i = 0; i < pathStack.size(); i++) {
			MazeCell cell = pathStack.get(i);
			System.out.print("(" + cell.getX() + "," + cell.getY() + ")->");
		}
	}

	private void initialMaze() {
		int column;
		int row;
		Scanner scanner = new Scanner(System.in);
		int temp = 0;
		do {
			System.out.println("�������Թ�����(>0)��");
			temp = scanner.nextInt();
		} while (temp <= 0);
		row = temp;
		do {
			System.out.println("�������Թ�����(>0)��");
			temp = scanner.nextInt();
		} while (temp <= 0);
		column = temp;
		maze = new int[row + 2][column + 2];
		System.out.println("�������Թ���1Ϊǽ��0Ϊ·��-1Ϊ��㣬2Ϊ�յ㣩:");
		for (int i = 0; i < column + 2; i++) {
			maze[0][i] = 1;
		}
		for (int i = 1; i < row + 1; i++) {
			maze[i][0] = 1;
			for (int j = 1; j < column + 1; j++) {
				temp = scanner.nextInt();
				switch (temp) {
				case -1:
					startCell = new MazeCell(i, j, 0);
					maze[i][j] = temp;
					pathStack.push(startCell);
					break;
				case 2:
					endCell = new MazeCell(i, j, -1);
				case 0:
				case 1:
					maze[i][j] = temp;
					break;
				default:
					System.out.println("���벻����Ҫ��T T");
					return;
				}
			}
			maze[i][column + 1] = 1;
		}
		for (int i = 0; i < column + 2; i++) {
			maze[row + 1][i] = 1;
		}
		if (startCell != null && endCell != null) {
			flag = true;
			System.out.println("����ɹ�:)");
		} else {
			System.out.println("����Ҫ��һ�������յ�:(");
		}
	}
}
