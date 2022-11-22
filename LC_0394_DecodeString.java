import java.util.*;

public class LC_0394_DecodeString {
    List<String> list = this.parseString(s);
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for (String str : list) {
            
            if (!str.equals("]")) {
                stack.push(str);
                continue;
            }
            
            StringBuilder sb = new StringBuilder();
            while (!stack.peek().equals("[")) {
                sb.append(stack.pop());
            }
            stack.pop(); // remove "["
            int times = Integer.parseInt(stack.pop());
            String revstr = sb.reverse().toString();
            for (int i = 0; i < times; i++) {
                for (int j = 0; j < revstr.length(); j++) {
                    stack.push(String.valueOf(revstr.charAt(j)));
                }
            }
        }
        
        while (stack.size() != 0) {
            result.append(stack.pop());
        }
        
        return result.reverse().toString();
    }
    
    private List<String> parseString(String s) {
        
        List<String> list = new LinkedList<>();
        int p = 0;
        StringBuilder sb = new StringBuilder();
        
        while (p < s.length()) {
            
            if (s.charAt(p) >= '0' && s.charAt(p) <= '9') {
                sb.append(s.charAt(p));
                p += 1;
                continue;
            }
        
            if (sb.length() != 0) {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
                
            list.add(String.valueOf(s.charAt(p)));
            p += 1;
        }
        
        for (String s1 : list) {
            System.out.print(s1 + " ");
        }
        
        System.out.println();
        
        return list;
    }
}