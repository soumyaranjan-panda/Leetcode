class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i = 0; i < n+1; i++){
            result[i] = countBit(i);
        }
        return result;
    }
    public int countBit(int n){
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}