//John Rosar
//COSC 2436
//Assignment 2

public class JohnRosarLinkedList<E> 
implements JohnRosarList.MyList<E> 
{
  private Node<E> head, tail;
  private int size = 0; // Number of elements in the list
  public JohnRosarLinkedList() 
  {
  }
  public JohnRosarLinkedList(E[] objects) 
  {
      for (int i = 0; i < objects.length; i++) 
      {
        add(objects[i]);
      }
  }

  public E getFirst() 
  {
      if (size == 0) 
      {
          return null;
      }
      else
      {
          return head.element;
      }
  }
  
  public E getLast() 
  {
      if (size == 0) 
      {
          return null;
          
      } 
      else 
      {
          return tail.element;
      }
  }
  public void addFirst(E e) 
  { 
      Node<E> newNode = new Node<>(e); // Create a new node 
      newNode.next = head; // link the new node with the head
      head = newNode; // head points to the new node
      size++; // Increase list size
      if (tail == null) // the new node is the only node in list
      {
          tail = head;
      }
  }
public void addLast(E e) 
{
    Node<E> newNode = new Node<>(e);
    if(tail==null)
    {
        head = tail=newNode;
    }
    else
    {
        tail.next=newNode;
        tail=newNode;
    }
    size++;
}
@Override
public void add(int index,E e)
{
    if(index==0)
    {
        addFirst(e);
    }
    else if(index>=size)
    {
        addLast(e);
    }
    else
    {
        Node<E>current=head;
        for(int i=1;i<index;i++)
        {
            current=current.next;
        }
        Node<E>temp=current.next;
        current.next=new Node<>(e);
        (current.next).next=temp;
        size++;
    }
}
public E removeFirst()
{
    if(size==0)
    {
        return null;
    }
    else
    {
        E temp = head.element;
        head=head.next;
        size--;
        if (head==null)
        {
          tail=null;  
        }
        return temp;
    }
}
public E removeLast()
{
    if(size==0)
    {
        return null;
    }
    else if(size==1)
    {
        E temp=head.element;
        head=tail=null;
        size=0;
        return temp;
    }
    else
    {
        Node<E>current= head;
        for(int i=0; i<size-2;i++)
        {
            current=current.next;
        }
        E temp = tail.element;
        tail=current;
        tail.next=null;
        size--;
        return temp;
    }
}

@Override
public E remove(int index) 
{
    if (index < 0 || index >= size) 
    {
        return null;
        
    } 
    else if (index == 0) 
    {
        return removeFirst();
        
    } 
    else if (index == size - 1) 
    {
        return removeLast();
        
    } 
    else 
    { 
        Node<E>previous=head;
        for (int i = 1; i < index;i++)
        {
            previous = previous.next;
        }
        Node<E> current = previous.next;
        previous.next=current.next;
        size--;
        return current.element;
    }
}

@Override
public String toString() 
{
    StringBuilder result = new StringBuilder("[");
    Node<E> current=head;
    for (int i=0; i < size; i++) 
    {
        result.append(current.element); 
        current = current.next;
        if (current != null) 
        { 
            result.append(",");
        }
        else 
        { 
            result.append("]"); 
        }
    }
    return result.toString();
}

@Override
public void clear()
{
    size = 0;
    head=tail=null;
}

@Override
public boolean contains(Object e)
{
    for (Node<E> n = head; n != null; n = n.next) 
    {
        if (n.element.equals(e)) 
        {
            return true;
        } 
    }
    return true;
}

@Override
public E get(int index) 
{ 
    if (index < 0 || index >= size) 
    {
        return null;
    }
    Node<E> n = head;
    for(int i=0;i<index;i++)
    {
        n=n.next;
    }
    return n.element;
}

@Override
public int indexOf(Object e)
{
    int index=0;
    for(Node<E>n=head; n!=null; n=n.next)
    {
        if(n.element.equals(e))
        {
            return index;
        }
        index++;
    }
    return -1;
}

@Override
public int lastIndexOf(E e)
{
    for(int i=size-1; i>=0; i--)
    {
        if(get(i).equals(e))
        {
            return i;
        }
    }
    return -1;
}

@Override
public E set(int index, E e)
{
    if(index<0 || index>=size)
    {
        return null;
    }
    Node<E>n=head;
    for(int i=0; i<index; i++)
    {
        n=n.next;
    }
    E old = n.element;
    n.element=e;
    return old;
}

@Override
public java.util.Iterator<E> iterator()
{
    return new LinkedListIterator();
}
private class LinkedListIterator
implements java.util.Iterator<E>
{
    private Node<E>current=head;
    private int prev_index= -1;
    private boolean safeToRemove=false;

@Override
public boolean hasNext()
{
    return(current != null);
}

@Override
public E next()
{
    E e=current.element;
    current=current.next;
    prev_index++;
    safeToRemove=true;
    return e;
}

@Override
public void remove()
{
    if(!safeToRemove)
    {
        throw new IllegalStateException();
    }
    JohnRosarLinkedList.this.remove(prev_index);
    prev_index--;
    safeToRemove=false;
}
}
private static class Node<E>
{
    E element;
    Node<E>next;
    public Node(E element)
    {
        this.element=element;
    }
}

@Override
public int size()
{
    return size;
}
}


