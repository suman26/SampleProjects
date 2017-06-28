package com.citi.tds.dna.consumer.externalenricher.qps;

class Lnode
{
	int data;
	Lnode next;
	
	Lnode(int data)
	{
		this.data=data;
		this.next=null;
	}
}
public class LinkedListEx {

	Lnode head;
	LinkedListEx()
	{
		head=null;
	}
	//////////////////////////////////
	void printList(Lnode head)
	{
		Lnode curr=head;
		while(curr!=null)
		{
			System.out.println(curr.data);
			curr=curr.next;
		}
	}
	//////////////////////////////////
	int countList(Lnode head)
	{
		Lnode curr=head;
		int count=0;
		while(curr!=null)
		{
			count++;
			curr=curr.next;
		}
		return count;
	}
	//////////////////////////////////
	Lnode reverseList(Lnode head)
	{
		Lnode curr=head;
		Lnode prev=null;
		Lnode next;
		while(curr!=null)
		{
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
		return prev;
	}
	/////////////////////////////////
	int middleList(Lnode head)
	{
		if(head==null)
			return 0;
		Lnode slow=head;
		Lnode fast=head;
		while(fast!=null&&fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}
	/////////////////////////////////
	boolean detectLoop(Lnode head)
	{
		Lnode slow=head;
		Lnode fast=head;
		boolean flag=false;
		while(fast!=null && slow!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow)
			{
				flag=true;
				break;
			}
		}
		
		return flag;
	}
	/////////////////////////////////
	//Lnode intersectionList()
	public Lnode intersectionList(Lnode head1,Lnode head2)
	{
		int  c1=0,c2=0;
		int len=0;
		String traverse =null;
		Lnode curr1=head1,curr2=head2;
		while(curr1!=null)
		{
			c1++;
			curr1=curr1.next;
		}
		while(curr2!=null)
		{
			c2++;
			curr2=curr2.next;
		}
		if(c1>c2){
			traverse="List1";
			len=c1-c2;
		}
		else
		{
			traverse="List2";
			len=c2-c1;
		}
		curr1=head1;
		curr2=head2;
		for(int i=0;i<len;i++)
		{
			if(traverse.equals("List1"))
			{
				curr1=curr1.next;
			}
			else if(traverse.equals("List2"))
			{
				curr2=curr2.next;
			}
		}
		while(curr1!=curr2 && curr1!=null && curr2!=null)
		{
			curr1=curr1.next;
			curr2=curr2.next;
		}
		return curr1;
		
		
	}
	/////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         LinkedListEx list=new LinkedListEx();
          list.head=new Lnode(1);
          list.head.next=new Lnode(2);
          list.head.next.next=new Lnode(3);
          list.head.next.next.next=new Lnode(4);
          list.head.next.next.next.next=new Lnode(5);
          list.printList(list.head);
          list.countList(list.head);
          Lnode head2=list.reverseList(list.head);
          list.printList(head2);
          System.out.println(list.middleList(list.head));    
          LinkedListEx list1=new LinkedListEx();
          list1.head=new Lnode(1);
          list1.head.next=new Lnode(2);
          list1.head.next.next=new Lnode(3);
          list1.head.next.next.next=new Lnode(4);
          list1.head.next.next.next.next=new Lnode(5);
          list1.head.next.next.next.next.next=list1.head;
          System.out.println(list1.detectLoop(list1.head));
	}
}
