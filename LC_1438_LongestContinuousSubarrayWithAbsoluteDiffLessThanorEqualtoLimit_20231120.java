class Solution {
    public int longestSubarray(int[] nums, int limit) {

        int p1 = 0;
        int p2 = 0;

        LinkedList<Integer> highQueue = new LinkedList<>();
        LinkedList<Integer> lowQueue = new LinkedList<>();

        int result = 1;

        while (p2<nums.length) {

            addToHighQueue(highQueue, nums, p2);
            addToLowQueue(lowQueue, nums, p2);

            if (nums[highQueue.peek()] - nums[lowQueue.peek()] <= limit) {
                result = Math.max(result, p2-p1+1);
            } else {
                while (nums[highQueue.peek()] - nums[lowQueue.peek()] > limit) {
                    if (p1 < highQueue.peek() && p1 < lowQueue.peek()) {
                        p1++;
                    } else if (p1 == highQueue.peek()) {
                        p1++;
                        highQueue.poll();
                    } else {
                        p1++;
                        lowQueue.poll();
                    }
                }
            }

            p2++;

        }

        return result;
    }

    private void addToHighQueue(LinkedList<Integer> queue, int[] nums, int index) {

        while (queue.size() > 0 && nums[queue.peekLast()] < nums[index]) {
            queue.pollLast();
        }

        queue.offer(index);
        return;
    }

    private void addToLowQueue(LinkedList<Integer> queue, int[] nums, int index) {

        while (queue.size() > 0 && nums[queue.peekLast()] > nums[index]) {
            queue.pollLast();
        }

        queue.offer(index);
        return;
    }
}
