class Solution {
    public int search(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        while(s <= e){
            int m = s + (e - s)/2;
            if(arr[m] == target){
                return m;
            }
            if(arr[s] <= arr[m]){
                if(target < arr[m] && target >= arr[s]){
                    e = m - 1;
                }else{
                    s = m + 1;
                }
            }else{
                if(target > arr[m] && target <= arr[e]){
                    s = m + 1;
                }else{
                    e = m - 1;
                }
            }
        }
        return -1;
    }
}