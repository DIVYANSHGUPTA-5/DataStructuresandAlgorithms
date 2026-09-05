// solve(10)
//    |
//    | i = 1
//    |
//    |-- breakMore = 1 * solve(9)
//                          |
//                          ↓
//                       solve(9)
//                          |
//                          | i = 1
//                          |-- 1 * solve(8)
//                          |       ↓
//                          |     solve(8)
//                          |       ...
//                          |
//                          | i = 2
//                          |-- 2 * solve(7)
//                          |
//                          | i = 3
//                          |-- 3 * solve(6)
//                          |
//                          | ...
//                          |
//                          ↓
//                     solve(9) = 27


class Solution {

    public int solve(int n, int[] dp) {

        if(n == 1) return 1;
   //bcoz solve(1) is stopping case 
        if(dp[n] != -1) return dp[n];

        int max = 0;
     // i < n bcoz n-i if n==i will be 0 
        for(int i = 1; i < n; i++) {

            int notbreakmore = i * (n - i);

            int breakmore = i * solve(n - i, dp);

            max = Math.max(max, Math.max(notbreakmore, breakmore));
        }

        return dp[n] = max;
    }

    public int integerBreak(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return solve(n, dp);
    }
}