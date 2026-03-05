// method 1 : using stack
class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
                maxDepth = Math.max(maxDepth , stack.size());
            } else if (c == ')'){
                stack.pop();
            }
        }
        return maxDepth;
    }
}


// method 2 : using counter for counting the frequency of parentheses
class Solution {
    public int maxDepth(String s) {
        int currentDepth = 0;
        int maxDepth = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                currentDepth++;
                maxDepth = Math.max(maxDepth , currentDepth);
            } else if(c == ')'){
                currentDepth--;
            }
        }
        return maxDepth;
    }
}