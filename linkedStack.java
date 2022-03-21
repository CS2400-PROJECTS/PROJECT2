
public class linkedStack<T> implements stackInterface<T> {
	 private int count;  // indicates the next open slot
	 private LinearNode<T> top; 
	 
	 public linkedStack()
	  {
	    count = 0;
	    top = null;
	  }
	@Override
	public void push(T element) {
		LinearNode<T> temp = new LinearNode<T> (element);

	    temp.setNext(top);
	    top = temp;
	    count++;
		
	}

	@Override
	public void pop() throws Exception {
		  if (isEmpty())
		      throw new Exception();

		    T result = top.getElement();
		    top = top.getNext();
		    count--;
		    return result;
	}

	@Override
	public T peek() throws Exception {
		 if (isEmpty())
		      throw new Exception(); 

		    return top.getElement();
		
	}

	@Override
	public boolean isempty() {
		return (count == 0);
		
	}
	@Override
	public int size() {
		return count;
	}
	public String toString()
	  {
	    String result = "";
	    LinearNode current = top;

	    while (current != null)
	    {
	      result = result + (current.getElement()).toString() + "\n";
	      current = current.getNext();
	    }

	    return result;
	  }
	

}
