public class LC_0307_Range_Sum_Query_Mutable_BIT {

    private BinaryIndexTree bit;
    
    public LC_0307_Range_Sum_Query_Mutable_BIT(int[] nums) {
        bit = new BinaryIndexTree();
        bit.buildTree(nums);
    }

    public void update(int index, int val) {
        bit.update(index, val);
    }

    public int sumRange(int i, int j) {
        return bit.read(j + 1) - bit.read(i);
    }
    
    private class BinaryIndexTree{

        private int[] nums;
        private int[] bit;

        public void buildTree(int[] nums) {
            this.nums = new int[nums.length + 1];
            this.bit = new int[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                update(i, nums[i]);
            }
        }

        public void update(int index, int val) {
            final int diff = val - this.nums[index + 1];
            for (int i = index + 1; i < this.nums.length; i += lowbit(i)) {
                bit[i] += diff;
            }
            this.nums[index + 1] = val;
        }

        public int read(int index) {
            int result = 0;
            for (int i = index; i > 0; i -= lowbit(i)) {
                result += bit[i];
            }
            return result;
        }
    
        public int lowbit(int x) {
            return x & (-x); 
        }


    }
}
    
}
