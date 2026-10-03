class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] hmap = new int[26];
        // for (int i=0; i<26; i++) {
        //     hmap[i] = 0;
        // }
        for (char ch : s.toCharArray()) {
            hmap[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            hmap[ch - 'a']--;
        }
        for (int i=0; i<26; i++) {
            if (hmap[i] != 0) return false;
        }
        return true;
    }
}
