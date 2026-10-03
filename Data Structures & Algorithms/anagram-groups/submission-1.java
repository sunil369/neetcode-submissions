class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> agMap = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            String str = strs[i];
            String orderedStr = getOrderedString(str);
            if (!agMap.containsKey(orderedStr)) {
                agMap.put(orderedStr, new ArrayList<>());
            }
            agMap.get(orderedStr).add(str);
        }
        return agMap.values().stream().toList();
    }

    private String getOrderedString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
