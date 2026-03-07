class Solution {
    public int beautySum(String s) {
       int totalBeauty = 0;
       int n = s.length();
       for(int i = 0; i < n; i++){
        int[] freq = new int[26];
        for(int j = i; j < n; j++){
            freq[s.charAt(j) - 'a']++;
            int beauty = getBeauty(freq);
            totalBeauty += beauty;
        }
       } 
       return totalBeauty;
    }
    private int getBeauty(int[] freq){
        int maxFreq = 0;
        int minFreq = Integer.MAX_VALUE;
        for(int f : freq){
            if(f > 0){
                maxFreq = Math.max(maxFreq, f);
                minFreq = Math.min(minFreq, f);
            }
        }
        if(minFreq == Integer.MAX_VALUE){
            return 0;
        }
        return maxFreq - minFreq;
    }
}