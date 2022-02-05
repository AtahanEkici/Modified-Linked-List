package Main;
import List.Modified_LinkedList;

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

        
        test_string.AddNode("Deneme1");
        test_string.AddNode("Deneme2");
        test_string.AddNode("Deneme2");
        test_string.printAll();
        test_string.RemoveAll("Deneme2");
        test_string.printAll();
    }
}
