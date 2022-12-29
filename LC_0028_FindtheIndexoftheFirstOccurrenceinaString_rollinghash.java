public class LC_0028_FindtheIndexoftheFirstOccurrenceinaString_rollinghash {
    
    public int strStr(String source, String target) {

        int base = 26;
        int mod = 1_000_000_007;
        int n = source.length();
        int L = target.length();

        if (n<L)
            return -1;

        long aL = 1;
        for (int i = 1; i <= target.length()-1; ++i) {
            aL = (aL * base) % mod;
        }

        long hashT = 0;
        for (int i = 0; i < target.length(); ++i) {
            hashT = (hashT * base + ((int)target.charAt(i)-(int)'a')) % mod;
        }

        long hashS = 0;
        for (int i = 0; i < target.length(); ++i) {
            hashS = (hashS * base + ((int)source.charAt(i)-(int)'a')) % mod;
        }

        if (hashS == hashT && target.equals(source.substring(0,target.length()))) {
            return 0;
        }

        for (int i = target.length(); i < n; i++) {

            hashS = (hashS - ((int)source.charAt(i-L)-(int)'a') * aL % mod + mod) % mod;
            hashS = ((hashS * base) % mod  + ((int)source.charAt(i)-(int)'a')) % mod;

            if (hashS == hashT && target.equals(source.substring(i-L+1, i+1))) {
                return i-L+1;
            }
        }

        return -1;
    }
}