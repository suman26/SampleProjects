//package example;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Scanner;
//
//class Node {
//	int key;
//	int value;
//	Node pre;
//	Node next;
//
//	public Node(int key, int value) {
//		this.key = key;
//		this.value = value;
//	}
//}
//public class LruCache {
//	int capacity;
//	Node head = null;
//	Node end = null;
//	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
//
//	public LruCache(int capacity) {
//		this.capacity = capacity;
//	}
//
//	public int get(int key) {
//		if (map.containsKey(key)) {
//			Node res = map.get(key);
//			remove(res);
//			setHead(res);
//			return res.value;
//		}
//		return -1;
//	}
//
//	public void setHead(Node n) {
//		// TODO Auto-generated method stub
//		n.pre = null;
//		n.next = head;
//		if (head != null) {
//			head.pre = n;
//		}
//		head = n;
//		if (end == null) {
//			end = head;
//		}
//	}
//
//	public void set(int key, int value) {
//		if (map.containsKey(key)) {
//			Node old = map.get(key);
//			old.value = value;
//			remove(old);
//			setHead(old);
//		} else {
//			Node created = new Node(key, value);
//			if (map.size() >= capacity) {
//				map.remove(end.key);
//				remove(end);
//				setHead(created);
//			} else {
//				setHead(created);
//			}
//			map.put(key, created);
//		}
//	}
//	//////////////to test the cache implementation using LRU Cache ////////////////
//	public void remove(Node n) {
//		// TODO Auto-generated method stub
//		if (n.pre != null)
//			n.pre.next = n.next;
//		else
//			head = n.next;
//
//		if (n.next != null)
//			n.next.pre = n.pre;
//		else
//			end = n.pre;
//
//	}
//
//	public static void main(String[] args) {
//		LruCache lr = new LruCache(5);
//		
//		lr.set(1, 1);
//		lr.set(2, 2);
//		lr.set(3, 3);
//		lr.set(4, 4);
//		lr.set(5, 5);
//		int val = lr.get(1);
//		System.out.println("" + val);
//		lr.set(6, 6);
//		int val2 = lr.get(2);
//		System.out.println("" + val2);
//		lr.set(7, 7);
//		int val3=lr.get(6);
//		System.out.println(""+val3);
//	
////		Test t=new Test();
////		t.stringOps();
//
//	}
//}
//class Test
//{
//	public void stringOps()
//	{
//		Scanner sc=new Scanner(System.in);
//		System.out.println("enter the no of strings:");
//		int count=sc.nextInt();
//		List<String> al=new ArrayList<String>();
//		for(int i=0;i<count;i++)
//		{
//			al.add(sc.next());
//		}
//		
//	    Collections.sort(al);
//	    for(int j=count-1;j>=0;j--)
//	    {
//	    	System.out.print(al.get(j));
//	    }
//	    sc.close();
//	}
//}
