import java.util.*;

public class LC_0394_DecodeString {

    public String decodeString(String s) {
        
        List<String> list = parse(s);

        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<>();

        for (String str:list) {

            if (!str.equals("]")) {
                stack.push(str);
                continue;
            }

            StringBuilder local = new StringBuilder();

            while (!stack.peek().equals("[")) {
                local.append(stack.pop());
            }
            local = local.reverse();
            stack.pop();
            int loop = Integer.valueOf(stack.pop());

            for (int i=0; i<loop; i++) {
                for (int j=0; j<local.length(); j++) {
                    stack.push(String.valueOf(local.charAt(j)));
                }
            }
        }

        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();

    }

    private List<String> parse(String s) {

        List<String> list = new ArrayList<>();

        int p1 = 0;

        while (p1 < s.length()) {

            char c = s.charAt(p1);

            if ( c > '9' || c < '0') {
                list.add(String.valueOf(c));
                p1++;
            } else {
                int p2 = p1;
                while (p2 < s.length() && (s.charAt(p2)>='0' && s.charAt(p2)<='9'))
                    p2++;
                list.add(s.substring(p1, p2));
                p1 = p2;
            }
        }

        return list;
    }
}