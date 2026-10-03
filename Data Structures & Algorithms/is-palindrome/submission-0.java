class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i<j) {
            while (!isAlphaNumeric(s.charAt(i)) && i<j) {
                i++;
            }
            while (!isAlphaNumeric(s.charAt(j)) && i<j) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}
