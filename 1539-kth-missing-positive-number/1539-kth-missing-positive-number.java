class Solution {
    public int findKthPositive(int[] arr, int k) {
        int s = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        int e = max;
        if(k > e){
            return k + arr.length;
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }
}