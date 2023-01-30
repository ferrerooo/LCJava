import java.util.*;

public class LC_0093_RestoreIPAddresses {
    
    public List<String> restoreIpAddresses(String s) {
        
        List<String> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        int index = 0;

        dfs(s, 0, res, cur);
        return res;
    }

    private void dfs(String s, int index, List<String> res, List<String> cur) {

        if (index == s.length())
            return;
        
        if (cur.size() == 3) {
            String adr = s.substring(index);
            if (isValid(adr)) {
                cur.add(adr);
                res.add(genAddress(cur));
                cur.remove(3);
            }
            return;
        }

        for (int i = index; i<s.length(); i++) {

            String adr = s.substring(index, i+1);
            if (isValid(adr)) {
                cur.add(adr);
                dfs(s, i+1, res, cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    private String genAddress (List<String> list) {
        return list.get(0)+"."+list.get(1)+"."+list.get(2)+"."+list.get(3);
    }

    private boolean isValid(String address) {

        if (address.length() > 3)
            return false;
        
        if (address.length() > 1 && address.charAt(0) == '0')
            return false;
        
        int num = Integer.valueOf(address);

        if (num >=0 && num <= 255)
            return true;
        else
            return false;
    }
}