import Google.*;
import java.util.*;

public class Program {
    
    public static void main(String[] args){
        
        LC_0609_FindDuplicateFileinSystem lc = new LC_0609_FindDuplicateFileinSystem();

       //String[] arr = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};

        //System.out.println(lc.findDuplicate(arr));
        
        char c  = 'a';
        char c2 = 'a' + 'A'-'A';

        System.out.println(c);
        System.out.println(c2);

        int a = 999999991;
        int b = Integer.MAX_VALUE;
        if (a > b)
            System.out.println("a win");
        else   
            System.out.println("b win");
    }

}
