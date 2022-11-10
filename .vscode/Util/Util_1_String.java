import org.junit.Test;

public class Util_1_String {

    @Test
    public void test() {

        // https://www.geeksforgeeks.org/split-string-java-examples/?ref=lbp

        String s = "GeeksforGeeks";
        s.length();
        
        s.charAt(0);

        char[] gfg = s.toCharArray();
        
        char a[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's' };
        String s2 = new String(a);

        String str = "geekss@for@geekss";
        String[] arrOfStr = str.split("@", 2);
        /*
         * Regex Limit Result
         * 
         * @ 2 {“geekss”, ”for@geekss”}
         * @ 5 {“geekss”, ”for”, ”geekss”}
         * @ -2 {“geekss”, ”for”, ”geekss”}
         * s 5 {“geek”, ”“, “@for@geek”, “”, “”}
         * s -2 {“geek”, ” “, ” “, “@for@geek”, “”, “”}
         * s 0 {“geek”, ””, ”@for@geek”}
         */
    }

}
