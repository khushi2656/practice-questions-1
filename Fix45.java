public int[] fix45(int[] nums) {
  int fiveIndex = 0;
  for(int i = 0; i < nums.length - 1; i++){
    if(nums[i] == 4 && nums[i + 1] != 5){
      while(fiveIndex < nums.length){
        if(nums[fiveIndex] == 5 && (fiveIndex == 0 || nums[fiveIndex - 1] != 4)){
          break;
        }
        fiveIndex++;
      }
      int temp = nums[i + 1];
      nums[i + 1] = nums[fiveIndex];
      nums[fiveIndex] = temp;
      fiveIndex++;
    }
  }
  return nums;
}
