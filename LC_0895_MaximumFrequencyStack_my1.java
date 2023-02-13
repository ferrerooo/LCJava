import java.util.*;

public class LC_0895_MaximumFrequencyStack_my1 {
    private int maxf = 0;
    private Map<Integer, Integer> valMap;  // val to count
    private Map<Integer, Stack<Integer>> freqMap; // freq to vals
    private int popcount = 0;

    public LC_0895_MaximumFrequencyStack_my1() {
        maxf = 0;
        valMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public void push(int val) {
        valMap.put(val, valMap.getOrDefault(val, 0)+1);
        maxf = Math.max(maxf, valMap.get(val));
        freqMap.putIfAbsent(valMap.get(val), new Stack<Integer>());
        freqMap.get(valMap.get(val)).push(val);
    }
    
    public int pop() {

        popcount++;
        System.out.println("popcount:"+popcount);

        System.out.println("----maxf:"+maxf);
        System.out.println("----freqMap size:"+freqMap.size());
        System.out.println("----max stack size:"+freqMap.get(maxf).size());
        
        int res = freqMap.get(maxf).pop();
        valMap.put(res, valMap.get(res)-1);
        if (valMap.get(res) == 0)
            valMap.remove(res);
        
        if (freqMap.get(maxf).size() == 0) {
            freqMap.remove(maxf);
            maxf--;
        }
        System.out.println("Pop out value : "+res);
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */