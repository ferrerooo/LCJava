import Google.*;

import java.math.BigInteger;
import java.util.*;

public class Program {
    
    public static void main(String[] args){
        
        LC_0698_PartitiontoKEqualSumSubsets lc = new LC_0698_PartitiontoKEqualSumSubsets();

       //String[] arr = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};

        //System.out.println(lc.findDuplicate(arr));
        
        int[] nums = new int[]{18,20,39,73,96,99,101,111,114,190,207,295,471,649,700,1037};
        int k = 4;

        System.out.println(lc.canPartitionKSubsets(nums, k));
    }

}
