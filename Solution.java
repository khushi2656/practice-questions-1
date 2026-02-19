class Solution {

    public int splitArray(int[] nums, int k) {

        int left = 0;
        int right = 0;

        for(int num : nums){
            left = Math.max(left, num);
            right += num;
        }

        int result = right;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canSplit(nums, k, mid)){
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canSplit(int[] nums, int k, int maxSum){

        int subarrayCount = 1;
        int currentSum = 0;

        for(int num : nums){

            if(currentSum + num > maxSum){
                subarrayCount++;
                currentSum = num;

                if(subarrayCount > k){
                    return false;
                }

            } else {
                currentSum += num;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {7, 2, 5, 10, 8};
        int k1 = 2;
        System.out.println("Test 1: nums = [7,2,5,10,8], k = " + k1);
        System.out.println("Output: " + solution.splitArray(nums1, k1));
        System.out.println("Expected: 18\n");
        
        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 2;
        System.out.println("Test 2: nums = [1,2,3,4,5], k = " + k2);
        System.out.println("Output: " + solution.splitArray(nums2, k2));
        System.out.println("Expected: 9\n");
        
        // Test case 3
        int[] nums3 = {1, 4, 4};
        int k3 = 3;
        System.out.println("Test 3: nums = [1,4,4], k = " + k3);
        System.out.println("Output: " + solution.splitArray(nums3, k3));
        System.out.println("Expected: 4");
    }
}
