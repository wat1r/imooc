package zuoshen.chapter1;

import java.util.Stack;

/**
 * ���һ����getMin���ܵ�ջ stack1 P1
 * 
 * @author FrankCooper
 * 
 */
public class MyStack1 {

	private Stack<Integer> stackData;// ���浱ǰջ��Ԫ��
	private Stack<Integer> stackMin;// ����ÿһ������Сֵ

	public MyStack1() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}

	public void push(int newNum) {
		if (this.stackMin.isEmpty()) {// stackMinΪ��ʱ����newNumѹ��stackMin
			this.stackMin.push(newNum);
		} else if (newNum <= this.getMin()) {// ���newNum��С����������ȣ���newNumҲѹ��stackMin
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
