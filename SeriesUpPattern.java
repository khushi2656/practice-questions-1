public int[] seriesUp(int n) {
  int length = n * (n + 1) / 2;
  int[] result = new int[length];
  int index = 0;
  for(int groups = 1; groups <= n; groups++){
    for(int nums = 1; nums <= groups; nums++){
      result[index] = nums;
      index++;
    }
  }
  return result;
}