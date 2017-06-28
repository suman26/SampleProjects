package example;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> minStack;
	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty()) {
			minStack.push(x);
			return;
		} else {
			if (minStack.peek() >= x)
				minStack.push(x);
		}
		return;
	}
	public int pop() {
		if (stack.isEmpty())
			return -1;
		int temp = stack.pop();
		if (temp <= minStack.peek())
			minStack.pop();
		return temp;
	}

	public int minElem() {
		if (minStack.isEmpty())
			return -1;
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack Ms = new MinStack();
		System.out.println(Ms.pop());
		System.out.println(Ms.minElem());
		Ms.push(2);
		Ms.push(1);
		System.out.println(Ms.minElem());
		System.out.println(Ms.pop());
		System.out.println(Ms.minElem());
		Ms.push(3);
		Ms.push(4);
		Ms.push(2);
		Ms.push(1);
		System.out.println(Ms.pop());
		System.out.println(Ms.pop());
		System.out.println(Ms.pop());
		System.out.println(Ms.minElem());
		System.out.println(Ms.pop());
		System.out.println(Ms.minElem());
	}
}
