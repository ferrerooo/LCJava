public class LC_0011_ContainerWithMostWater {
    
    public int maxArea(int[] height) {

        int p1 = 0;
        int p2 = height.length - 1;

        int result = 0;

        while (p1 < p2) {

            result = Math.max(result, (p2-p1)*Math.min(height[p1], height[p2]));
            if (height[p1] > height[p2])
                p2--;
            else
                p1++;
        }
        
        return result;
    }
}