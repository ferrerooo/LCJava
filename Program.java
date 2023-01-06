import Google.*;

import java.math.BigInteger;
import java.util.*;

public class Program {
    
    public static void main(String[] args){
        
        LC_0518_CoinChangeII_DFS_TLE lc = new LC_0518_CoinChangeII_DFS_TLE();

       //String[] arr = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};

        //System.out.println(lc.findDuplicate(arr));
        
        int[] coins = new int[]{3,5,7,8,9,10,11};
        int k = 500;

        System.out.println(lc.change(k, coins));
    }

}
