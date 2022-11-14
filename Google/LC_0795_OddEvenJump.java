package Google;

import java.util.*;
import javafx.util.Pair;

public class LC_0795_OddEvenJump {


    public int oddEvenJumps(int[] arr) {
        
        boolean[] odd = new boolean[arr.length];
        boolean[] even = new boolean[arr.length];
        int n = arr.length;
        TreeMap<Integer, Integer> map = new TreeMap();
        map.put(arr[n-1], n-1);
        odd[n-1] = true;
        even[n-1] = true;
        
        for (int i = n-2; i>=0; i--) {

            Map.Entry<Integer, Integer> oddEntry = map.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> evenEntry = map.floorEntry(arr[i]);

            if (oddEntry != null) {
                odd[i] = even[(Integer)oddEntry.getValue()];
            }

            if (evenEntry != null) {
                even[i] = odd[(Integer)evenEntry.getValue()];
            }

            map.put(arr[i], i);
        }

        int result = 0;
        for (var b : odd) 
            result = result + (b?1:0);
        
        return result;
    }





}