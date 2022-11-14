import java.util.*;

class LC_1642_FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int result = 0;
        PriorityQueue<Integer> qp = new PriorityQueue<>();
        
        for (int i = 1; i< heights.length; i++) {
            
            if (heights[i] <= heights[i-1]) {
                result = i;
                continue;
            }
            
            int gap = heights[i] - heights[i-1];
            
            if (ladders > 0) {
                ladders--;
                qp.offer(gap);
                result = i;
                continue;
            } 
            
            
            if (qp.size() == 0) {
                if (bricks >= gap) {
                    bricks = bricks - gap;
                    result = i;
                    continue;
                } else {
                    result = i - 1;
                    break;
                }
            } 
            
                    
            if (qp.peek() < gap) {
                if (bricks >= qp.peek()) {
                    bricks = bricks - qp.poll();
                    qp.offer(gap);
                    result = i;
                } else {
                    result = i - 1;
                    break;
                }
            } else {
                if (bricks >= gap) {
                    bricks = bricks - gap;
                    result = i;
                } else {
                    result = i - 1;
                    break;
                }
            }
        }
        
        return result;
    }
}