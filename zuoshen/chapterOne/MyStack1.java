package zuoshen.chapter1;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈 stack1 P1
 * 
 * @author FrankCooper
 * 
 */
public class MyStack1 {

	private Stack<Integer> stackData;// 保存当前栈的元素
	private Stack<Integer> stackMin;// 保存每一步的最小值

	public MyStack1() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}

	public void push(int newNum) {
		if (this.stackMin.isEmpty()) {// stackMin为空时，将newNum压入stackMin
			this.stackMin.push(newNum);
		} else if (newNum <= this.getMin()) {// 如果newNum更小或者两者相等，则newNum也压入stackMin
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}

	public int pop() {
		if (this.stackData.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		int value = this.stackData.pop();
		if (value == this.getMin()) {
			this.stackMin.pop();
		}
		return value;
	}

	public int getMin() {

		if (this.stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		return this.stackMin.peek();
	}
}
