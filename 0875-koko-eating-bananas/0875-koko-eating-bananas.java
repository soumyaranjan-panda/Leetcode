class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int[] pilesD = piles;
        Arrays.sort(pilesD);
        int e = pilesD[pilesD.length - 1];
        int ans = -1;
        while(s <= e){
            int m = s + (e - s)/2;
            long t = tHours(piles, m);
            if(t <= h){
                ans = m;
                e = m - 1;
            }else{
                s = m + 1;
            }
        }
        return ans;
    }
    static long tHours(int[] arr, int k){
        long hours = 0;
        for(int i = 0; i < arr.length; i++){
            hours = hours + ceil(arr[i], k);
        }
        return hours;
    }
    static int ceil(int hours, int k){
        if(hours % k == 0){
            return hours/k;
        }else{
            return hours/k+1;
        }
    }
}