//https://github.com/cherryljr/LeetCode/blob/master/Binary%20Index%20Tree%20Template.java

public class BinaryIndexTree_Template {
    public static void main(String[] args) {
        BinaryIndexTree BITree = new BinaryIndexTree();
        int[] arr = {0, 9, 5, 7, 3};
        BITree.buildBITree(arr);

        System.out.println("Sum of elements in arr[0..4] is: " + BITree.getSum(4));
        System.out.println("Sum of elements in arr[2..4] is: " + BITree.getSum(2, 4));
        BITree.updateBIT(1, 2);
        System.out.println("Sum of elements in arr[0..4] is: " + BITree.getSum(4));
        System.out.println("Sum of elements in arr[2..4] is: " + BITree.getSum(2, 4));
    }
}

class BinaryIndexTree {

    int size;
    static int[] BITree;
    int[] arr;

    public void buildBITree(int[] arr) {
        size = arr.length;
        BITree = new int[size + 1];
        this.arr = arr;

        for (int i = 0; i < size; i++) {
            updateBIT(i, arr[i]);
        }
    }

    public void updateBIT(int index, int val) {
        // index in BITree[] is 1 more than the index in arr[]
        index = index + 1;
        while (index < BITree.length) {          
            BITree[index] += val;
            index += index & -index;
        }
    }

    public int getSum(int index) {

        if (index < 0 || index >= size) {
            return 0;
        }

        int sum = 0;
        index = index + 1;
        while (index > 0) {
            sum += BITree[index];
            index -= index & -index;
        }

        return sum;
    }

    public int getSum(int start, int end) {
        return (start > end || start < 0 || end >= size) ? 0 :
                start == end ? arr[start] : getSum(end) - getSum(start - 1);
    }

}