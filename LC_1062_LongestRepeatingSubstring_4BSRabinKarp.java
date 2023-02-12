import java.util.*;

public class LC_1062_LongestRepeatingSubstring_4BSRabinKarp {
    
  public int longestRepeatingSubstring(String S) {
    
    int n = S.length();
    
    // convert string to array of integers to implement constant time slice
    int[] nums = new int[n];
    
    for(int i = 0; i < n; ++i) 
      nums[i] = (int)S.charAt(i) - (int)'a';

    // binary search, L = repeating string length
    int p1 = 1;
    int p2 = n;
    int result = 0;

    while (p1 <= p2) {
      int mid = p1 + (p2 - p1) / 2;
      if (search(mid, n, nums, S) != -1) {
        p1 = mid + 1;
        result = mid; // no need to use Math.max
      } else 
        p2 = mid - 1;
    }

    return result;
  }

  private int search(int len, int n, int[] nums, String s) {
    
    // base value for the rolling hash function
    int base = 5; // 26
    
    // modulus value for the rolling hash function to avoid overflow
    long modulus = (long)Math.pow(2, 5);  // 2,24

    // compute the hash of string S[:L]
    long hash = 0;
    
    for(int i = 0; i < len; ++i) 
      hash = (hash * base + nums[i]) % modulus;

    // already seen hashes of strings of length L
    //HashSet<Long> seen = new HashSet<>();
    //seen.add(h);
    HashMap<Long, List<Integer>> seen = new HashMap<>();
    seen.put(hash, new ArrayList<>());
    seen.get(hash).add(0);

    // const value to be used often : a**L % modulus
    long maxHashBase = 1;
    for (int i = 1; i <= len; ++i) 
      maxHashBase = (maxHashBase * base) % modulus;

    for(int start = 1; start < n - len + 1; ++start) {

      // compute rolling hash in O(1) time
      hash = (hash*base - nums[start-1]*maxHashBase % modulus + modulus) % modulus;
      hash = (hash+nums[start+len-1]) % modulus;
      
      if (seen.containsKey(hash)) {
        
        // if get the same hash, do char by char compare due to the possibility of collision
        List<Integer> list = seen.get(hash);

        for (int preStart : list) {
          if (isSame(nums, preStart, start, len)) {
            return start;
          }
        }

        seen.get(hash).add(start);

      } else {
        seen.put(hash, new ArrayList<>());
        seen.get(hash).add(start);
      }
      
    }
    return -1;
  }

  private boolean isSame(int[] nums, int p1, int p2, int len) {
    for (int i=0;i<len; i++) {
      if (nums[p1+i] != nums[p2+i]) {
        return false;
      }
    }

    return true;
  }
}