class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        reverse(chars, 0 , n -1);
        int i = 0;
        for(int j = 0; j<=n; j++){
            if(j == n || chars[j] == ' '){
                reverse(chars , i, j-1);
                i = j + 1;
            }
        }
        return cleanSpaces(chars);
    }
    private void reverse(char[] chars, int left, int right){
        while(left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
    private String cleanSpaces(char[] chars){
        int n = chars.length;
        int i = 0 , j = 0;
        while(j < n){
            while(j < n && chars[j] == ' ')j++;
            while(j < n && chars[j] != ' '){
                chars[i++] = chars[j++];
            }
            while(j < n && chars[j] == ' ')j++;
            if(j < n) chars[i++] = ' ';
        }
        return new String(chars , 0, i);
    }
}