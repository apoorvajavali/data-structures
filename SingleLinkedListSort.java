
public class SingleLinkedListSort { 
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.insert(new Node(0));
		list.insert(new Node(6));
		list.insert(new Node(5));
		list.insert(new Node(8));
		list.insert(new Node(15));
		list.insert(new Node(200));
		list.insert(new Node(7));
		list.insert(new Node(3));
		list.insert(new Node(10));
		list.insert(new Node(13));
		list.insert(new Node(12));
		list.insert(new Node(26));
		list.insert(new Node(1));
		list.insert(new Node(30));
		list.insert(new Node(4));
		
		System.out.print(list.large(list.head));
	}
	
}

class LinkedList{
	Node head = null;
	public void insert(Node n) {
		if(head == null) {
			head = n;
		}else {
			n.next = head;
			head = n;
		}
	}
	
	public void printList(Node head) {
		Node temp = head;
		if(temp == null)
			return;
		System.out.print(temp.value+" ");
		printList(temp.next);
	}
	
	public int large(Node head) {
		if(head.next == null)
			return head.value;
		return Math.max(head.value, large(head.next));
	}
	
	public Node sortList(Node head) {
		Node beforeMin = null;
		Node beforeCurrent = null;
		Node current = head;
		while(current.next != null) {
			Node min = current;
			Node temp1 = current;
			
			if(current == head.next)
				beforeCurrent = head;
			else if(current != head)
				beforeCurrent = beforeCurrent.next;
			
			while(temp1.next != null) {
				if(temp1.next.value < min.value) {
					min = temp1.next;
					beforeMin = temp1;
				}
				temp1 = temp1.next;
			}
			Node cTemp = current;
			if(current.next != min)
				current = current.next;
			if(beforeCurrent == null) 
				head = min;
			if(min != cTemp)
				this.swap(beforeCurrent, cTemp, beforeMin, min);
		}
		return head;
	}
	
	public void swap(Node beforeCurrent, Node current, Node beforeMin, Node min) {
		Node temp = min.next;
		if(current.next == min) {
			min.next = current;
			current.next = temp;
		}else {
			min.next = current.next;
			beforeMin.next = current;
			current.next = temp;
		}
		if(beforeCurrent != null)
			beforeCurrent.next = min;
	}
	
	Node reverse(Node head) {
		Node prev = null;
		Node temp = head;
        while(temp.next != null) {
        	head = temp.next;
            temp.next = prev;
            prev = temp;
            temp = head;
        }
        head.next = prev;
        return head;
	}
}

class Node{
	int value;
	Node next;
	
	Node(int value){
		this.value = value;
		this.next = null;
	}
}

