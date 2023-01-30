import Google.*;

import java.math.BigInteger;
import java.util.*;

public class Program {
    
    public static void main(String[] args){
        
        LC_0518_CoinChangeII_DFS_TLE lc = new LC_0518_CoinChangeII_DFS_TLE();
        String str = "a.b.c...";
        String[] arr = str.split("\\.");
        System.out.println(arr.length);

        for (String s:arr)
            System.out.println("--"+s);
     }

}
