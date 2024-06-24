class Solution {
    public int searchInsert(int[] arr, int target) {
        int ans = arr.length;
        int s = 0, e = ans-1;
        while(s <= e){
            int m = s + (e - s)/2;
            if(arr[m] >= target){
                ans = m;
                e = m - 1;
            }else{
                s = m + 1;
            }
        }
        return ans;
    }
}