
public class MyLinkedList implements ListInterface {

    /* TODO: Write a LinkedList implementation for all the methods specified in ListInterface */

    protected Node head;
    protected int size;

    public MyLinkedList(){
        size = 0;
        head = null;
    }

    public class Node{
        Object item;
        Node next;

        Node(Object i){
            item = i;
            next = null;
        }

    }

    // Returns true if the list is empty, false otherwise.
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    // Returns the size of the list (number of items in the list)
    public int size(){
        return size;
    }


    public void add(int index, Object value) throws ListIndexOutOfBoundsException {
        if ( index >= 0 && index <= this.size ) {
            if ( index == 0 ) {
                Node newNode = new Node(value);
                if ( !isEmpty() ) {
                    newNode.next = this.head.next;
                }
                this.head = newNode;
                this.size++;
            }
            else {
               Node n = this.head;
               Node newNode = new Node(value);
                for (int i = 0; i < index -1 ; i++) {
                   // if ( n.next == null ) {
                   //     // add new
                   //     newNode.next = n.next;
                   //     n.next = newNode;
                   // }
                   // else {
                       n = n.next;
                   // }
               }
               // if (n.next != null && n.next != newNode) {
                    newNode.next = n.next;
                    n.next = newNode;
               // }
               this.size++;
            }
        }
        else {
            throw new ListIndexOutOfBoundsException("ADD: Index " + index + " is out of bounds");
        }
    }

    public void remove(int index) throws ListIndexOutOfBoundsException {
        if ( index >= 0 && index <= this.size ) {
            Node n = this.head;
            for (int i = 0; i < index  ; i++) {
                    n = n.next ;
            }
            if (n.next !=  null) {
                n.next = n.next.next;
            }
            else {
                n.next = null;
            }
            this.size--;
        }
        else {
            throw new ListIndexOutOfBoundsException("REMOVE: Index " + index + " is out of bounds");
        }

    }

    public void removeAll() {
        this.head.next = null;
        this.size = 0;
    }

    public Object get(int index) throws ListIndexOutOfBoundsException {
        if ( index == 0 ) {
            return this.head.item;
        }
        if ( index > 0 && index <= this.size ) {
            Node n = this.head;
            for (int i = 0; i < index  ; i++) {
                n = n.next ;
            }
            return n.item;
        }
        else {
            throw new ListIndexOutOfBoundsException("GET: Index " + index + " is out of bounds");
        }

    }

    public int find(Object o) { // here object is String ?
        if ( isEmpty() ) {
            return -1 ;
        }
        Node n = this.head;
        String rgo = "";
        String rgn = "";
        if (o instanceof String) {
            rgo = (String) o;
        }
        else if (o instanceof RhymeGroupWords) {
            RhymeGroupWords obj = (RhymeGroupWords) o;
            rgo = obj.getRhymeGroup();
        }
        for (int i = 0; i < this.size()  ; i++) {
            if(n!= null){
                if ( n.item instanceof String) {
                    rgn = (String) n.item;
                }
                else if (n.item instanceof RhymeGroupWords) {
                    RhymeGroupWords rgwn = (RhymeGroupWords) n.item;
                    rgn = rgwn.getRhymeGroup();
                }
                if (rgn.equals(rgo)) {
                    return i;
                }
                n = n.next;
            }
        }
        return -1;
   }


// public class MyLinkedList implements ListInterface {

// 	/* TODO: Write a LinkedList implementation for all the methods specified in ListInterface */

// 	protected Node head;
// 	protected int size;

// 	public MyLinkedList(){
// 		size = 0;
// 		head = null;
// 	}

// 	protected class Node{
// 		Object item;
// 		Node next;
		

// 		Node(Object i){
// 			item = i;
// 			next = null;
			
// 		}
// 	}
// 	// Returns true if the list is empty, false otherwise.
// 	public boolean isEmpty(){
// 		if(size == 0){
// 			return true;
// 		}
// 		else{
// 			return false;
// 		}

// 	}

// 	// Returns the size of the list (number of items in the list)
// 	public int size(){
// 		return size;
// 	} 

// 	// Adds an Object to the linkedlist at the specified index. 
// 	public void add(int index, Object value) throws ListIndexOutOfBoundsException{

// 		if(index >= 0 && index <= size+1){

// 			if(index == 0){
	
// 				Node newNode = new Node(value);
// 				newNode.next = head;
// 				head = newNode;
// 			}

// 			else{
// 				Node prev = head;
// 				for(int i = 0; i <= index -1; i++){
// 					prev = prev.next;
// 				}
// 				Node newNode = new Node(value);
// 				newNode.next = prev.next;
// 				prev.next = newNode;


// 			}

// 		size++;

// 		}

// 		else{
// 			throw new ListIndexOutOfBoundsException("Index " + index + "is out of bounds");
// 		}
// 	}

// 	// Removes an item from the list at the specified index. 
// 	public void remove(int index)throws ListIndexOutOfBoundsException {
// 		if(index >= 0 && index < size) {
// 			if(index == 0){
// 				head = head.next;
// 			}
// 			else if(index == size()){
// 				Node prev = head;
// 				for(int i = 0; i < index -1; i++){
// 					prev = prev.next;
// 				}
// 				prev.next = null;
// 			}
// 			else{
// 				Node prev = head;
// 				for(int i = 0; i < index -1; i++){
// 					prev = prev.next;
// 				}
// 				prev.next = prev.next.next;
// 			}
// 			size--;
// 		}
// 		else{
// 			throw new ListIndexOutOfBoundsException("Index " + index + "is out of bounds");
// 		}
		
// 	}

// 	// Removes all the items from the list. 
// 	public void removeAll(){
// 		head = null;
// 		size = 0;

// 	}

//    // Returns the Object stored in the list at the specified index. 
// 	public Object get(int index)throws ListIndexOutOfBoundsException{
// 		if(index >= 0 && index < size){
// 			Node node = head;
// 			for(int i = 0; i < index; i++){
// 				node = node.next;
// 			}
// 			return node.item;

// 		}
// 		else{
// 			throw new ListIndexOutOfBoundsException("Index " + index + "is out of bounds");
// 		}

// 	}

// 	// Returns the index at which an Object is stored in the list, -1 if it's not in the list.
// 	@SuppressWarnings({ "rawtypes", "unchecked" })
// 	public int find(Object o){
// 		Node curr = head;
// 		for(int i = 0; i < size; i++){
// 			if(((Comparable)curr.item).compareTo((Comparable) o) == 0) {
// 				return i;
// 			}
// 			curr = curr.next;

// 		}
// 		return -1;

// 	}

    public String toString(){
        Node current = head;
        String result = "";

       while(current != null){
        result = result+current.item+" ";
        current = current.next;
       }

       return result;
    }
}

