import Google.*;

import java.math.BigInteger;
import java.util.*;

public class Program {
    
    public static void main(String[] args){
        
        LC_0518_CoinChangeII_DFS_TLE lc = new LC_0518_CoinChangeII_DFS_TLE();

        BitSet bs = new BitSet(3);

        bs.set(3);
        bs.set(1);
        bs.set(2);
        bs.set(0);

        System.out.println(bs.nextClearBit(0));
     }

}
