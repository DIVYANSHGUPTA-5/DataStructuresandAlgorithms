class Solution {

    public int solve(int[] nums, int target, int[] dp) {

        // Target 0 means we successfully made the target
        // There is 1 way: choose nothing
        if (target == 0) {
            return 1;
        }

        // If this target is already calculated, return its answer
        if (dp[target] != -1) {
            return dp[target];
        }

        // Count ways for the current target
        int count = 0;

        // Try every number
        // Every new solve() starts from nums[0] again
        for (int num : nums) {

            // We can only choose num if it is <= target
            if (num <= target) {

                // Choose num and solve the remaining target
                count += solve(nums, target - num, dp);
            }
        }

        // Store the answer for this target
        return dp[target] = count;
    }

    public int combinationSum4(int[] nums, int target) {

        // dp[target] = number of ways to make this target
        int[] dp = new int[target + 1];

        // -1 means this target has not been calculated yet
        Arrays.fill(dp, -1);

        return solve(nums, target, dp);
    }
}