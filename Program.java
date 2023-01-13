import Google.*;

import java.math.BigInteger;
import java.util.*;

public class Program {
    
    public static void main(String[] args){
        
        LC_0518_CoinChangeII_DFS_TLE lc = new LC_0518_CoinChangeII_DFS_TLE();

        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);
        
        System.out.println(bits1);

        bits1.set(1);

        System.out.println(bits1);

        // set some bits
        for(int i=0; i<16; i++) {
           if((i%2) == 0) bits1.set(i);
           if((i%5) != 0) bits2.set(i);
        }

        //System.out.println("Initial pattern in bits1: ");
        //System.out.println(bits1);
        //System.out.println("\nInitial pattern in bits2: ");
        //System.out.println(bits2);
     }

}
