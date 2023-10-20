class Solution {
    public String largestNumber(int[] nums) {
        
        String[] arr = new String[nums.length];
        for (int i=0;i<nums.length; i++)
            arr[i] = String.valueOf(nums[i]);

        Arrays.sort(arr, (x,y) -> {
            Double ab = Double.parseDouble(x+y);
            Double ba = Double.parseDouble(y+x);
            if (ba > ab)
                return 1;
            else if (ba < ab)
                return -1;
            else
                return 0;
        }); 

        StringBuilder sb = new StringBuilder();

        if (Integer.parseInt(arr[0]) == 0)
            return "0";

        for (String a : arr) {
            sb.append(a);
        }

        return sb.toString();
    }
}
