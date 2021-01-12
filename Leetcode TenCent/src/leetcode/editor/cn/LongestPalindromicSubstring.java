package leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3086 👎 0

//[5]最长回文子串
public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("babad");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        String res = "";
        // 注意循环的顺序
        for(int l=0;l<n;l++) {
            for(int i=0;i+l<n;i++) {
                int j = i + l;
                if(l == 0) f[i][j] = true;
                else if(l == 1) f[i][j] = s.charAt(i) == s.charAt(j);
                else f[i][j] = f[i+1][j-1] && s.charAt(i) == s.charAt(j);

                if(f[i][j] && l+1 > res.length()) {
                    res = s.substring(i, j+1);
                }
            }
        }

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}