import java.util.*;

public class LC_0823_BinaryTreesWithFactors {

    public int numFactoredBinaryTrees(int[] arr) {
        
        Arrays.sort(arr);
        
        // key: arr numbers; value: if corresponding key is the tree root, how many trees are there.
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : arr) {
            map.put(i, 1);
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                
                if (map.containsKey(arr[i] * arr[j])) {
                    
                    int trees = map.get(arr[i]) * map.get(arr[j]);
                    if (i != j) {
                        trees = trees * 2;
                    }
                    
                    map.put(arr[i] * arr[j], map.get(arr[i] * arr[j]) + trees);
                }
                
            }
        }
        
        int result = 0;
        int mod = 1_000_000_007;
        
        for (int i : map.values()) {
            result = (result + i) % mod;
        }
        
        return result;
    }

}
