class Solution {
    public int[] searchRange(int[] arr, int target) {
        int a = -1, b = -1;
        int[] ans = {-1, -1};
        ans[0] = BS(arr, target, 0, arr.length - 1);
        ans[1] = ans[0];
        while(ans[0] != -1 || ans[1] != -1){
            if(ans[0] != -1){
                a = ans[0];
            }
            if(ans[1] != -1){
                b = ans[1];
            }
            ans[0] = BS(arr, target, 0, ans[0] - 1);
            ans[1] = BS(arr, target, ans[1] + 1, arr.length-1);
        }
        return new int[] {a, b};
        
    }
    static int BS(int[] arr, int target, int s, int e){
        while(s <= e){
            int m = s + (e - s)/2;
            if(arr[m] > target){
                e = m - 1;
            }else if(arr[m] < target){
                s = m + 1;
            }else{
                return m;
            }
        }
        return -1;
    }
}