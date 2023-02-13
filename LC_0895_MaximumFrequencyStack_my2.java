import java.util.*;

public class LC_0895_MaximumFrequencyStack_my2 {
    private Map<Integer, Integer> countMap; 
    private Map<Integer, Stack<Integer>> freqMap;
    private int maxFreq;

    public LC_0895_MaximumFrequencyStack_my2() {
        maxFreq = 0;
        countMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public void push(int val) {
        
        countMap.put(val, countMap.getOrDefault(val, 0)+1);
        int freq = countMap.get(val);
        maxFreq = Math.max(maxFreq, freq);

        if (!freqMap.containsKey(freq)) {
            freqMap.put(freq, new Stack<>());
        }
        freqMap.get(freq).push(val);
    }
    
    public int pop() {
        int res = freqMap.get(maxFreq).pop();
        if (freqMap.get(maxFreq).size() == 0) {
            freqMap.remove(maxFreq);
            maxFreq--;
        }

        countMap.put(res, countMap.get(res)-1);
        if (countMap.get(res) == 0) 
            countMap.remove(res);

        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */