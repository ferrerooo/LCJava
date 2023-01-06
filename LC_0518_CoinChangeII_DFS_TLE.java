public class LC_0518_CoinChangeII_DFS_TLE {
    
    private int res = 0;

    public int change(int amount, int[] coins) {

        //Arrays.sort(coins);
        dfs(amount, coins, 0, 0);
        return res;
    }

    private void dfs(int amount, int[] coins, int index, int curSum) {

        if (curSum == amount) {
            res++;
            return;
        }

        if (curSum > amount) {
            return;
        }

        for (int i=index; i<coins.length; i++) {
            this.dfs(amount, coins, i, curSum+coins[i]);
        }

        return;
    }
}