// method 1 = String concatenation 
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
        return(s + s).contains(goal);
    }
}