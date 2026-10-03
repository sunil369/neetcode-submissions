class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!numSet.contains(num-1)) {
                int temp = num, tempRes = 1;
                while (numSet.contains(temp+1)) {
                    tempRes++;
                    temp++;
                }
                res = Math.max(res, tempRes);
            }
        }
        return res;
    }
}
