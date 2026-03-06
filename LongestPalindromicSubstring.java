// method 1: brute force approach
class Solution {
    public String longestPalindrome(String s) {
         if (s == null || s.length() < 1) return "";
        
        String longest = "";
        
       
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                
                String substring = s.substring(i, j + 1);
                
                
                if (isPalindrome(substring)) {
                    
                    if (substring.length() > longest.length()) {
                        longest = substring;
                    }
                }
            }
        }
        
        return longest;
    }
    
    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }

    }
