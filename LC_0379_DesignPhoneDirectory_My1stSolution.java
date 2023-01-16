import java.util.*;

public class LC_0379_DesignPhoneDirectory_My1stSolution {
    Set<Integer> set;

    public LC_0379_DesignPhoneDirectory_My1stSolution(int maxNumbers) {
        this.set = new HashSet<>();
        for (int i=0; i<maxNumbers; i++) {
            set.add(i);
        }
    }
    
    public int get() {

        if (set.size() == 0)
            return -1;

        int res = 0;
        for (int i:set) {
            res = i;
            break;
        }

        set.remove(res);
        return res;
    }
    
    public boolean check(int number) {
        return set.contains(number);
    }
    
    public void release(int number) {
        set.add(number);
    }
}