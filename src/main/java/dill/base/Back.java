package dill.base;

import java.util.LinkedList;
import java.util.List;

public class Back {
    public void dfs(String pre, String str, List<String> res, int index) {
        if (index == str.length())
            res.add(pre);
        else {
            char ch = str.charAt(index);
            if (!Character.isLetter(ch))
                dfs(pre + ch, str, res, index + 1);
            else {
                // 小写字符分支
                ch = Character.toLowerCase(ch);
                dfs(pre + ch, str, res, index + 1);
                // 大写字符分支
                ch = Character.toUpperCase(ch);
                dfs(pre + ch, str, res, index + 1);
            }
        }
    }

    public List<String> letterCasePermutation(String str) {
        List<String> res = new LinkedList<>();
        dfs("", str, res, 0);
        return res;
    }

    public static void main(String[] args) {
        String S = "a1b";
        Back to784To = new Back();
        System.out.println(to784To.letterCasePermutation(S));
    }
}
