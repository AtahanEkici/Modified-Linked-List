package List;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atahan Ekici
 * @param <T>
 */

public class Node <T>
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
    
    @Override
    protected void finalize()
    {
        try 
        {
            System.out.println(this.data+" removed");
            this.data = null;
            this.next = null;
            this.prev = null;
            super.finalize();
        } 
        catch (Throwable ex) 
        {
            Logger.getLogger(Node.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public static void swap(Node first, Node second)
    {
        Object pointer1 = first.getData();
        Object pointer2 = second.getData();
        
        first.setData(pointer2);
        second.setData(pointer1);
    }
    
    @Override
    public String toString() 
    {
        String total = "";
        String _data = "Data: " + String.valueOf(this.data);
        String _prev = "Prev: " +String.valueOf(this.prev);
        String _next = "Next: " +String.valueOf(this.next);
        
        total = _data + _prev + _next;
        return total;
    }
}
