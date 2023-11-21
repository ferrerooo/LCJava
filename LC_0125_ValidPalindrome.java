class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();

        for (int i=0; i<s.length(); i++) {
            
            char c = s.charAt(i);
            if (c>='a' && c<='z') {
                sb.append(c);
            }

            /*if (c>='A' && c<='Z') {
                char temp = 'a' + ((int)c - (int)'A');
                System.out.println(temp);
                sb.append(temp);
            }*/

            if (c>='0' && c<= '9') {
                sb.append(c);
            }
        }

        String cleanStr = sb.toString();
        System.out.println(cleanStr);
        int p1 = 0;
        int p2 = cleanStr.length() - 1;

        while (p1 < p2) {
            if (cleanStr.charAt(p1) != cleanStr.charAt(p2)) {
                return false;
            } else {
                p1++;
                p2--;
            }
        }
        
        return true;
    }
}
