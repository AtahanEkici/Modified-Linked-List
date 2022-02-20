package Sorter;

import List.Modified_LinkedList;
import List.Node;

/**
 *
 * @author Atahan Ekici
 */
public class Sorters
{
    public static void BubbleSort(Modified_LinkedList mll)
    {
        if(mll.getSize() <= 1)
        {
            System.out.println("List is too small for sorting");
            return;
        }
        
        Node next = mll.getRoot();
        Node iter = mll.getRoot();
        int counter = 1;
        
        while(counter < mll.getSize() && iter.getNext() != null)
        {
            next = iter.getNext();
            
            System.out.println("\nFirst "+iter.getData()+" Second: "+next.getData()+"");
            
            if(iter.getNext() == null)
            {
                iter = mll.getRoot(); 
                
                for(int i=0;i<counter;i++) 
                {
                    iter = iter.getNext();
                }    
                counter++;
            }
            else if((int)iter.getData() > (int)next.getData())
            {
                Node.swap(iter,next);
                iter = iter.getNext();
            }
            else
            {
                iter = iter.getNext();
            } 
        }
    }
}
