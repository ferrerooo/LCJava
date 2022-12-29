import java.util.*;

public class LC_1044_LongestDuplicateSubstring {

        public int search(int L, String s) {
            
            int base = 26;
            int mod = 1_000_000_007;
            int n = s.length();
    
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = (int)s.charAt(i) - (int)'a';
            }
    
            long aL = 1;
            for (int i = 1; i <= L-1; ++i) {
                aL = (aL * base) % mod;
            }
    
            long hash = 0;
            for (int i = 0; i < L; ++i) {
                hash = (hash * base + nums[i]) % mod;
            }
            
            HashMap<Long, List<Integer>> seen = new HashMap<Long, List<Integer>>();       
            seen.putIfAbsent(hash, new ArrayList<Integer>());
            seen.get(hash).add(0);
            
            for (int i = L; i < n; i++) {
    
                hash = (hash - nums[i - L] * aL % mod + mod) % mod;
                hash = ((hash * base) % mod  + nums[i]) % mod;
                List<Integer> hits = seen.get(hash);
                if (hits != null) {
                    String cur = s.substring(i-L+1, i+1);
                    for (Integer j : hits) {
                        String candidate = s.substring(j, j + L);
                        if (candidate.equals(cur)) {
                            return j;
                        }
                    }
                }
                seen.putIfAbsent(hash, new ArrayList<Integer>());
                seen.get(hash).add(i-L+1);
            }
            return -1;
        }
        
        public String longestDupSubstring(String s) {
            
            int left = 1;
            int right = s.length()-1;
            int reslen = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (search(mid, s) != -1) {
                    left = mid + 1;
                    reslen = Math.max(reslen, mid);
                } else {
                    right = mid - 1;
                }
            }
            
            if (reslen == 0)
                return "";
    
            int start = search(reslen, s);
            return s.substring(start, start + reslen);
        }
    }