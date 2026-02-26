// method 1 - Array frequency counting: we can use an array of size 26 to count the frequency of each character in both strings. We increment the count for characters in string s and decrement the count for characters in string t. Finally, we check if all counts are zero, which indicates that the two strings are anagrams of each other.
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        } 
        for(int val : count){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}
