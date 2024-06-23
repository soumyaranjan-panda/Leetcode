/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndex(mountainArr);
        int lowerSide = orderAgnosticBS(mountainArr, target, 0, peak, true);
        if(lowerSide != -1){
            return lowerSide;
        }
        int higherSide = orderAgnosticBS(mountainArr, target, peak+1, mountainArr.length()-1, false);
        return higherSide;
    }
    static int orderAgnosticBS(MountainArray mountainArr, int target, int s, int e, boolean isAsc){
        while(s <= e){
            int m = s + (e - s)/2;
            if(mountainArr.get(m) == target){
                return m;
            }
            if(isAsc){
                if(mountainArr.get(m) > target){
                    e = m - 1;
                }else{
                    s = m + 1;
                }
            }else{
                if(mountainArr.get(m) > target){
                    s = m + 1;
                }else{
                    e = m - 1;
                }
            }
        }
        return -1;
    }
    static int peakIndex(MountainArray mountainArr){
        int s = 0;
        int e = mountainArr.length() - 1;
        while(s < e){
            int m = s + (e - s)/2;
            if(mountainArr.get(m) > mountainArr.get(m+1)){
                e = m;
            }else{
                s = m + 1;
            }
        }
        return e;
    }
}