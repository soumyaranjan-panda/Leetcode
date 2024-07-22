class Solution {
    public List<String> letterCombinations(String digits) {
        return helper("", digits);
    }
    public ArrayList<String> helper(String p, String up){
        if (up.isEmpty()){
            if(p.isEmpty()){
                return new ArrayList<>();
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(p);
                return list;
            }
        }
        int n = up.charAt(0) - '0';
        String s = lettersOfNumber(n);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            list.addAll(helper(p+ch, up.substring(1)));
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