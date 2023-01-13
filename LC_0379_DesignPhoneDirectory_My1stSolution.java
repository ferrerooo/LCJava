import java.util.*;

public class LC_0379_DesignPhoneDirectory_My1stSolution {
    private Set<Integer> avail;
    private Set<Integer> used;

    public LC_0379_DesignPhoneDirectory_My1stSolution(int maxNumbers) {
        
        avail = new HashSet<>();
        used = new HashSet<>();
        
        for (int i = 0; i< maxNumbers; i++) 
            avail.add(i);
    }
    
    public int get() {
        
        int number = -1;
        
        if (avail.size() == 0)
            return number;
        
        for (Integer i : this.avail) {
            number = i;
            break;
        }
        
        avail.remove(number);
        used.add(number);
        return number;
    }
    
    public boolean check(int number) {
        return avail.contains(number);
    }
    
    public void release(int number) {
        used.remove(number);
        avail.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */