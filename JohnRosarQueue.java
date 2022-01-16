//John Rosar
//COSC 2436
//Assignment 2



public class JohnRosarQueue<E> {
	  private java.util.LinkedList<E> list 
	    = new java.util.LinkedList<E>();

	  public JohnRosarQueue(int i) {
		// TODO Auto-generated constructor stub
	}

	public void enqueue(E e) {
	    list.addLast(e);
	  }

	  public E dequeue() {
	    return list.removeFirst();
	  }

	  public int getSize() {
	    return list.size();
	  }

	  @Override
	  public String toString() {
	    return "Queue: " + list.toString();
	  }

	public static void insert(int i) {
		// TODO Auto-generated method stub
		
	}
	}


