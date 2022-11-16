import java.util.*;

public class LC_1024_VideoStitching {

    

    /* 
    public int videoStitching(int[][] clips, int time) {
        
        Arrays.sort(clips, (x,y)-> x[0]-y[0]);
        
        if (clips[0][0] > 0)
            return -1;
        
        for (int[] temp : clips)
            System.out.println(temp[0] + ", " + temp[1]);
        
        int count = 0;
        int curEnd = 0;
        int pointer = 0;
        int stopPoint = curEnd;
        
        while (curEnd < time) {
            
            if (pointer >= clips.length)
                return -1;
            
            while (pointer < clips.length && clips[pointer][0] <= stopPoint) {
                
                int[] curClip = clips[pointer];
                if (curClip[1] > curEnd) {
                    curEnd = curClip[1];
                }
                pointer++;
            }
            
            if (stopPoint == curEnd)
                return -1;
            
            count++;
            stopPoint = curEnd;
        }
        
        return count;
    }
    */
    
}
