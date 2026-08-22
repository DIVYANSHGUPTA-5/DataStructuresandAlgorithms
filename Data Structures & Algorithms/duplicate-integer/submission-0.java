class Solution {
    public boolean hasDuplicate(int[] nums) {

        int a, b = 0;

        for (int i = 1; i < nums.length; i++) {

            a = nums[b];

            if (a == nums[i]) {
                return true;
            }

            // move b forward when i reaches end
            if (i == nums.length - 1) {
                b++;
                i = b;
            }

            // stop when b reaches second last index
            if (b == nums.length - 1) {
                break;
            }
        }
        return false;
    }
}