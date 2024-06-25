class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length; //size of array.
        if(n > threshold) return -1;
        //Find the maximum element:
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        int ans = -1;

        int s = 1, e = maxi;
        while(s <= e){
            int m = s + (e - s)/2;
            if(sum(nums, m) <= threshold){
                ans = m;
                e = m - 1;
            }else{
                s = m + 1;
            }
        }
        return ans;
    }
    public static int sum(int[] nums, int div) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.ceil((double)(nums[i]) / (double)(div));
        }
        return (int)sum;
    }
}