// method 1: using two hash maps to store the mappings from s to t and from t to s. We check for consistency in both mappings as we iterate through the characters of the strings.
class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char charS = s.charAt(i);
            char charT = t.charAt(i);

           
            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) {
                    return false;
                }
            } else {
                mapST.put(charS, charT);
            }

           
            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) {
                    return false;
                }
            } else {
                mapTS.put(charT, charS);
            }
        }

        return true;
    }
}


// method 2: using two arrays to store the mappings from s to t and from t to s. We check for consistency in both mappings as we iterate through the characters of the strings. This method is more efficient in terms of space complexity compared to using hash maps.
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int [] mapST = new int[256];
        int [] mapTS = new int[256];

        Arrays.fill(mapST, -1);
        Arrays.fill(mapTS, -1);

        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if(mapST[charS] == -1){
                mapST[charS] = charT;
            } else if(mapST[charS] != charT){
                return false ;

            }

            if(mapTS[charT] == -1){
                mapTS[charT] = charS;
            } else if(mapTS[charT] != charS){
                return false ;

            }
           
        }
        return true;

    }
}

// method 3 - single pass with two arrays: we can optimize the previous method by using a single pass through the strings and updating both mappings simultaneously. This approach also has a space complexity of O(1) since we are using fixed-size arrays to store the mappings.  

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] firstOccurrenceS = new int[256];
        int[] firstOccurrenceT = new int[256];
        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(firstOccurrenceS[charS] != firstOccurrenceT[charT]){
                return false;
            }
            firstOccurrenceS[charS] = i + 1;
            firstOccurrenceT[charT] = i + 1;
        }
        return true;
    }
}