class Solution {
    public static int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length; //size of array.
        if(n > threshold) return -1;
        //Find the maximum element:
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int low = 1, high = maxi;

        //Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sum(nums, mid) <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static int sum(int[] nums, int div) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.ceil((double)(nums[i]) / (double)(div));
        }
        return (int)sum;
    }
}