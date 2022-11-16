public class LC_0443_StringCompression {

    public int compress(char[] chars) {
        
        int cur = 0;
        StringBuilder sb = new StringBuilder();
        
        while (cur < chars.length) {
            
            char curChar = chars[cur];
            int next = this.getNext(chars, cur);
            
            sb.append(curChar);
            if (next-cur>1) {
                sb.append(String.valueOf(next-cur));
            }
            
            cur = next;
        }
        
        return sb.length();
    }
    
    private int getNext(char[] chars, int cur) {
        
        char curChar = chars[cur];
        
        while (cur+1 < chars.length && curChar == chars[cur+1]) {
            cur = cur + 1;
        }
        
        return cur + 1;
    }
    
}
