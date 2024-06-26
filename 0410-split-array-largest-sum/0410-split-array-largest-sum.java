class Solution {
    public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        int ans = -1;
        int s = max;
        int e = sum;
        while(s <= e){
            int m = s + (e - s)/2;
            if(numberOfSplits(nums, m) > k){
                s = m + 1;
            }else{
                ans = m;
                e = m - 1;
            }
        }
        return ans;
    }
    public static int numberOfSplits(int[] arr, int t){
        int sum = 0;
        int splits = 1;
        for(int i = 0; i < arr.length; i++){
            if(sum + arr[i] <= t){
                sum += arr[i];
            }else{
                sum = arr[i];
                splits++;
            }
        }
        return splits;
    }
}