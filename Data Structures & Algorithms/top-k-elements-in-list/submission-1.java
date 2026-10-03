class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }

        PriorityQueue<ElementFrequency> pq = new PriorityQueue<>(k, (obj1,obj2) -> Integer.compare(obj1.getFrequency(), obj2.getFrequency()));

        freq.forEach((num, frequency) -> {
            ElementFrequency obj = new ElementFrequency(num,frequency);
            if (pq.size()<k) {
                pq.add(obj);
            } else if (pq.peek().getFrequency()<frequency) {
                pq.poll();
                pq.add(obj);
            }
        });

        int[] res = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            res[index] = pq.poll().getNum();
            index++;
        }
        return res;
    }

    private class ElementFrequency {
        private int num;
        private int frequency;

        public ElementFrequency(int num, int frequency) {
            this.num = num;
            this.frequency = frequency;
        }

        public int getNum() {
            return this.num;
        }

        public int getFrequency() {
            return this.frequency;
        }
    }
}
