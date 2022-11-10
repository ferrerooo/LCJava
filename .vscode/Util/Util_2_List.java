import org.junit.Test;
import java.util.*;

public class Util_2_List {

    @Test
    public void test() {

        // ArrayList, LinkedList

        // List is interface (C# List is a class, IList is interface)
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(0, 1);
        l1.size();

        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);

        l1.addAll(1, l2);
        l1.addAll(l2);

        l1.get(0);
        l1.set(0, 5);

        l1.remove(1);
        l1.remove((Object)1); //simply remove an object from the List. If there are multiple such objects, then the first occurrence of the object is removed.
    
        l1.indexOf(1);

        l1.sort((x, y) -> x*3 - y*2);
        
        /*
        size()	This method is used to return the size of the list.
        clear()	This method is used to remove all the elements in the list. However, the reference of the list created is still stored.
        indexOf(element)	This method returns the first occurrence of the given element or -1 if the element is not present in the list.
        lastIndexOf(element)	This method returns the last occurrence of the given element or -1 if the element is not present in the list.
        equals(element)	This method is used to compare the equality of the given element with the elements of the list.
        hashCode()	This method is used to return the hashcode value of the given list.
        isEmpty()	This method is used to check if the list is empty or not. It returns true if the list is empty, else false.
        contains(element)	This method is used to check if the list contains the given element or not. It returns true if the list contains the element.
        containsAll(Collection collection)	This method is used to check if the list contains all the collection of elements.
        sort(Comparator comp)	This method is used to sort the elements of the list on the basis of the given comparator.
        */
    
    }

}
