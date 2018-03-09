package zuoshen.chapter3;

import java.util.LinkedList;
import java.util.Queue;

public class ChapterThree {

	public static void main(String[] args) {

		ChapterThree ct = new ChapterThree();
		String preStr = "12!3!#!#!#!";
		ct.reconByPreString(preStr);

	}

	/**
	 * 二叉树的序列化和反序列化 P103 先序序列化
	 * 
	 * @param head
	 * @return
	 */
	public String serialByPre(Node head) {

		if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);

		return res;

	}

	/**
	 * 二叉树的序列化和反序列化 P103 反序列化
	 * 
	 * @param preStr
	 * @return
	 */
	public Node reconByPreString(String preStr) {
		String[] values = preStr.split("!");
		Queue<String> queue = new LinkedList<>();
		for (int i = 0; i < values.length; i++) {
			queue.offer(values[i]);
		}
		return reconPreOrder(queue);
	}

	public Node reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if ("#".equals(value)) {
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;

	}

	public String serialByLevel(Node head) {
		if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		Queue<Node> queue = new LinkedList<>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			if (head.left != null) {
				res += head.left + "!";
				queue.offer(head.left);
			} else {
				res += "#!";
			}
			if (head.right != null) {
				res += head.right + "!";
				queue.offer(head.right);
			} else {
				res += "#!";
			}
		}

		return res;

	}

}
