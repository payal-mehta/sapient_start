package lru.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache1 {
	int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node rear;
	Node start;
 
    public LRUCache1(int capacity) {
        this.capacity = capacity;
    }
	
	void addAtRear(int data){
		Node newNode=new Node();
		newNode.value=data;
		if(start==null){
			newNode.next=null;
			newNode.prev=null;
			start=rear=newNode;
		}
		else{
			newNode.next=start;
			newNode.prev=null;
			start=newNode;
		}
		
	}
	void remove(Node n){
		 if(n.prev!=null){
	            n.prev.next = n.next;
	        }else{
	            start = n.next;
	        }
	 
	        if(n.next!=null){
	            n.next.prev = n.prev;
	        }else{
	            rear=n.prev;
	        }
	        
	}
	void setHead(Node n){
		n.next = start;
        n.prev = null;
    	if(start!=null){
    		start.prev=n;
    	}
    	start=n;
    	if(rear!=null){
    		rear=n;
    	}
    	
    }
	
	void set(int key){
		if(map.containsKey(key)){
	        Node old = map.get(key);
	        old.value = key;
	        remove(old);
	        setHead(old);
	    }else{
	        Node created = new Node(key);
	        if(map.size()>=capacity){
	            map.remove(rear.value);
	            remove(rear);
	            setHead(created);

	        }else{
	            setHead(created);
	        }    

	        map.put(key, created);
	    }
	}
class Node{
	Node prev;
	Node next;
	int value;
	public Node() {
		// TODO Auto-generated constructor stub
	}
	Node(int k){
		value=k;
	}
}
}
