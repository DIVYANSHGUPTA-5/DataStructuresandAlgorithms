class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int i = text1.length();
        int j = text2.length();

        int[][] dp = new int[i + 1][j + 1];

        // Fill DP with -1
        for (int x = 0; x <= i; x++) {
            Arrays.fill(dp[x], -1);
        }

        return solve(text1, text2, i - 1, j - 1, dp);
    }

    private int solve(String text1, String text2, int i, int j, int[][] dp) {

        // If either string is exhausted
        if (i < 0 || j < 0) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters match
        if (text1.charAt(i) == text2.charAt(j)) {

            dp[i][j] = 1 + solve(
                text1, text2, i - 1, j - 1, dp
            );
        }

        // Characters don't match
        else {

            dp[i][j] = Math.max(
                solve(text1, text2, i, j - 1, dp),
                solve(text1, text2, i - 1, j, dp)
            );
        }

        return dp[i][j];
    }
}