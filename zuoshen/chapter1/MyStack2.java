package zuoshen.chapter1;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈 stack2 P1
 * 
 * @author FrankCooper
 * 
 */
public class MyStack2 {
	private Stack<Integer> stackData;// 保存当前栈的元素
	private Stack<Integer> stackMin;// 保存每一步的最小值

	public MyStack2() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}

	public void push(int newNum) {
		if (this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		} else if (newNum <= this.getMin()) {
			this.stackMin.push(newNum);
		} else {
			int newMin = this.stackMin.peek();
			this.stackMin.push(newMin);
		}
		this.stackData.push(newNum);
	}

	public int pop() {
		if (this.stackData.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}

	public int getMin() {
		if (this.stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		return this.stackMin.peek();
	}
}
