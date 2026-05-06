//method 1 = using leftmax and rightmax arrays
class Solution {
    public int trap(int[] height) {
        int n = height.length;
         int[] leftMax = prefixMax(height);
            int[] rightMax = suffixMax(height);
        int total = 0;
        for(int i = 0; i < n-1; i++){
           if(height[i] < leftMax[i] && height[i] < rightMax[i]){
            total += Math.min(leftMax[i] ,  rightMax[i]) - height[i];
           }
           
        }
        return total;
    }
    public int[] prefixMax(int[] height){
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        return leftMax;
    }
    public int[] suffixMax(int[] height){
        int n = height.length;
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1] , height[i]);
        }
        return rightMax;
    }
}
//method 2 = using two pointer approach
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lMax = 0;
        int rMax = 0;
        int total = 0;
        int l = 0;
        int r = n -1;
        while(l < r){
            if(height[l] <= height[r]){
                if(lMax > height[l]){
                    total += lMax - height[l];
                    l++;
                } else{
                    lMax = height[l];
                    l = l + 1;
                }
            }else{
                if(rMax > height[r]){
                    total += rMax - height[r];
                    r--;
                }else{
                    rMax = height[r];
                    r = r - 1;
                }
            }
          
        }
return total;
    }
}