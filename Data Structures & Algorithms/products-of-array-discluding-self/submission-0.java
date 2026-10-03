class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pd = 1;
        res[0] = 1;
        for (int i = 1; i<nums.length; i++) {
            pd = pd * (nums[i-1]);
            res[i] = pd;
        }
        pd = 1;
        for (int i = nums.length - 2; i>=0; i--) {
            pd = pd * (nums[i+1]);
            res[i] = res[i] * pd;
        }
        return res;
    }
}  
