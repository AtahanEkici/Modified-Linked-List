package List;
/**
 *
 * @author Atahan Ekici
 * @param <T>
 */

class Node <T>
{
    private Node prev;
    private Node next;
    
    private T data;
    
    public Node()
    {
        this.data = null;
        this.prev = null;
        this.next = null;
    }
    
    public Node(T dat)
    {
        this.data = dat;
        this.prev = null;
        this.next = null;  
    }
    
    public T getData()
    {
        return this.data;
    }
    public void setData(T dat)
    {
        this.data = dat;
    }
    
    public Node getPrev()
    {
        return this.prev;
    }
    public void setPrev(Node mll)
    {
        this.prev = mll;
    }
    
    public Node getNext()
    {
        return this.next;
    }
    public void setNext(Node mll)
    {
        this.next = mll;
    }
}

public class Modified_LinkedList <T>
{
    private Node <T> root;
    private Node <T> head;
    private int size;
    
    public Modified_LinkedList()
    {
        root = new Node();
        size = 1;
    }
    
    public Modified_LinkedList(T data)
    {
        root = new Node<>(data);
        size = 1;
    }
    
    public void AddNodeFirst(T dat)
    {
        Node temp = new Node<>(dat);
        
        if(size <= 1)
        {
            root.setNext(temp);
            temp.setPrev(root);
        }
        else
        {
            Node next = root.getNext();

            root.setNext(temp);
            temp.setNext(next);

            next.setPrev(temp);
            temp.setPrev(root);
        }
    }
    
    public void AddNode(T dat)
    {
        Node temp,iter = root;
        
        boolean complete = false;
        
        while(complete == false)
        { 
            if(iter.getNext() == null)
            {
                temp = new Node(dat);
                iter.setNext(temp);
                iter.getNext().setPrev(iter);
                complete = true;
                size++;
                head = temp;
            }
            else
            {
                iter = iter.getNext(); // Iterate //
            } 
        }
    }
    
    public void AddNodeFast(T dat)
    {
        Node temp = new Node<>(dat);       
        
        if(head == null)
        {
            root.setNext(temp);
            temp.setPrev(root);
            head = temp;
        }
        else
        {
            head.setNext(temp);
            temp.setPrev(head);
            head = temp;
        }
    }
    
    public T get(int i)
    {
        if(i > this.getSize())
        {
            return null;
        }
        
        Node iter = root;
        int counter = 0;
        
        while(iter != null)
        {
            if(counter == i)
            {
                return (T)iter;
            }
            
            System.out.print(iter.getData()+" -> ");
            iter = iter.getNext();
            counter++;
        }
        
        return null;
    }
    
    public int getSize()
    {
        return this.size;
    }
    
    public void printAll()
    {
        Node iter = root;
        
        System.out.print("\n ----------- Printing ALL ----------- \n");
        
        while(iter != null)
        {
            System.out.print(iter.getData()+" -> ");
            iter = iter.getNext();
        }
        System.out.print("end");
    }
    
    public void printAllReversed()
    {
        Node iter = head;
        
        System.out.print("\n ----------- Printing ALL ----------- \n");
        
        while (iter != null)
        {
            System.out.print(iter.getData()+" <- ");
            iter = iter.getPrev();
        }
        System.out.print("end");
    }
    
    public void RemoveAll(T dat)
    {
        Node iter = root;

        while(iter != null)
        {
            //System.out.println("\n"+dat.toString() + " " + iter.getData().toString()+ ": "); System.out.print(dat == iter.getData());
            
            if(dat == iter.getData())
            {
                if(iter != root)
                {
                    iter.getPrev().setNext(iter.getNext());
                }
                if(iter != head)
                {
                    iter.getNext().setPrev(iter.getPrev());
                } 
                
                if(iter == head)
                {
                    head = iter.getPrev();
                }
                
                if(iter == root)
                {
                    root = root.getNext();
                }
                
                iter.setData(null);
                size--;
            }
            iter = iter.getNext();
        }
    }
}