package dill.leet;

import java.util.*;

/**
 * User:krisjin
 * Date:2019-10-31
 * 最小基因变化
 * <p>
 * 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 *
 * <pre>
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 *
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 *
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 *
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 *
 * 注意:
 *
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 示例 1:
 *
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 *
 * 返回值: 1
 * 示例 2:
 *
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 *
 * 返回值: 2
 * 示例 3:
 *
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * 返回值: 3
 *
 * </pre>
 */
public class C0433 {


    public int minMutation(String start, String end, String[] bank) {
        if (bank.length == 0) return -1;
        if (start.length() != end.length()) return -1;
        List<String> ban = Arrays.asList(bank);
        if (!ban.contains(end)) return -1;
        int cnt = backtrack(start, end, 0, ban);
        return cnt;
    }

    public int backtrack(String start, String end, int num, List<String> bank) {
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        List<String> visited = new ArrayList<>();
        String begin = start;
        for (int i = 0; i < start.length(); i++) {
            char[] temp = begin.toCharArray();
            for (char ch : charSet) {
                temp[i] = ch;
                String newStr = new String(temp);
                if (bank.contains(newStr) && !visited.contains(newStr)) {
                    num++;
                    visited.add(newStr);
                    if (end == newStr) {
                        return num;
                    }
                    begin = newStr;
                    i = -1;
                }
            }
        }
        return -1;
    }


    public int minMutation2(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] fourChar = {'A', 'C', 'G', 'T'};

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.remove(start);

        int step = 0;

        while (queue.size() > 0) {
            step++;

            for (int count = queue.size(); count > 0; --count) {
                char[] tmpQueueChar = queue.poll().toCharArray();

                for (int i = 0; i < tmpQueueChar.length; ++i) {

                    char oldChar = tmpQueueChar[i];
                    for (char c : fourChar) {
                        tmpQueueChar[i] = c;
                        String newStr = new String(tmpQueueChar);
                        if (end.equals(newStr)) {
                            return step;
                        } else if (set.contains(newStr)) {
                            set.remove(newStr);
                            queue.offer(newStr);
                        }
                    }

                    tmpQueueChar[i] = oldChar;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        String[] ret = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        C0433 c0433 = new C0433();

        char[] fourChar = {'A', 'C', 'G', 'T'};


        System.err.println(new String(fourChar));

        int a = c0433.minMutation2("AAAAACCC", "AACCCCCC", ret);
        System.out.println(a);
    }
}
