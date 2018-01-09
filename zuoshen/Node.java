package com.alogrithm.review;

import java.util.Stack;

public class Node {

	public int value;

	public Node next;

	public Node(int data) {
		this.value = data;
	}

	public boolean isPalindrom1(Node head) {

		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (head != null) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}

		return true;

	}

}
