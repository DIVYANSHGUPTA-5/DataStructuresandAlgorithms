class Solution {

    public int solve(String word1, String word2, int i, int j, int[][] dp) {

        // word1 is finished → insert remaining characters of word2
        if (i < 0) {
            return j + 1;
        }

        // word2 is finished → delete remaining characters of word1
        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters are same → move both
        if (word1.charAt(i) == word2.charAt(j)) {

            dp[i][j] = solve(word1, word2, i - 1, j - 1, dp);

        } else {

            // Replace
            int replace = solve(word1, word2, i - 1, j - 1, dp);

            // Delete
            int delete = solve(word1, word2, i - 1, j, dp);

            // Insert
            int insert = solve(word1, word2, i, j - 1, dp);

            dp[i][j] = 1 + Math.min(
                replace,
                Math.min(delete, insert)
            );
        }

        return dp[i][j];
    }

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(word1, word2, n - 1, m - 1, dp);
    }
}