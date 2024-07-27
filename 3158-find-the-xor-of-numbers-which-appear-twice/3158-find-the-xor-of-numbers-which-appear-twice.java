class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int[] occrCount = new int[50];
        int xorResult = 0;
        for(int num : nums){
            occrCount[num-1]++;
            if(occrCount[num-1] % 2 == 0){
                xorResult ^= num;
            }                        
        }
        return xorResult;
    }
}