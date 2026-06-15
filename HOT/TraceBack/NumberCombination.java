class Solution {
    private String[] map = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    private List<String> ans = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    private int index = 0;

    public List<String> letterCombinations(String digits) {
        bt(digits, index);
        return ans;
    }

    public void bt(String digits, int index) {
        if(index == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            bt(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}