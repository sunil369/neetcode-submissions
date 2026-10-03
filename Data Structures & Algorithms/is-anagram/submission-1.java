class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Integer, Integer> freq = new HashMap();
        for(char c : s.toCharArray()) {
            freq.put(c-'a', freq.getOrDefault(c-'a', 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (freq.getOrDefault(c-'a', 0) > 0) {
                freq.put(c-'a', freq.get(c-'a') - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
