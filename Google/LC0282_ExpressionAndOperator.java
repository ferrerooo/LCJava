package Google;

import java.util.*;

public class LC0282_ExpressionAndOperator {

    private static String numLocal;
    private static int targetLocal;
    private static List<String> list;
    
    public static List<String> addOperators(String num, int target) {
        
        numLocal = num;
        targetLocal = target;
        list = new ArrayList<String>();
        
        if (num == null)
            return list;
        
        dfs(0, "", 0L, 0L);

        return list;
    }

    private static void dfs(int start, String exp, long value, long pre) {

        if (start == numLocal.length()) {
            if (value == targetLocal)
                list.add(exp);
            return;
        }

        for (int i=start; i<numLocal.length(); i++) {

            String s = numLocal.substring(start, i+1);
            
            if (s.charAt(0) == '0' && i > start)
                break;
            
            var l = Long.parseLong(s);

            if (start == 0) {
                dfs(i+1, s, l, l);
            } else {
                dfs(i+1, exp + "+" + s, value+l, l);
                dfs(i+1, exp + "-" + s, value-l, (-1)*l);
                dfs(i+1, exp + "*" + s, (value-pre)+pre*l, pre*l);
            }

        }

    }
   
    
    public static void main1() {

        var list = LC0282_ExpressionAndOperator.addOperators("123", 6);

        for (var s : list) {
            System.out.println(s);
        }

    }
    
}
