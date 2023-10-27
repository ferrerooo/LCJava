class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i: nums1)
            set1.add(i);
        
        for (int i: nums2)
            set2.add(i);
        
        List<Integer> list = new ArrayList<>();

        for (int i : set1) {
            if (set2.contains(i)) {
                list.add(i);
            }
        }

        int[] res = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
