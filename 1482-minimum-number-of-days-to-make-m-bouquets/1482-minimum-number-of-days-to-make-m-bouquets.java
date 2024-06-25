class Solution {
    public int minDays(int[] bloomDay, int b, int k) {
        int s = 0;
        int ans = -1;
        int[] d = Arrays.copyOf(bloomDay, bloomDay.length);
        Arrays.sort(d);
        int e = d[d.length-1];
        while(s <= e){
            int m = s + (e - s)/2;
            if(bouquets(bloomDay, m, k) >= b){
                ans = m;
                e = m - 1;
            }else{
                s = m + 1;
            }
        }
        return ans;
    }
    static int bouquets(int[] bloomDay, int d, int k){
        int flower = 0;
        int bouque = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= d){
                flower++;
                if(flower == k){
                    bouque++;
                    flower = 0;
                }
            }else{
                flower = 0;
            }
        }
        return bouque;
    }
}