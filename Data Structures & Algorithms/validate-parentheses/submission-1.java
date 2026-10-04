class Solution {
    public static List<Character> OPEN_CHARACTERS = Arrays.asList('(','{','[');
    public boolean isValid(String s) {
        int size = s.length();
        if (size%2!=0) return false;
        Stack<Character> pendingOpenChars = new Stack<>();
        for (int i=0; i<size; i++) {
            if (OPEN_CHARACTERS.contains(s.charAt(i))) {
                pendingOpenChars.push(s.charAt(i));
            } else {
                if (pendingOpenChars.isEmpty() || 
                    !isValidCombination(pendingOpenChars.pop(), s.charAt(i))) {
                    return false;
                }
            }
        }
        return pendingOpenChars.isEmpty();
    }

    private boolean isValidCombination(Character open, Character close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}
