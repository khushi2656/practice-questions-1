// method 1: using hashmap and sorting
class Solution {
    public String frequencySort(String s) {
        Map<Character , Integer> freqMap = new HashMap<>();
        for(char c : s.toCharArray()){
            freqMap.put(c , freqMap.getOrDefault(c ,0) + 1);
        }
        List<Character> chars = new ArrayList<>(freqMap.keySet());
        chars.sort((a , b) -> freqMap.get(b) - freqMap.get(a));

        StringBuilder result = new StringBuilder();
        for(char c : chars){
            int freq = freqMap.get(c);
            for(int i = 0; i < freq; i++){
                result.append(c);
            }
        }
        return result.toString();
    }
}


// method 2: using bucket sort
class Solution {
    public String frequencySort(String s) {
        Map<Character , Integer> freqMap = new HashMap<>();
        for(char c : s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        List<Character>[] bucket = new ArrayList[s.length() + 1];

        for(char c : freqMap.keySet()){
            int freq = freqMap.get(c);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(c);
        }
        StringBuilder result = new StringBuilder();
        for(int freq = bucket.length - 1; freq > 0; freq--){
          if(bucket[freq] != null){
            for(char c : bucket[freq]){
                for(int i = 0; i < freq; i++){
                    result.append(c);
                }
            }
          }
        }
        return result.toString();
    }
}