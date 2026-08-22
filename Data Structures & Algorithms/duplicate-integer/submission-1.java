class Solution {
    public boolean hasDuplicate(int[] nums) {
        for ( int i=0;i<nums.length;i++){
            for( int g=0;g<nums.length;g++){
                if (i!=g && nums[i]==nums[g]){
                    return true ;

            }
        }
        }return false ;
    }
}
// in if condition i!=g is to make it self check than it will always good --
// for true only fail when false comes due to self check 