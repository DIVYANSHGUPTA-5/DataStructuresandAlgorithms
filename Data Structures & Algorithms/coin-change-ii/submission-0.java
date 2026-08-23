class Solution {
    public int change(int amount, int[] coins) {


        
        
    

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(coins, amount, n - 1, dp);
       
    }

    public int solve(int[] coins, int amount, int i, int[][] dp) {

        if (amount == 0) return 1;
        if (i < 0) return 0;

        if (dp[i][amount] != -1)
            return dp[i][amount];

        int skip = solve(coins, amount, i - 1, dp);

        int take = 0;

        if (coins[i] <= amount) {
            take =solve(coins, amount-coins[i], i , dp);
        }

        return dp[i][amount] = take+ skip;
    }
}


