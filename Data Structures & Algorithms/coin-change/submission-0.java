class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(coins, amount, n - 1, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int solve(int[] coins, int amount, int i, int[][] dp) {

        if (amount == 0) return 0;
        if (i < 0) return Integer.MAX_VALUE;

        if (dp[i][amount] != -1)
            return dp[i][amount];

        int skip = solve(coins, amount, i - 1, dp);

        int take = Integer.MAX_VALUE;

        if (coins[i] <= amount) {
            int x = solve(coins, amount - coins[i], i, dp);

            if (x != Integer.MAX_VALUE)
                take = 1 + x;
        }

        return dp[i][amount] = Math.min(take, skip);
    }
}