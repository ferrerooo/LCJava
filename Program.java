import Google.*;

import java.math.BigInteger;
import java.util.*;

public class Program {
    
    public static void main(String[] args){
        
        LC_0609_FindDuplicateFileinSystem lc = new LC_0609_FindDuplicateFileinSystem();

       //String[] arr = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};

        //System.out.println(lc.findDuplicate(arr));
        
        int P = 113;
        int MOD = 1_000_000_007;
        int Pinv = BigInteger.valueOf(P).modInverse(BigInteger.valueOf(MOD)).intValue();
        System.out.println(Pinv);

        System.out.println((-15)%6);
    }

}
