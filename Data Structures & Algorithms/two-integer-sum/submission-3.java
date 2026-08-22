class Solution {
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i != j && nums[i] + nums[j] == target) {

                   
     if (i < j) {
                        return new int[]{i, j};
                    } else {
                        return new int[]{j, i};
                    }
                }
            }}
        

        return new int[]{}; 
    }
}