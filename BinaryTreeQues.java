package com.citi.tds.dna.consumer.externalenricher.qps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTreeQues {
	Node head;
	HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
	public BinaryTreeQues() {

		head = null;
	}
    ////////////////////////1////////////////////////////
	int countNodes(Node head) {
		if (head == null) {
			return 0;
		} else
			return 1 + countNodes(head.left) + countNodes(head.right);
	}
	//////////////////////2//////////////////////////////
	int countSingleChildNodes(Node head)
	{
		if(head ==null)
			return 0;
		else if((head.left!=null && head.right==null) ||(head.left==null && head.right!=null))
			return 1;
		else
			return countSingleChildNodes(head.left)+countSingleChildNodes(head.right);
	}
	/////////////////////3/////////////////////////////
	int bothChildNodes(Node head)
	{
		if(head==null)
			return 0;
		else if((head.left==null && head.right==null)||(head.left!=null && head.right==null)||(head.left==null && head.right!=null))
			return 0;
		else
			return 1+bothChildNodes(head.left)+bothChildNodes(head.right);
	}
	////////////////////4///////////////////////////////
	int nonRecursiveCountBothChild(Node root)
	{
		 if(root==null)
			 return 0;
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		int count=0;
		while(!queue.isEmpty())
		{
			Node temp=queue.poll();
			if(temp.left!=null && temp.right!=null)
				count++;
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
		
		return count;
	}
	//////////////////////5//////////////////////////////
	int nonRecursiveCountOneChild(Node root)
	{
		 if(root==null)
			 return 0;
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		int count=0;
		while(!queue.isEmpty())
		{
			Node temp=queue.poll();
			if((temp.left!=null && temp.right==null )||(temp.left==null && temp.right!=null))
				count++;
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
		
		return count;
	}
	////////////////////////6////////////////////////////
	int nonRecursiveCountNoChild(Node root)
	{
		 if(root==null)
			 return 0;
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		int count=0;
		while(!queue.isEmpty())
		{
			Node temp=queue.poll();
			if(temp.left==null && temp.right==null)
				count++;
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
		return count;
	}
	/////////////////////////7//////////////////////////
	int countNoChildNodes(Node head)
	{
		if(head==null)
			return 0;
		else if(head.left==null && head.right==null)
			return 1;
		else
			return countNoChildNodes(head.left)+countNoChildNodes(head.right);
	}
	//////////////////////////8/////////////////////////
	Node deepestNode(Node head)
	{
		if(head==null)
			return null;
		Node result=null;
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(head);
		while(!queue.isEmpty())
		{
			Node temp=queue.poll();
			result=temp;
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
		return result;
	}
	/////////////////////////10//////////////////////////
	boolean identicalTrees(Node root1,Node root2)
	{
		if((root1!=null && root2==null) || (root1==null && root2!=null) )
			return false;
		else if(root1==null && root2==null)
			return true;
			return((root1.data==root2.data)&& identicalTrees(root1.left,root2.left)&& identicalTrees(root1.right,root2.right));
	}
	//////////////////////////11/////////////////////////
	int height(Node head)
	{
		if(head!=null)
		{
		int lh=height(head.left);
		int rh=height(head.right);
		if(lh>rh)
			return lh+1;
		else
			return rh+1;
		}
		return 0;
	}
	////////////////////////12///////////////////////////
	void spiralUtil(Node head)
	{
		boolean itr=false;
		for(int i=1;i<=height(head);i++)
		{
			spiralPrintOrder(head,i,itr);
			itr=!itr;
		}
	}
	private void spiralPrintOrder(Node head ,int level,boolean itr)
	{
		if(head!=null)
		{
			if(level==1)
				System.out.println(head.data);
			else if(level>1)
			{
				if(itr)
				{
					spiralPrintOrder(head.left,level-1,itr);
					spiralPrintOrder(head.right,level-1,itr);
				}
				else
				{
				
					spiralPrintOrder(head.right,level-1,itr);
					spiralPrintOrder(head.left,level-1,itr);
				}
			}
		}
		
	}
	//////////////////////////13//////////////////////////////
	void printPaths(Node root,int[]path,int pathLen)
	{
		  if(root==null)
			  return;
		  path[pathLen++]=root.data;
			if(root.left==null && root.right==null)
				printArray(path,pathLen);
			else
			{
				printPaths(root.left,path,pathLen);
				printPaths(root.right,path,pathLen);
			}
	}
	
	private void printArray(int[] path, int pathLen) {
		// TODO Auto-generated method stub
		for(int i=0;i<pathLen;i++)
			System.out.println(path[i]);	
	}
	/////////////////////14///////////////////////////////////
	Node LCA(Node root,Node a,Node b)
	{
		if(root==null)
			return null;
		else if(root==a|| root==b)
			return root;
		Node left=LCA(root.left,a,b);
		Node right=LCA(root.right,a,b);
		if(left!=null && right!=null)
			return root;
		return (left!=null?left:right);
	}
	//////////////////////15////////////////////////////////
	int maxLevel(Node root)
	{
		if (root == null)
			return -1;
		int currLevel = 0, maxLevel = 0;
		int currSum = 0, maxSum = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		currLevel = 1;
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp == null) {
				if (currSum > maxSum) {
					maxSum = currSum;
					maxLevel = currLevel;
				}
				if (!queue.isEmpty())
					queue.add(null);
				currSum = 0;
				currLevel++;
			} else {
				if (temp.left != null) {
					queue.add(temp.left);
					currSum = currSum + temp.left.data;
				}
				if (temp.right != null) {
					queue.add(temp.right);
					currSum = currSum + temp.right.data;
				}
			}
		}
		return maxLevel;
	}
	/////////////////////16/////////////////////////////////
	int minLevel(Node root)
	{
		if (root == null)
			return -1;
		int currLevel = 0, minLevel = 0;
		int currSum = 0, minSum = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		currLevel = 1;
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp == null) {
				if (currSum < minSum) {
					minSum = currSum;
					minLevel = currLevel;
				}
				if (!queue.isEmpty())
					queue.add(null);
				currSum = 0;
				currLevel++;
			} else {
				if (temp.left != null) {
					queue.add(temp.left);
					currSum = currSum + temp.left.data;
				}
				if (temp.right != null) {
					queue.add(temp.right);
					currSum = currSum + temp.right.data;
				}
			}
		}
		return minLevel;
	}
	///////////////////17//////////////////////////////////
	void deleteTree(Node head)
	{
		if(head!=null)
		{
			deleteTree(head.left);
			deleteTree(head.right);
            head=null;
		}
		return;
	}
	///////////////////18///////////////////////////////////
	void levelOrder(Node head)
	{
		if(head==null)
			return;
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(head);
		while(!queue.isEmpty())
		{
			Node temp=queue.poll();
			System.out.print(temp.data +" ");
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
	}
	//////////////////////20////////////////////////////////
	void preOrder(Node head)
	{
		Stack<Node>stack=new Stack<Node>();
		if(head==null)
			return;
		while(true)
		{
			while(head!=null)
			{
				stack.push(head);
				System.out.print(head.data+" ");
				head=head.left;
			}
			if(stack.isEmpty())
				break;
			Node temp=stack.pop();
			head=temp.right;
		}	
	}
	///////////////////21///////////////////////////////////
	void inOrder(Node head)
	{
		Stack<Node> stack=new Stack<Node>();
		if(head==null)
			return;
		while(true)
		{
			while(head!=null)
			{
				stack.push(head);
				head=head.left;
			}
			if(stack.isEmpty())
				break;
			Node temp=stack.pop();
			System.out.print(temp.data+" ");
			head=temp.right;
		}
	}
	//////////////////22//////////////////////////////////
	boolean isBst(Node head)
 {
		Stack<Node> stack = new Stack<Node>();
		if (head == null)
			return true;
		boolean flag = true;
		Node prev = null;
		while (true) {
			while (head != null) {
				stack.push(head);
				head = head.left;
			}
			if (stack.isEmpty())
				break;
			Node curr = stack.pop();
			
			if (prev != null && prev.data > curr.data) {
				flag = false;
				break;
			}
			prev = curr;
			head = curr.right;
		}
		return flag;
	}
	///////////////////23///////////////////////////////////
	void postOrderUsingTwoStacks(Node head)
	{
		Stack<Node> s1=new Stack<Node>();
		Stack<Node> s2=new Stack<Node>();
		if(head==null)
			return;
		s1.push(head);
		while(!s1.isEmpty())
		{
			Node temp=s1.pop();
			s2.push(temp);
			if(temp.left!=null)
				s1.push(temp.left);
			if(temp.right!=null)
				s1.push(temp.right);
		}
		while(!s2.isEmpty())
		{
			System.out.print(" "+s2.pop().data);
		}	
	}
/////////////////////////////////24//////////////////////////
	boolean sumCheck(Node head,int sum)
	{
		if(head==null)
			return (sum==0);
		sum=sum-head.data;
		return sumCheck(head.left,sum)||sumCheck(head.right,sum);
	}
	
/////////////////////////25/////////////////////////////////////
	void printVerticalSum(Node root,int column)
	{
		if(root==null)
			return;
		int temp=0;
		if(root!=null)
		{
			if(map.containsKey(column))
			{
				temp=map.get(column);
				temp=temp+root.data;
				map.put(column, temp);
				
			}
			else
			{
				map.put(column, root.data);
			}
			printVerticalSum(root.left,column-1);
			printVerticalSum(root.right,column+1);
		}
		
	}
/////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreeQues bt = new BinaryTreeQues();
		/*
		            2
		           / \
		          3   4
		         / \    \
		        10  7    23
		       /
		      12
		*/
		bt.head = new Node(2);
		bt.head.left = new Node(3);
		bt.head.right = new Node(4);
		bt.head.left.right = new Node(7);
		bt.head.left.left = new Node(10);
		bt.head.left.left.left=new Node(12);
		bt.head.right.right=new Node(23);
		System.out.println(bt.countNodes(bt.head));
		System.out.println(bt.countSingleChildNodes(bt.head));
		System.out.println(bt.bothChildNodes(bt.head));
		System.out.println(bt.countNoChildNodes(bt.head));
		bt.levelOrder(bt.head);
		System.out.println();
		bt.preOrder(bt.head);
		System.out.println();
		bt.inOrder(bt.head);
		System.out.println(bt.isBst(bt.head));
		System.out.println();
		bt.postOrderUsingTwoStacks(bt.head);
	}

}
