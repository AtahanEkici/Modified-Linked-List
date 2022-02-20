package List;
/**
 *
 * @author Atahan Ekici
 * @param <T>
 */
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
    
    public Node getRoot()
    {
        return this.root;
    }
    public Node getHead()
    {
        return this.head;
    }
    
    public void AddNodeFirst(T dat)
    {
        Node temp = new Node<>(dat);
        
        if(root == null)
        {
            root = temp;
            return;
        }
        
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
        size++;
    }
    
    public void AddNode(T dat)
    {
        Node temp,iter = root;
        
        if(root == null)
        {
            root = iter;
            return;
        }
        
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
        
        if(root == null)
        {
            root = temp;
            return;
        }
        
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
        size++;
    }
    
    public T getData(int i)
    {
        if(i > this.getSize() -1)
        {
            System.out.println("Given index exceeds size");
            return null;
        }
        
        Node iter = root;
        int counter = 0;
        
        while(iter != null)
        {
            if(counter == i)
            {
                return (T)iter.getData();
            }
            iter = iter.getNext();
            counter++;
        }
        System.out.println("Error");
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
    
    public void RemoveIndex(int index)
    {
        if(this.getSize() < index || index < 0)
        {
            System.out.println("index exceeding list size");
            return;
        }
        
        Node iter = root;
        int counter = 0;
        
        while(iter != null)
        {
            if(counter != index)
            {
                iter = iter.getNext();
                counter++;
            }
            else
            {
                Node prev = iter.getPrev();
                Node next = iter.getNext();
                
                if(next != null)
                {
                    prev.setNext(next);
                    next.setPrev(prev);
                }
                iter.finalize();
                return;
            }
        }
    }
    
    public void RemoveAll(T dat)
    {
        Node iter = root;

        while(iter != null)
        {
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
    
    @Override
    public String toString() 
    {
        String total = "\n";
        String head = "Head: " + String.valueOf(this.head.getData()+ "\n");
        String root = "Root: " +String.valueOf(this.root.getData()+ "\n");
        String size = "Size: " +String.valueOf(this.getSize()) + "\n";
        
        total += head + root + size;
        return total;
    }
}
