class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> tfreq = getFreqMap(t);
        Map<Character, Integer> sfreq = new HashMap<>();

        int l = 0;
        int required = tfreq.size();
        int formed = 0;

        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            if (tfreq.containsKey(ch)) {
                sfreq.put(ch, sfreq.getOrDefault(ch, 0) + 1);

                // This character has now satisfied its required frequency
                if (sfreq.get(ch).equals(tfreq.get(ch))) {
                    formed++;
                }
            }

            // Current window contains all required characters
            while (formed == required) {
                // Update minimum window
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    minLeft = l;
                }

                char leftChar = s.charAt(l);

                if (tfreq.containsKey(leftChar)) {
                    sfreq.put(leftChar, sfreq.get(leftChar) - 1);

                    // We no longer have enough of this character
                    if (sfreq.get(leftChar) < tfreq.get(leftChar)) {
                        formed--;
                    }
                }

                l++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(minLeft, minLeft + minLength);
    }

    private Map<Character, Integer> getFreqMap(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        return freq;
    }
}