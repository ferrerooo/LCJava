import java.util.*;

public class LC_0718_MaximumLengthofRepeatedSubarray_rollinghash {private List<Long> rolling(int[] source, int len) {

    List<Long> list = new ArrayList<>();

    int base = 10;
    int mod = 1_000_000_007;

    long baseMax = 1;
    for (int i = 1; i <= len-1; ++i) {
        baseMax = (baseMax * base) % mod;
    }

    long hash = 0;
    for (int i = 0; i < len; ++i) {
        hash = (hash * base + source[i]) % mod;
    }
    list.add(hash);

    for (int i = len; i < source.length; i++) {

        hash = (hash - source[i - len] * baseMax % mod + mod) % mod;
        hash = ((hash * base) % mod  + source[i]) % mod;
        list.add(hash);
    }

    return list;
}

private boolean check(int guess, int[] A, int[] B) {

    Map<Long, List<Integer>> hashes = new HashMap();
    int k = 0;
    for (long x: rolling(A, guess)) {
        hashes.putIfAbsent(x, new ArrayList());
        hashes.get(x).add(k);
        k++;
    }
    int j = 0;
    for (long x: rolling(B, guess)) {
        for (int i: hashes.getOrDefault(x, new ArrayList<Integer>()))
            if (Arrays.equals(Arrays.copyOfRange(A, i, i+guess),
                              Arrays.copyOfRange(B, j, j+guess))) {
                return true;
            }
        j++;
    }
    return false;
}

public int findLength(int[] A, int[] B) {
    int lo = 1;
    int hi = Math.min(A.length, B.length);
    int res = 0;
    while (lo <= hi) {
        int mi = (lo + hi) / 2;
        if (check(mi, A, B)) {
            lo = mi + 1;
            res = Math.max(res, mi);
        } else {
            hi = mi-1;
        }
    }

    return res;
}
}