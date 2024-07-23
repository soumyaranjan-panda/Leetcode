class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return sets(new ArrayList<>(), nums);
    }
    public List<List<Integer>> sets(List<Integer> p, int[] up){
        if(up.length == 0){
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(p));
            return list;
        }
        int n = up[0];
        List<List<Integer>> list = new ArrayList<>(sets(new ArrayList<>(p), Arrays.copyOfRange(up, 1, up.length)));
        p.add(n);
        list.addAll(sets(new ArrayList<>(p), Arrays.copyOfRange(up, 1, up.length)));
        return list;
    }
}