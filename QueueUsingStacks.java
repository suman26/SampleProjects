package example;

import java.util.Stack;

public class QueueUsingStacks {
	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public QueueUsingStacks() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void enqueue(int x) {
		stack1.push(x);
	}

	public int deque() {
		int temp = -1;
		if (stack1.isEmpty() && stack2.isEmpty())
			return -1;
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		temp = stack2.pop();
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return temp;
	}

	public static void main(String[] args) {
		QueueUsingStacks Qs = new QueueUsingStacks();
		System.out.println(Qs.deque());
		Qs.enqueue(1);
		Qs.enqueue(3);
		System.out.println(Qs.deque());
		System.out.println(Qs.deque());
		System.out.println(Qs.deque());
		System.out.println(Qs.deque());
		Qs.enqueue(5);
		Qs.enqueue(6);
		System.out.println(Qs.deque());
		System.out.println(Qs.deque());
		System.out.println(Qs.deque());

	}
}
