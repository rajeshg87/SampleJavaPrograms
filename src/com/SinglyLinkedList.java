package com;

public class SinglyLinkedList<T> {
	private Node<T> head;
	int listCount=0;
	
	public void add(T value){
		Node<T> node=new Node<T>(value);
		Node<T> temp = head;
		while(true){
			if(temp == null){
				head = node;
				break;
			}else if(temp.next == null){
				temp.next = node;
				break;
			}else{
				temp = temp.next;
			}
		}
		listCount++;
	}
	
	public void traverse(){
		Node<T> temp = head;
		while(true){
			if(temp == null){
				break;
			}
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	public Node<T> findMiddleElement(){
		Node<T> fastNode, slowNode;
		slowNode = fastNode = head;
		while(null != fastNode){
			fastNode = fastNode.next;
			if(null != fastNode && null != fastNode.next){
				fastNode = fastNode.next;
				slowNode = slowNode.next;
			}
		}
		return slowNode;
	}
	
	public Node<T> lastThirdElement(){
		Node<T> fastNode, slowNode;
		slowNode = fastNode = head;
		if(null != fastNode.next && null != fastNode.next.next){
			fastNode = fastNode.next.next;
			while(null != fastNode.next){
				fastNode = fastNode.next;
				slowNode = slowNode.next;
			}
		}else{
			return null;
		}
		return slowNode;
	}
	
	public static void main(String args[]){
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(55);
		list.traverse();
		System.out.println("List Size :"+list.listCount);
		System.out.println("Middle Element :"+list.findMiddleElement());
		System.out.println("Last Third Element :"+list.lastThirdElement());
	}
}

class Node<T>{
	T value;
	Node<T> next;
	public Node(T value) {
		super();
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	
}