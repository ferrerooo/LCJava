package Apple;
import java.util.*;

class LC_04_0772_0224_BasicCalculator {
    public int calculate(String s) {
        
        LinkedList<String> tokens = this.getTokens(s);
        
        System.out.println(tokens);
        
        LinkedList<String> cal = new LinkedList<>();
        
        for (String t : tokens) {
            
            if (t.equals("+") 
                || t.equals("-") 
                || t.equals("(")) {
                cal.offerLast(t);
            } else if (t.equals(")")) {
                
                LinkedList<String> locallist = new LinkedList<>();
                while (!cal.peekLast().equals("(")) {
                    locallist.offerFirst(cal.pollLast());
                }
                cal.pollLast();
                
                String ret = this.calculateNoParathesis(locallist);
                
                cal.offerLast(ret);
                
            } else {
                cal.offerLast(t);
            }
            
        }
        
        return Integer.parseInt(this.calculateNoParathesis(cal));
    }
    
    private String calculateNoParathesis(LinkedList<String> list) {
        
        if (list.peekFirst().equals("+") 
           || list.peekFirst().equals("-")) {
            list.offerFirst("0");
        }
        
        while (list.size() > 1) {
            
            Integer a = Integer.parseInt(list.pollFirst());
            String op = list.pollFirst();
            Integer b = Integer.parseInt(list.pollFirst());
            if (op.equals("+")) {
                list.offerFirst(String.valueOf(a+b));
            } else if (op.equals("-")) {
                list.offerFirst(String.valueOf(a-b));
            } else {
                System.out.println("not possible to print this.");
            }
        }
        
        return list.get(0);
        
    }
    
    private LinkedList<String> getTokens(String s) {
        
        String trimmedStr = this.trimSpace(s);
        
        LinkedList<String> tokens = new LinkedList<>();
        int start = 0;
        
        for (int i = 0;i<trimmedStr.length(); i++) {
            
            if (trimmedStr.charAt(i) == '+') {
                tokens.add("+");
            } else if (trimmedStr.charAt(i) == '-') {
                tokens.add("-");
            } else if (trimmedStr.charAt(i) == '(') {
                tokens.add("(");
            } else if (trimmedStr.charAt(i) == ')') {
                tokens.add(")");
            } else {
                
                StringBuilder sb = new StringBuilder();
                while (i < trimmedStr.length() 
                       && trimmedStr.charAt(i) != '+' 
                       && trimmedStr.charAt(i) != '-'
                       && trimmedStr.charAt(i) != '('
                       && trimmedStr.charAt(i) != ')') {
                    sb.append(trimmedStr.charAt(i));
                    i++;
                }
                i--;
                tokens.add(sb.toString());
            }
        }
        
        return tokens;
    }
    
    private String trimSpace(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}