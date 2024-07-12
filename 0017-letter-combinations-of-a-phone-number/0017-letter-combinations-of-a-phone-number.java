class Solution {
    public List<String> letterCombinations(String digits) {
        return helper("", digits);
    }
    public List<String> helper(String p, String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<String>();
            if(p.isEmpty()){
                return list;
            }else{
                list.add(p);
                return list;
            }
        }
        List<String> list = new ArrayList<String>();
        int n = up.charAt(0) - '0';
        String s = lettersOfNumber(n);
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            List<String> list1 = helper(p+ch, up.substring(1));
            list.addAll(list1);
        }
        return list;
    }
    public String lettersOfNumber(int n){
        return switch (n) {
            case 2 -> "abc";
            case 3 -> "def";
            case 4 -> "ghi";
            case 5 -> "jkl";
            case 6 -> "mno";
            case 7 -> "pqrs";
            case 8 -> "tuv";
            case 9 -> "wxyz";
            default -> "";
        };
    }
}