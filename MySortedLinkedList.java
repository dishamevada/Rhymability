public class MySortedLinkedList extends MyLinkedList {

	/* TODO 
	   define the method
	   public void add(Comparable c)
	   that, given a Comparable (an interface type for all Object subclasses that define a compareTo() method), adds it to the 
	   list in sorted order.
	*/
	   public void add (Comparable c){
	   	Node n = new Node(c);
	   	Node curr = head;
	   	int count = 0; 

	   	if(head == null){
	   		super.add(0,c);
	   		return;
	   	}
	  

	   	while(curr!= null){
	   		if(((Comparable) curr.item).compareTo((Comparable)n.item) > 0){
	   			super.add(count,c);
	   			return;
	   		}
	   		count++;
	   		curr = curr.next;
	   	}

	   	super.add(count, c);
	   	count++;

	 }

	
	
	/* TODO
	   override the method
	   void add(int index, Object o)
	   so that it throws an UnsupportedOperationException with the message "Do not call add(int, Object) on MySortedLinkedList".
	   Directly adding objects at an index would mess up the sorted order.
	*/

	  public void add (int index, Object o) throws UnsupportedOperationException {
	  		System.out.println("Do not call add(int, Object) on MySortedLinkedList");
	  }
}