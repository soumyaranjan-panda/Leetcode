class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int[] a = Arrays.copyOf(nums, nums.length);
        int ans = -1;
        Arrays.sort(a);
        int s = 1;
        int e = a[a.length - 1];
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