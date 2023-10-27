class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            String sorted = this.sortString(s);
            map.putIfAbsent(sorted, new ArrayList<String>());
            map.get(sorted).add(s);
        }

        List<List<String>> results = new ArrayList<>();

        for (List<String> list : map.values())
            results.add(list);

        return results;
    }

    private String sortString(String s) {

        char[] arr = s.toCharArray();

        Arrays.sort(arr);

        return new String(arr);
    }
}
