class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> contains = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (contains.containsKey(nums[i])) return true;
            contains.put(nums[i], true);
        }
        return false;
    }
}