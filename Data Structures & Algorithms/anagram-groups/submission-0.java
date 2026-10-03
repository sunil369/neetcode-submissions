class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String hash = new String(chars);
            if (!anagramsMap.containsKey(hash)) {
                anagramsMap.put(hash, new ArrayList());
            }
            anagramsMap.get(hash).add(str);
        }
        return new ArrayList<>(anagramsMap.values());
    }
}
