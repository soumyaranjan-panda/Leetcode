class Solution {
    public int findMin(int[] arr) {
        int s = 0, e = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while(s <= e){
            int m = s + (e - s)/2;
            if(arr[m] >= arr[s]){
                ans = Math.min(ans, arr[s]);
                s = m + 1;
            }else{
                e = m - 1;
                ans = Math.min(ans, arr[m]);
            }
        }
        return ans;
    }
}