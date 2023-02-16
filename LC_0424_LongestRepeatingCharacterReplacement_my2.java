public class LC_0424_LongestRepeatingCharacterReplacement_my2 {
    public int characterReplacement(String s, int k) {
        
        int ans = 0;

        for (char c = 'A'; c<='Z'; c++) {

            int cnt = 0;
            int cntOther = 0;

            int p1 = 0;
            int p2 = 0;

            while (p2 < s.length()) {

                char c1 = s.charAt(p2);

                if (c1 == c) {
                    cnt++;
                } else {
                    cntOther++;
                }

                if (cntOther <=k) {
                    ans = Math.max(ans, cnt+cntOther);
                } else {
                    while (s.charAt(p1) == c) {
                        p1++;
                        cnt--;
                    }
                    p1++;
                    cntOther--;
                }

                p2++;
            }

        }

        return ans;

    }

}