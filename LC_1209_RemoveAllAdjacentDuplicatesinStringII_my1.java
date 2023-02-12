import java.util.*;

public class LC_1209_RemoveAllAdjacentDuplicatesinStringII_my1 {
    
    public String removeDuplicates(String s, int k) {
        
        Stack<Pair> stack = new Stack<>();

        Pair p = new Pair();
        p.c = '0';
        p.count = 1;

        stack.push(p);

        for (int i=0; i<s.length(); i++) {

            char c = s.charAt(i);
            Pair curP = stack.peek();
            if (curP.c == c) {
                curP.count++;
                if (curP.count == k) {
                    stack.pop();
                }
            } else {
                Pair newP = new Pair();
                newP.c = c;
                newP.count = 1;
                stack.push(newP);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 1) {
            Pair pair = stack.pop();
            for (int i=0; i<pair.count; i++) {
                sb.append(pair.c);
            }
        }

        return sb.reverse().toString();
    }

    class Pair{
        public char c;
        public int count;
    }
}