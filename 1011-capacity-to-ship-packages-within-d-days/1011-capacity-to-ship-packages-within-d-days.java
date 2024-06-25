class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s = Integer.MIN_VALUE;
        int e = 0;
        int ans = -1;
        for(int i = 0; i < weights.length; i++){
            e += weights[i];
            s = Math.max(s, weights[i]);
        }
        
        while(s<=e){
            int m = s + (e - s)/2;
            if(days(weights, m) <= days){
                ans = m;
                e = m - 1;
            }else{
                s = m + 1;
            }
        }
        return ans;
    }
    public static int days(int[] arr, int w){
        int tweight = 0;
        int d = 0;
        for(int i = 0; i < arr.length; i++){
            if(tweight+arr[i] <= w){
                tweight += arr[i];
            }else{
                d++;
                tweight=arr[i];
            }
        }
        return d+1;
    }
}