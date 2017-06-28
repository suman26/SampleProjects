package example;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> queue1;
	Queue<Integer> queue2;

	public StackUsingQueue() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	public void push(int x) {
		if (!queue1.isEmpty() && queue2.isEmpty()) {
			queue1.add(x);
		} else if (queue1.isEmpty() && !queue2.isEmpty()) {
			queue2.add(x);
		} else if (queue1.isEmpty() && queue2.isEmpty()) {
			queue1.add(x);
		}
	}

	public int pop() {
		if (queue1.isEmpty() && queue2.isEmpty())
			return -1;
		else if (!queue1.isEmpty() && queue2.isEmpty()) {
			while (queue1.size() - 1 != 0) {
				queue2.add(queue1.poll());
			}
			return queue1.poll();
		} else if (!queue2.isEmpty() && queue1.isEmpty()) {
			while (queue2.size() - 1 != 0) {
				queue1.add(queue2.poll());
			}
			return queue2.poll();
		}
		return -1;

	}

	public static void main(String args[]) {

		StackUsingQueue obj = new StackUsingQueue();
		System.out.println(obj.pop());
		obj.push(1);
		obj.push(3);
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());

	}
}
