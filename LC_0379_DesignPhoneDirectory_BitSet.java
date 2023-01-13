import java.util.BitSet;

public class LC_0379_DesignPhoneDirectory_BitSet {
    
    BitSet bitset;
    int max; // max limit allowed

    public LC_0379_DesignPhoneDirectory_BitSet(int maxNumbers) {
        this.bitset = new BitSet(maxNumbers);
        this.max = maxNumbers;
    }

    public int get() {
        int n = bitset.nextClearBit(0);
        if (n == max)
            return -1;
        bitset.set(n);
        return n;
    }

    public boolean check(int number) {
        return !bitset.get(number);
    }

    public void release(int number) {
        bitset.clear(number);
    }
}