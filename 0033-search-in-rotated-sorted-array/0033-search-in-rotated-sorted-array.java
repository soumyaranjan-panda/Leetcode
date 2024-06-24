class Solution {
    public int search(int[] nums, int target) {
        int pivot = pivot(nums);
        int leftSide = BS(nums, target, 0, pivot-1);
        if(leftSide != -1){
            return leftSide;
        }
        return BS(nums, target, pivot, nums.length - 1);
    }
    static int BS(int[] arr, int target, int s, int e){
        while(s <= e){
            int m = s + (e - s)/2;
            if(arr[m] == target){
                return m;
            }else if(arr[m] > target){
                e = m - 1;
            }else{
                s = s + 1;
            }
        }
        return -1;
    }
    static int pivot(int[] arr){
        int min = Integer.MAX_VALUE;
        int pivot = 0;
        int s = 0;
        int e = arr.length - 1;
        while(s <= e){
            int m = s + (e - s)/2;
            if(arr[m] >= arr[s]){
                if (arr[s] <= min){
                    min = arr[s];
                    pivot = s;
                }
                s = m + 1;
            }else{
                if (arr[m] < min){
                    min = arr[m];
                    pivot = m;
                }
                e = m - 1;
            }
        }
        return pivot;
    }
}