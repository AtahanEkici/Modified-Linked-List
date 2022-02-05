package List;
/**
 *
 * @author Atahan Ekici
 * @param <T>
 */
public class Modified_LinkedList <T>
{
    private T data;
    
    private int size = 0;
    
    private Modified_LinkedList prev;
    private Modified_LinkedList next;
    
    public Modified_LinkedList()
    {
        this.data = null;
        this.prev = null;
        this.next = null;
    }
    
    public Modified_LinkedList(T dat)
    {
        this.data = dat;
        this.prev = null;
        this.next = null;  
        size++;
    }
    
    public void AddNode(T dat)
    {
        Modified_LinkedList iter = this;
        
        boolean complete = false;
        
        if(size <= 0)
        {
            this.data = dat;
            size++;
            return;
        }
        
        while(complete == false)
        { 
            if(iter.getNext() == null)
            {
                iter.next = new Modified_LinkedList(dat);
                iter.next.prev = iter;
                complete = true;
            }
            else
            {
                iter = iter.next; // Iterate //
            } 
        }
    }
    
    public T get(int i)
    {
        if(i > this.getSize())
        {
            return null;
        }
        
        Modified_LinkedList iter = this;
        int counter = 0;
        
         while(iter != null)
        {
            if(counter == i)
            {
                return (T)iter;
            }
            
            System.out.print(iter.getData()+" -> ");
            iter = iter.next;
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
        Modified_LinkedList iter = this;
        
        System.out.print("\n ----------- Printing ALL ----------- \n");
        
        while(iter != null)
        {
            System.out.print(iter.getData()+" -> ");
            iter = iter.next;
        }
        
        System.out.print("end");
    }
    
    public void RemoveAll(T dat)
    {
        Modified_LinkedList iter = this;

        while(iter != null)
        {
            //System.out.println("\n"+dat.toString() + " " + iter.getData().toString()+ ": "); System.out.print(dat == iter.getData());
            
            if(dat == iter.getData())
            {
                //iter.data = null;
                iter.prev.next = iter.next;
                
                if(iter.next != null)
                {
                    iter.next.prev = iter.prev;
                }  
            }
            iter = iter.next;
        }
    }
    
    public T getData()
    {
        return this.data;
    }
    public void setData(T dat)
    {
        this.data = dat;
    }
    
    public Modified_LinkedList getPrev()
    {
        return this.prev;
    }
    public void setPrev(Modified_LinkedList mll)
    {
        this.prev = mll;
    }
    
    public Modified_LinkedList getNext()
    {
        return this.next;
    }
    public void setNext(Modified_LinkedList mll)
    {
        this.next = mll;
    }
}
