package dill.lee;

import java.util.ArrayList;
import java.util.List;

/**
 * User:krisjin
 * Date:2019-10-29
 * 括号生成
 * <pre>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * </pre>
 */
public class GenerateParentheses22 {

    //1.递归
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);

            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }


    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }


    //2.回溯

    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }

    //3.递归

    public List<String> generateParenthesis_3(int n) {
        List<String> result = new ArrayList<>();
        generate_3(0, 0, n, "", result);
        return result;
    }

    private void generate_3(int left, int right, int n, String s, List result) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left < n) generate_3(left + 1, right, n, s + "(", result);
        if (left > right) generate_3(left, right + 1, n, s + ")", result);
    }

    public static void main(String[] args) {
        GenerateParentheses22 generateParentheses22 = new GenerateParentheses22();
        List<String> dd = generateParentheses22.generateParenthesis_3(3);

        System.out.println(dd);

    }
}
