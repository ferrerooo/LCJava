import org.junit.Test;

public class Util_1_String {

    @Test
    public void test() {

        // https://www.geeksforgeeks.org/split-string-java-examples/?ref=lbp

        String s = "GeeksforGeeks";
        s.length();
        System.out.println(s);
        
        s.charAt(0);

        // string to char array
        char[] gfg = s.toCharArray();
        // char array to string
        char a[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's' };
        String s2 = new String(a);

        String str = "geekss@for@geekss";
        String[] arrOfStr = str.split("@", 2);

        String data = "1(2 3(6 7(11(14 ) ) ) 4(8(12 ) ) 5(9(13 ) 10 ) )";
        String data1 = "(";
        String[] tempArr = data1.split("\\(");
        System.out.println(tempArr.length);

        // int to string
        String.valueOf(123);
        // string to int
        Integer.parseInt("123");

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
