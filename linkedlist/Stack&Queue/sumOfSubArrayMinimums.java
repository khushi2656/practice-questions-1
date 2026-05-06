class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = findNse(arr);
        int[] pse = findPse(arr);
        long total = 0;
        int mod = (int)(1e9 + 7);
        for(int i = 0; i <= n - 1; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            total = (total + (1L * arr[i] * right * left )% mod) % mod;
        }
        return(int) total;
    }
public int[] findPse(int[] arr){
    int n = arr.length;
    int[] pse = new int[n];
    Stack<Integer> st = new Stack<>();
    for(int i = 0; i <= n -1; i++){
        while(!st.isEmpty() && arr[st.peek()] > arr[i]){
            st.pop();
// pse[i] = st.isEmpty() ? -1 : st.peek();
// st.push(i);
        }
        pse[i] = st.isEmpty() ? -1 : st.peek();
st.push(i);
        
    }
    return pse;
}
public int[] findNse(int[] arr){
    int n = arr.length;
    int[] nse = new int[n];
    Stack<Integer> st = new Stack<>();
    for(int i = n - 1; i >= 0; i--){
        while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
            st.pop();
            // nse[i] = st.isEmpty() ? n : st.peek();
            // st.push(i);
        }
        nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
  
    }
          return nse;
}
}