// method 1 : using look ahead methond but forward pass only
class Solution {
    public int romanToInt(String s) {
        Map<Character , Integer> map = new HashMap<>();
       map.put('I', 1);
       map.put('V', 5);
       map.put('X', 10);
       map.put('L', 50);
       map.put('C', 100);
       map.put('D', 500);
       map.put('M', 1000);
       int result = 0;
       for(int i = 0; i < s.length(); i++){
        int current = map.get(s.charAt(i));
        if(i < s.length() - 1){
            int next = map.get(s.charAt(i + 1));
            if(current < next){
                result -= current;
            } else {
                result += current;
            }
        } else {
            result += current;
        }
       }
       return result;
    }
}

// method 2 : using look ahead to determine whether to add or subtract the current value but this method is more efficient than the previous one 
class Solution {
    public int romanToInt(String s) {
       Map<Character , Integer> map = new HashMap<>();
       map.put('I', 1);
       map.put('V', 5);
       map.put('X', 10);
       map.put('L', 50);
       map.put('C', 100);
       map.put('D', 500);
       map.put('M', 1000);
       int result = 0;
       int prevValue = 0;
       
       for(int i = s.length() - 1; i >= 0; i--){
        int currentValue = map.get(s.charAt(i));
        if(currentValue < prevValue){
            result -= currentValue;
        } else {
            result += currentValue;
        }
        prevValue = currentValue;
       }
       return result;

    }
}