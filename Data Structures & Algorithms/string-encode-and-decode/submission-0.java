class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while(index < str.length()) {
            int size = 0;
            while (str.charAt(index) != '#') {
                size = size*10 + (str.charAt(index) - '0');
                index++;
            }
            index++;
            res.add(str.substring(index, index+size));
            index += size;
        }
        return res;
    }
}
