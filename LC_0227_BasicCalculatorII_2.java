class Solution {
    public int calculate(String s) {

        LinkedList<String> originalStrList = transfer(s);

        LinkedList<String> llist = new LinkedList<>();

        while (originalStrList.size() > 0) {

            String str = originalStrList.poll();

            if (str.equals("+")) {
                llist.offer(str);
            } else if (str.equals("-")) {
                llist.offer(str);
            } else if (str.equals("*")) {
                String str2 = originalStrList.poll();
                String newStr = String.valueOf(Integer.parseInt(llist.pollLast()) * Integer.parseInt(str2));
                llist.offer(newStr);
            } else if (str.equals("/")) {
                String str2 = originalStrList.poll();
                String newStr = String.valueOf(Integer.parseInt(llist.pollLast()) / Integer.parseInt(str2));
                llist.offer(newStr);
            } else {
                llist.offer(str);
            }

        }

        while(llist.size() > 1) {
            String s1 = llist.poll();
            String op = llist.poll();
            String s2 = llist.poll();

            if (op.equals("+")) {
                int res = Integer.parseInt(s1) + Integer.parseInt(s2);
                llist.offerFirst(String.valueOf(res));
            } else {
                int res = Integer.parseInt(s1) - Integer.parseInt(s2);
                llist.offerFirst(String.valueOf(res));
            }
        }

        return Integer.parseInt(llist.peek());
    }

    private LinkedList<String> transfer(String s) {

        /*String s= "";
        for (char c:str.toCharArray()) {
            if (c != ' ') {
                s = s + c;
            }
        }*/

        int p1 = 0;
        int p2 = 0;

        LinkedList<String> llist = new LinkedList<>();

        while (p1 < s.length()) {

            String substr = s.substring(p1, p2);

            if (p2<s.length() && s.charAt(p2) == ' ') {
                if (substr.length() > 0) {
                    llist.offer(substr);
                }
                p1 = p2+1;
                p2 = p1;
            } else if (p2<s.length() && s.charAt(p2) == '+') {
                if (substr.length() > 0) {
                    llist.offer(substr);
                }
                llist.offer("+");
                p1 = p2+1;
                p2 = p1;
            } else if (p2<s.length() && s.charAt(p2) == '-') {
                if (substr.length() > 0) {
                    llist.offer(substr);
                }
                llist.offer("-");
                p1 = p2+1;
                p2 = p1;
            } else if (p2<s.length() && s.charAt(p2) == '*') {
                if (substr.length() > 0) {
                    llist.offer(substr);
                }
                llist.offer("*");
                p1 = p2+1;
                p2 = p1;
            } else if (p2<s.length() && s.charAt(p2) == '/') {
                if (substr.length() > 0) {
                    llist.offer(substr);
                }
                llist.offer("/");
                p1 = p2+1;
                p2 = p1;
            } else if (p2 == s.length()) {
                llist.offer(substr);
                break;
            } else {
                p2++;
            }
        }

        return llist;
    }
}
