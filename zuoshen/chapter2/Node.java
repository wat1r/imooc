package zuoshen.chapter2;

/**
 * 
 * 
 * @author FrankCooper
 * 
 */
public class Node {

	public int value;
	public Node next;

	public Node(int data) {
		this.value = data;
	}

	/**
	 * Chapter2 P34 打印两个有序链表的公共部分
	 * 
	 * @param head1
	 * @param head2
	 */
	public void printCommonPart(Node head1, Node head2) {

		System.out.print("Common part: ");
		while (head1 != null && head2 != null) {
			if (head1.value < head2.value) {
				head1 = head1.next;
			} else if (head1.value > head2.value) {
				head2 = head2.next;
			} else {
				System.out.print(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		System.out.print(" ");
	}

	/**
	 * 翻转单向链表 P40
	 * 
	 * @param head
	 * @return
	 */
	public Node reverseList(Node head) {
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	/**
	 * 反转部分单向链表 P42
	 * 
	 * @param head
	 * @param from
	 * @param to
	 * @return
	 */
	public Node reversePart(Node head, int from, int to) {
		int len = 0;
		Node node1 = head;
		Node fPre = null;
		Node tPos = null;
		while (node1 != null) {
			len++;
			fPre = len == from - 1 ? node1 : fPre;
			tPos = len == to + 1 ? node1 : tPos;
			node1 = node1.next;
		}

		if (from > to || from < 1 || to > len) {
			return head;
		}

		return null;
	}

	public static void main(String[] args) {

	}
}
