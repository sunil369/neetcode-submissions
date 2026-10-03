class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, left = 0;
        Map<Character, Integer> hmap = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (hmap.containsKey(s.charAt(i))) {
                left = Math.max(left, hmap.get(s.charAt(i))+1);
            }
            hmap.put(s.charAt(i),i);
            res = Math.max(res, i-left+1);
        }

        return res;
    }
}
