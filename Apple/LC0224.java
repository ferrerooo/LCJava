package Apple;
import java.util.*;

public class LC0224 {
    

    public int calculate(String s) {
        
        LinkedList<String> tokens = this.getTokens(s);
        
        return 0;
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
        
        for (String temp : tokens) {
            System.out.println(temp);
        }
        
        System.out.println("tokens length is " + tokens.size());
        
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
