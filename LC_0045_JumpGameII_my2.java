public class LC_0045_JumpGameII_my2 {
    public int jump(int[] nums) {

        if (nums.length == 1)
            return 0;
        
        int answer = 1;
        int farthest = nums[0];

        int index = 1;

        while (farthest < nums.length-1) {

            int farlocal = -1;
            while (index <= farthest) {
                farlocal = Math.max(farlocal, index+nums[index]);
                index++;
            }

            answer++;
            farthest = Math.max(farlocal, farthest);

        }

        return answer;
    }
}