package zuoshen.chapter1;

import java.util.Stack;

/**
 * ������ջ��ɵ����� P5
 * 
 * @author FrankCooper
 * 
 */
public class TwoStackQueue {

	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;

	public TwoStackQueue() {
		this.stackPush = new Stack<Integer>();
		this.stackPop = new Stack<Integer>();

	}

	public void push(int pushInt) {
		stackPush.push(pushInt);
	}

	public int poll() {
		if (stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("Queue is empty.");
		} else if (stackPop.empty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}

		return stackPop.pop();
	}

	public int peek() {
		if (stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("Queue is empty.");
		} else if (stackPop.empty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}

		return stackPop.peek();
	}
}
