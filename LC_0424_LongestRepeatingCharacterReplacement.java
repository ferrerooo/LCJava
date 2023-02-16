public class LC_0424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        
        String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int maxLen = 1;

        for (int i=0; i<allChars.length(); i++) {

            char c = allChars.charAt(i);
            int p1 = 0;
            int p2 = 0;

            int countOthers = 0;

            while (p2 < s.length()) {

                if (s.charAt(p2) == c) {
                    maxLen = Math.max(maxLen, p2-p1+1);
                    p2++;
                    continue;
                } 

                if (countOthers < k) {
                    countOthers++;
                    maxLen = Math.max(maxLen, p2-p1+1);
                    p2++;
                    continue;
                } else {
                    while (s.charAt(p1) == c) {
                        p1++;
                    }
                    p1++;
                    p2++;
                }
            }
        }

        return maxLen;
    }
}