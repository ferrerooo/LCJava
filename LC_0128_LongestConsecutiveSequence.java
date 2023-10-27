class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int i: nums) {
            set.add(i);
        }

        for (int i=0; i<nums.length; i++) {

            int cur = nums[i];
            if (!set.contains(cur)) {
                continue;
            }

            int count = 1;
            set.remove(cur);
            int p1 = cur+1;
            while (set.contains(p1)) {
                count++;
                set.remove(p1);
                p1++;
            }
            int p2 = cur-1;
            while (set.contains(p2)) {
                count++;
                set.remove(p2);
                p2--;
            }

            res = Math.max(res, count);
        }

        return res;
        
    }
}
