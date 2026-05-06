import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        int n = arr.length;
    ArrayList<Integer> nse = new ArrayList<>();
    for(int i = 0; i < n; i++){
        nse.add(0);
    }
        Stack<Integer> st = new Stack<>();
        
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nse.set(i , st.isEmpty() ? -1 : arr[st.peek()]);
            st.push(i);
        }
        return nse;
    }
} {
    
}
