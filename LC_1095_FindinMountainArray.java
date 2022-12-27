public class LC_1095_FindinMountainArray {
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int len = mountainArr.length();

        int peekIndex = this.findPeek(mountainArr);
        //System.out.println("Peek index: "+ peekIndex);
        //System.out.println("Peek value: "+ mountainArr.get(peekIndex));

        int res = this.findInAscending(mountainArr, 0, peekIndex, target);
        
        if (res == -1) 
            res = this.findInDescending(mountainArr, peekIndex, len-1, target);

        return res;
    }

    private int findInAscending(MountainArray m, int p1, int p2, int target) {

        while (p1 <= p2) {
            int mid = p1 + (p2-p1)/2;
            if (m.get(mid) == target) {
                return mid;
            } else if (m.get(mid) > target) {
                p2 = mid-1;
            } else {
                p1 = mid+1;
            }
        }

        return -1;
    }

    private int findInDescending(MountainArray m, int p1, int p2, int target) {

        while (p1 <= p2) {
            int mid = p1 + (p2-p1)/2;
            if (m.get(mid) == target) {
                return mid;
            } else if (m.get(mid) > target) {
                p1 = mid+1;
            } else {
                p2 = mid-1;
            }
        }

        return -1;
    }

    private int findPeek(MountainArray mountainArr)  {

        int p1 = 0;
        int p2 = mountainArr.length() - 1;
        int len = mountainArr.length();

        while (p1<=p2) {

            int mid = p1 + (p2-p1)/2;
            if ((mid > 0 && mountainArr.get(mid) > mountainArr.get(mid-1) && mountainArr.get(mid) < mountainArr.get(mid+1))
            || (mid == 0 && mountainArr.get(mid) < mountainArr.get(mid+1))) {
                p1 = mid+1;
            } else if ((mid < len-1 && mountainArr.get(mid) < mountainArr.get(mid-1) && mountainArr.get(mid) > mountainArr.get(mid+1))
            || (mid == len-1 && mountainArr.get(mid) < mountainArr.get(mid-1))) {
                p2 = mid-1;
            } else {
                return mid;
            }
        }

        return -1; // this line should not be achievable due to the attribute of mountain
    }
}

interface MountainArray {
         public int get(int index);
         public int length();
}