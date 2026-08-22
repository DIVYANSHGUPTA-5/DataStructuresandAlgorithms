class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;
        for (int i=0;i<nums.length;i++)
        
        {
            if(nums[i]!=val)
            {
                nums[k]=nums[i];
                k++;
            }
        }return k;

        
    }
}




// since we have to make changes in the same array 
// therefore we will take an element k which we will 
//treat as new length of array