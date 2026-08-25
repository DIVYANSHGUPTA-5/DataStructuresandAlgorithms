class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        // Target can range from -1000 to +1000.
        // So we use 2001 columns: indexes 0 to 2000.
        int[][] dp = new int[n + 1][2001];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, target, n - 1, dp);
    }

    public int solve(int[] nums, int target, int i, int[][] dp) {

        // All numbers have been used.
        // If target is 0, one valid way is found.
        if (i < 0) {
            if (target == 0) return 1;
            return 0;
        }

        // During recursion target can go outside -1000 to +1000.
        // Such a target cannot be a valid final target,
        // so we don't access the DP array.
        if (target < -1000 || target > 1000) {
            return 0;
        }

        // Shift target by 1000 because array indexes cannot be negative.
        // -1000 → index 0
        //     0 → index 1000
        // +1000 → index 2000
        int index = target + 1000;

        // Already calculated
        if (dp[i][index] != -1) {
            return dp[i][index];
        }

        // Put '+' before nums[i]
        int add = solve(nums, target - nums[i], i - 1, dp);

        // Put '-' before nums[i]
        int subtract = solve(nums, target + nums[i], i - 1, dp);

        // Total number of ways
        return dp[i][index] = add + subtract;
    }
}