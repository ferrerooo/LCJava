class Solution {
    public int calculate(String s) {

        // test len=1

        List<String> list = this.parse(s);

        Deque<String> dq = new LinkedList<>();

        for(int i=0; i<list.size(); i++) {

            if (list.get(i).equals("*")) {
                int a = Integer.parseInt(dq.pollLast());
                i++;
                int b = Integer.parseInt(list.get(i));
                dq.offerLast(String.valueOf(a*b));
            } else if (list.get(i).equals("/")) {
                int a = Integer.parseInt(dq.pollLast());
                i++;
                int b = Integer.parseInt(list.get(i));
                dq.offerLast(String.valueOf(a/b));
            } else {
                dq.offerLast(list.get(i));
            }
        }

        while (dq.size() > 1) {
            int a = Integer.parseInt(dq.pollFirst());
            String op = dq.pollFirst();
            int b = Integer.parseInt(dq.pollFirst());
            int res = 0;
            if (op.equals("+")) {
                res = a+b;
            } else {
                res = a-b;
            }
            dq.offerFirst(String.valueOf(res));
        }

        return Integer.parseInt(dq.peek());
    }

    private List<String> parse(String s) {

        int p1 = 0;
        List<String> list = new ArrayList<>();

        while (p1 < s.length()) {

            char c = s.charAt(p1);

            if (c == '+') {
                list.add("+");
                p1++;
            } else if (c == '-') {
                list.add("-");
                p1++;
            } else if (c == '*') {
                 list.add("*");
                 p1++;
            } else if (c == '/') {
                list.add("/");
                p1++;
            } else if (c == ' ') {
                p1++;
            } else {
                int p2 = p1+1;
                while (p2 < s.length() && s.charAt(p2) >= '0' && s.charAt(p2) <= '9') {
                    p2++;
                }
                String num = s.substring(p1, p2);
                list.add(num);
                p1 = p2;
            }
        }

        return list;
    }
}
