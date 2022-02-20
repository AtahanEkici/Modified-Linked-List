package Main;
import List.Modified_LinkedList;
import List.Node;

/**
 *
 * @author Atahan Ekici
 */
public class Test 
{
    public static void main(String[] args)
    {
        Modified_LinkedList<Integer> test_int = new Modified_LinkedList(5);
        Modified_LinkedList<String> test_string = new Modified_LinkedList("Hello");
        
        
        test_int.AddNode(10);
        test_int.AddNode(10);
        test_int.AddNode(20);
        test_int.printAll();
        test_int.RemoveAll(10);
        test_int.printAll();
        System.out.println("\nSize: "+test_int.getSize()+"");

        
        test_string.AddNode("Deneme1");
        test_string.AddNode("Deneme2");
        test_string.AddNode("Deneme2");
        test_string.printAll();
        test_string.RemoveAll("Deneme2");
        test_string.printAll();
        System.out.println("\nSize: "+test_string.getSize()+"");
        
        System.out.println();
        
        test_int.printAllReversed();
        test_string.printAllReversed();
        
        test_int.AddNodeFirst(69);
        test_int.printAll();
        
        //System.out.println("\nSize: "+test_int.getSize()+"");
        
        //System.out.println("\nGet Data: "+test_int.getData(3));
        
        System.out.println(test_int);
        
        long start = System.nanoTime();
        test_int.AddNodeFast(55);
        long end = System.nanoTime();
        
        long start1 = System.nanoTime();
        test_int.AddNode(55);
        long end1 = System.nanoTime();
        
        test_int.printAll();
        
        System.out.println("\nIt took "+(end - start)+" for Fast");
        System.out.println("\nIt took "+(end1 - start1)+" for Normal");
        
        System.out.println("Data: "+test_int.getData(4)+"");
        
        test_int.RemoveIndex(3);
        
        test_int.printAll();
        
        Sorter.Sorters.BubbleSort(test_int);
        
        test_int.printAll();
    }
}