public class LC_1274_NumberofShipsinaRectangle {
    private int count = 0;

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {

        dfs(sea, topRight, bottomLeft);
        return count;
    }

    private void dfs(Sea sea, int[] a, int[] b) {

        if (!sea.hasShips(a, b)) {
            return ;
        }

        if (a[0] == b[0] && a[1] == b[1]) {
            count++;
            return;
        }

        if (a[0]!=b[0]) {
            int mid = (a[0]+b[0])/2;
            dfs(sea, a, new int[]{mid+1, b[1]});
            dfs(sea, new int[]{mid, a[1]}, b);
        } else {
            int mid = (a[1]+b[1])/2;
            dfs(sea, a, new int[]{a[0], mid+1});
            dfs(sea, new int[]{a[0], mid}, b);
        }
    }

    private class Sea {
        public boolean hasShips(int[] topRight, int[] bottomLeft){
            return false;
        }
    }
}