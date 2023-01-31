import java.util.*;

public class LC_0301_RemoveInvalidParentheses {
    
    Set<String> visited = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {

        List<String> res = new ArrayList<>();
        int[] invalid = getInvalidCnt(s);
        //System.out.println(invalid[0]);
        //System.out.println(invalid[1]);
        dfs(s, 0, invalid[0], invalid[1], "", res);

        return res;
    }

    private void dfs(String s, int index, int left, int right, String cur, List<String> res) {

        if (left == 0 && right == 0) {
            if (index < s.length()) {
                if (isValid(cur+s.substring(index))) {
                    if (!visited.contains(cur+s.substring(index))) {
                        res.add(cur + s.substring(index));
                        visited.add(cur + s.substring(index));
                    }
                }
            } else {
                if (isValid(cur)) {
                    if (!visited.contains(cur)) {
                        res.add(cur);
                        visited.add(cur);
                    }
                }
            }
            return;
        }

        if (index == s.length()) {
            return ;
        }

        char c = s.charAt(index);

        if (c >= 'a' && c<='z') {
            dfs(s, index+1, left, right, cur+String.valueOf(c), res);
        } else if (c == '(') {
            //if (index > 0 && s.charAt(index-1) == '(') 
            //    return;
            dfs(s, index+1, left, right, cur+"(", res);
            if (left > 0) {
                dfs(s, index+1, left-1, right, cur, res);
            }
        } else if (c == ')') {
            //if (index > 0 && s.charAt(index-1) == ')') 
            //    return;
            dfs(s, index+1, left, right, cur+")", res);
            if (right > 0) {
                dfs(s, index+1, left, right-1, cur, res);
            }
        }

        return;
    }

    private int[] getInvalidCnt (String s) {

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.size() == 0 || stack.peek() == ')') {
                    stack.push(c);
                } else if (stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                continue;
            }
        }

        int[] res = new int[2];
        while (stack.size() > 0) {
            char c = stack.pop();
            if (c == '(') {
                res[0]++;
            } else {
                res[1]++;
            }
        }

        return res;

    }

    private boolean isValid (String s) {
        int[] res = getInvalidCnt(s);
        if (res[0] == 0 && res[1] == 0)
            return true;
        else
            return false;
    }
}