class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return sumHelper(new ArrayList<>(), candidates, target, 0);
    }
    public List<List<Integer>> sumHelper(List<Integer> current, int[] arr, int target, int start){
        if (target == 0){
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>(current));
            return result;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < arr.length; i++) {
            if (arr[i] <= target){
                current.add(arr[i]);
                result.addAll(sumHelper(current, arr, target-arr[i], i));
                current.remove(current.size() - 1);
            }
        }
        return result;
    }
}